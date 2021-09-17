package com.bookstore;

public class PutItemIntoCart implements PutIntoCart {
    public PutItemIntoCart() {
    }

    @Override
    public void putIntoCart(Cart cart, AbstractItem abstractItem) {
        cart.add(abstractItem.getName());
    }
}