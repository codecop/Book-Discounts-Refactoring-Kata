package com.bookstore;

public class PutItemWithVoucherIntoCart implements PutIntoCart {

    private final PutItemIntoCart putItemIntoCart = new PutItemIntoCart();

    @Override
    public void putIntoCart(Cart cart, GetItemRepresentation itemRepresentation) {
        putItemIntoCart.putIntoCart(cart, itemRepresentation);
        new DiscountVoucher(10).putIntoMyCart(cart);
    }
}
