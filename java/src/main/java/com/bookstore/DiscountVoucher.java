package com.bookstore;

public class DiscountVoucher implements CartAble {

    private final int percentage;
    private final PutIntoCart putIntoCart = new PutItemIntoCart();

    public DiscountVoucher(int percentage) {
        this.percentage = percentage;
    }

    @Override
    public void putIntoMyCart(Cart cart) {
        putIntoCart.putIntoCart(cart, () -> "Discount voucher for " + percentage + "% on your next order");
    }

}
