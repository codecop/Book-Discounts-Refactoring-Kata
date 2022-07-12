package com.bookstore;

public class BookWeight implements Weight {

    private static final int DEFAULT_WEIGHT_BOOK_GRAMMS = 500;

    private final String name;

    public BookWeight(String name) {
        this.name = name;
    }

    @Override
    public int itemWeight() {
        if (name.contains("C++")) {
            // C++ books are usually heavy
            return 750; // gramm

        } else if (name.contains("Good Parts")) {
            // Good Parts are only few, so thin books
            return 100; // gramms
        }

        return DEFAULT_WEIGHT_BOOK_GRAMMS;
    }

    @Override
    public boolean isHeavy() {
        return itemWeight() >= DEFAULT_WEIGHT_BOOK_GRAMMS;
    }

}
