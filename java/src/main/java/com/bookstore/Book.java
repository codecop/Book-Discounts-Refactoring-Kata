package com.bookstore;

/**
 * Most used item, a regular book. A book has a weight which cause delivery costs.
 */
public class Book extends AbstractItem {

    private final Weight weight;

    public Book(String name) {
        super(name);
        weight = new BookWeight(name);
    }

    @Override
    public void putIntoMyCart(Cart cart) {
        cart.add(getName());
    }

    @Override
    protected int itemWeight() {
        return weight.itemWeight();
    }

}
