package com.bookstore;

import java.util.Collections;

/**
 * We provide gift wrappings for our books.
 */
public class GiftWrapping extends AbstractItem {

    public GiftWrapping(AbstractItem item) {
        super("Gift wrapping for " + item.getName(), //
                new WrappingWeight(), //
                Collections.emptyList() // no delivery cost
        );
    }

    @Override
    public void putIntoMyCart(Cart cart) {
        cart.add(getName());
    }

}
