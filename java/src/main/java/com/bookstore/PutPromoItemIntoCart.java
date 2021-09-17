package com.bookstore;

public class PutPromoItemIntoCart implements PutIntoCart {

    @Override
    public void putIntoCart(Cart cart, GetItemRepresentation itemRepresentation) {
        cart.add(itemRepresentation.get());
        new DiscountVoucher(10).putIntoMyCart(cart);
    }
}
