package com.bookstore;

public class DiscountVoucher implements CartAble {

    private final int percentage;

    public DiscountVoucher(int percentage) {
        this.percentage = percentage;
    }

    @Override
    public void putIntoMyCart(Cart cart) {
        cart.add("Discount voucher for " + percentage + "% on your next order");
    }

}
