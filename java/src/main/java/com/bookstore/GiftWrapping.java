package com.bookstore;

/**
 * We provide gift wrappings for our books.
 */
public class GiftWrapping extends AbstractItem {

    public GiftWrapping(AbstractItem item) {
        super("Gift wrapping for " + item.getName(), new WrappingWeight());
    }

    @Override
    public void putIntoMyCart(Cart cart) {
        cart.add(getName());
    }

    @Override
    protected void calculateDeliveryCost(Cart cart, int gramms) {
        // no delivery cost
        // deliveryCost.deliveryCost = 0;
    }

}
