package com.bookstore;

/**
 * Base class of all our physical items. Most items are books but we also offer other things like
 * gift cards.
 */
public abstract class AbstractItem implements CartAble {

    private static final int NOT_READY_TO_DELIVER = -1;

    private final String name;
    private final DeliveryCostLines deliveryCostLines;
    private final CartActions postAddCartActions;
    private final CartActions postPrepareDeliveryActions;

    private final DeliveryCostCalculator deliveryCostCalculator = new DeliveryCostCalculator();
    private boolean readyToDeliver;

    public AbstractItem(String name, DeliveryCostLines deliveryCostLines) {
        this(name, deliveryCostLines, CartActions.none(), CartActions.none());
    }

    public AbstractItem(String name, DeliveryCostLines deliveryCostLines, //
            CartActions postAddCart, CartActions postPrepareDelivery) {
        this.name = name;
        this.deliveryCostLines = deliveryCostLines;
        this.postAddCartActions = postAddCart;
        this.postPrepareDeliveryActions = postPrepareDelivery;
    }

    public String getName() {
        return name;
    }

    @Override
    public void putIntoMyCart(Cart cart) {
        cart.add(this.name);
        postAddCartActions.run(cart);
    }

    public void prepareDeliveryIn(Cart cart) {
        if (!cart.contains(this.name)) {
            throw new IllegalStateException("Can only calculate delivery costs for items in cart");
        }

        deliveryCostLines.forEach(costLine -> deliveryCostCalculator.apply(costLine, cart));

        readyToDeliver = true;

        postPrepareDeliveryActions.run(cart);
    }

    public final int getDeliveryCost() {
        if (readyToDeliver) {
            return deliveryCostCalculator.calculate();
        }
        return NOT_READY_TO_DELIVER;
    }

    @Override
    public String toString() {
        return name + " (" + getDeliveryCost() + "EUR)";
    }
}
