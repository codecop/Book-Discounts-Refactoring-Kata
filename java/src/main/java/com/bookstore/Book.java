package com.bookstore;

/**
 * Basic items < 1kg
 */
public class Book extends AbstractItem {

    private static final int DEFAULT_WEIGHT_BOOK = 999; // below 1kg

    public Book(String name) {
        super(name);
    }

    @Override
    public void putIntoMyCart(Cart cart) {
        cart.add(this);
    }

    @Override
    protected int getWeightInGramms() {
        if (name.equals("Book")) {
            return 250;
        }

        return DEFAULT_WEIGHT_BOOK;
    }

}
