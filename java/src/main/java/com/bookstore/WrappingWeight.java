package com.bookstore;

public class WrappingWeight implements Weight {

    @Override
    public int itemWeight() {
        return 5;
    }

    @Override
    public boolean isHeavy() {
        return false;
    }

}
