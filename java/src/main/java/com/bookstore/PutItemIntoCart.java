package com.bookstore;

public class PutItemIntoCart implements PutIntoCart {

    @Override
    public void putIntoCart(Cart cart, GetItemRepresentation itemRepresentation) {
        cart.add(itemRepresentation.get());
    }
}