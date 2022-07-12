package com.bookstore;

/**
 * We provide gift wrappings for our books.
 */
public class GiftWrapping extends AbstractItem {

    public GiftWrapping(AbstractItem item) {
        super("Gift wrapping for " + item.getName(), //
                DeliveryCostLines.none() // no delivery cost
        );
    }

    @Override
    public void putIntoMyCart(Cart cart) {
        cart.add(getName());
    }

}
