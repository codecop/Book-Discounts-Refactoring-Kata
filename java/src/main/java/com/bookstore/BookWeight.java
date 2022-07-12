package com.bookstore;

public class BookWeight {

    private static final int DEFAULT_WEIGHT_BOOK_GRAMMS = 500;

    private final String name;

    public BookWeight(String name) {
        this.name = name;
    }

    private String getName() {
        return name;
    }

    public int itemWeight() {
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
