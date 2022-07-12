package com.bookstore;

/**
 * We provide gift wrappings for our books.
 */
public class GiftWrapping extends AbstractItem {

    private final Weight weight;

    public GiftWrapping(AbstractItem item) {
        super("Gift wrapping for " + item.getName());
        weight = new WrappingWeight();
    }

    @Override
    public void putIntoMyCart(Cart cart) {
        cart.add(getName());
    }

    @Override
    protected void calculateDeliveryCost(Cart cart, int gramms) {
        // no delivery cost
        markReadyToDeliver();
    }

    @Override
    protected int itemWeight() {
        return weight.itemWeight();
    }

}
