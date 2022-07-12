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

    public AbstractItem(String name, DeliveryCostLines deliveryCostLines) {
        this.name = name;
        this.deliveryCostLines = deliveryCostLines;
    }

    public String getName() {
        return name;
    }

    public void prepareDeliveryIn(Cart cart) {
        if (!cart.contains(this.name)) {
            throw new IllegalStateException("Can only calculate delivery costs for items in cart");
        }

        deliveryCostLines.forEach(costLine -> deliveryCostCalculator.apply(costLine, cart));
        markReadyToDeliver();
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
    public String toString() {
        return name + " (" + getDeliveryCost() + "EUR)";
    }
}
