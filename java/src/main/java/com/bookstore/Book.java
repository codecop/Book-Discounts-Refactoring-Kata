package com.bookstore;

/**
 * Most used item, a regular book. A book has a weight which cause delivery costs.
 */
public class Book extends AbstractItem {

    private static final int DEFAULT_WEIGHT_BOOK_GRAMMS = 500;

    public Book(String name) {
        super(name);
    }

    @Override
    protected int itemWeight() {
        if (getName().contains("C++")) {
            // C++ books are usually heavy
            return 750; // gramm

        } else if (getName().contains("Good Parts")) {
            // Good Parts are only few, so thin books
            return 100; // gramm
        }

        return DEFAULT_WEIGHT_BOOK_GRAMMS;
    }

}
