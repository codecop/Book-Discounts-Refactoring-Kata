package com.bookstore;

public class PutPromoItemIntoCart implements PutIntoCart {
    @Override
    public void putIntoCart(Cart cart, AbstractItem abstractItem) {
        cart.add(abstractItem.getName());
        new DiscountVoucher(10).putIntoMyCart(cart);
    }
}
