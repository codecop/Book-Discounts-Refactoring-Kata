package com.bookstore;

public class BookWeight implements Weight {

    private static final int DEFAULT_BOOK_GRAM = 500;

    private final String bookName;

    public BookWeight(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public int gram() {
        if (bookName.contains("C++")) {
            // C++ books are usually heavy
            return 750;

        } else if (bookName.contains("Good Parts")) {
            // Good Parts are only few, so thin books
            return 100;
        }

        return DEFAULT_BOOK_GRAM;
    }

    @Override
    public boolean isHeavy() {
        return gram() >= DEFAULT_BOOK_GRAM;
    }

}
