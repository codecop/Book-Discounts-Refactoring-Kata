package com.bookstore;

/**
 * Base class of all our physical items. Most items are books but we also offer other things like
 * gift cards.
 */
public abstract class AbstractItem implements CartAble {

    private static final int NOT_READY_TO_DELIVER = -1;

    private final String name;
    private final DeliveryCostLines deliveryCostLines;
    private final DeliveryCostCalculator deliveryCostCalculator = new DeliveryCostCalculator();

    private boolean readyToDeliver;

    private final CartActions postAddCart;
    private final CartActions postPrepareDelivery;

    public AbstractItem(String name, DeliveryCostLines deliveryCostLines, CartActions postAddCart,
            CartActions postPrepareDelivery) {
        this.name = name;
        this.deliveryCostLines = deliveryCostLines;
        this.postAddCart = postAddCart;
        this.postPrepareDelivery = postPrepareDelivery;
    }

    public String getName() {
        return name;
    }

    @Override
    public void putIntoMyCart(Cart cart) {
        cart.add(getName());
        postAddCart.run(cart);
    }

    public void prepareDeliveryIn(Cart cart) {
        if (!cart.contains(this.name)) {
            throw new IllegalStateException("Can only calculate delivery costs for items in cart");
        }

        deliveryCostLines.forEach(costLine -> deliveryCostCalculator.apply(costLine, cart));
        markReadyToDeliver();
        postPrepareDelivery.run(cart);
    }

    protected final void markReadyToDeliver() {
        readyToDeliver = true;
    }

    public final int getDeliveryCost() {
        if (readyToDeliver) {
            return deliveryCostCalculator.calculate();
        }
        return NOT_READY_TO_DELIVER;
    }

    @Override
    public final String toString() {
        return name + " (" + getDeliveryCost() + "EUR)";
    }
}
