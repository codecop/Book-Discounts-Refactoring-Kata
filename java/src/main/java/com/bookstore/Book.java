package com.bookstore;

/**
 * Most used item, a regular book. A book has a weight which cause delivery costs.
 */
public class Book extends AbstractItem {

    public Book(String name) {
        super(name, new DeliveryCostLines(//
                new DeliveryCostByWeight(new BookWeight(name)) //
        ));
    }

    @Override
    public void putIntoMyCart(Cart cart) {
        cart.add(getName());
    }

}
