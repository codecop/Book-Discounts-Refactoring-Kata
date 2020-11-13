package com.bookstore;

/**
 * Base class of all our physical items. Most items are books but we also offer other things like gift cards.
 */
public abstract class AbstractItem implements CartAble {

    private static final int NOT_READY_TO_DELIVER = -1;

    private final String name;
    protected int deliveryCost;
    private boolean readyToDeliver;

    public AbstractItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void prepareDeliveryIn(Cart cart) {
        if (!cart.contains(this.name)) {
            throw new IllegalStateException("Can only calculate delivery costs for items in cart");
        }

        int gramms = itemWeight();
        calculateDeliveryCost(cart, gramms);
        markReadyToDeliver();
    }

    /**
     * Every item needs to provide its weight.
     */
    protected abstract int itemWeight();

    protected void calculateDeliveryCost(@SuppressWarnings("unused") Cart cart, int gramms) {
        if (gramms <= 500) {
            deliveryCost = 10;
        } else {
            deliveryCost = (int) Math.sqrt(gramms);
        }
    }

    protected final void markReadyToDeliver() {
        readyToDeliver = true;
    }

    public final int getDeliveryCost() {
        if (readyToDeliver) {
            return deliveryCost;
        }
        return NOT_READY_TO_DELIVER;
    }

    @Override
    public String toString() {
        return name + " (" + getDeliveryCost() + "EUR)";
    }
}
