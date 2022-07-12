package com.bookstore;

/**
 * We provide gift wrappings for our books.
 */
public class GiftWrapping extends AbstractItem {

    public GiftWrapping(AbstractItem item) {
        this(item.getName());
    }

    public GiftWrapping(String itemName) {
        super("Gift wrapping for " + itemName, //
                DeliveryCostLines.none(), // no delivery cost
                CartActions.none(), CartActions.none());
    }

    @Override
    public void putIntoMyCart(Cart cart) {
        cart.add(getName());
    }

}
