package com.bookstore;

import java.util.Arrays;

/**
 * Most used item, a regular book. A book has a weight which cause delivery costs.
 */
public class Book extends AbstractItem {

    public Book(String name) {
        this(name, new BookWeight(name));
    }

    private Book(String name, Weight weight) {
        super(name, weight, Arrays.asList(new DeliveryCostByWeight(weight)));
    }

    @Override
    public void putIntoMyCart(Cart cart) {
        cart.add(getName());
    }

}
