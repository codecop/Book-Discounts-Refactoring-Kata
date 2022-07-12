package com.bookstore;

/**
 * Base class of all our physical items. Most items are books but we also offer other things like
 * gift cards.
 */
public abstract class AbstractItem implements CartAble {

    private static final int NOT_READY_TO_DELIVER = -1;

    private final String name;
    private final Weight weight;

    protected final DeliveryCost deliveryCost = new DeliveryCost();
    private boolean readyToDeliver;

    public AbstractItem(String name, Weight weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public Weight getWeight() {
        return weight;
    }

    public void prepareDeliveryIn(Cart cart) {
        if (!cart.contains(this.name)) {
            throw new IllegalStateException("Can only calculate delivery costs for items in cart");
        }

        int gramms = weight.gram();
        calculateDeliveryCost(cart, gramms);
        markReadyToDeliver();
    }

    protected void calculateDeliveryCost(@SuppressWarnings("unused") Cart cart, int gramms) {
        deliveryCost.apply(new DeliveryCost.DeliveryCostCalculation() {
            @Override
            public boolean hasDiscount() {
                return true;
            }

            @Override
            public void apply(DeliveryCost deliveryCost) {
                deliveryCost.basedOnWeight(weight.gram());
            }
        });
    }

    protected final void markReadyToDeliver() {
        readyToDeliver = true;
    }

    public final int getDeliveryCost() {
        if (readyToDeliver) {
            return deliveryCost.calculate();
        }
        return NOT_READY_TO_DELIVER;
    }

    @Override
    public String toString() {
        return name + " (" + getDeliveryCost() + "EUR)";
    }
}
