package com.bookstore;

public class DeliveryCostForTwoOrMore implements DeliveryCostCalculator.Calculation {

    private final String bookName;
    private final Cart cart;

    public DeliveryCostForTwoOrMore(String bookName, Cart cart) {
        this.bookName = bookName;
        this.cart = cart;
    }

    @Override
    public boolean use() {
        return cart.containsTwiceOrMore(bookName);
    }

    @Override
    public void apply(DeliveryCost deliveryCost) {
        deliveryCost.halfCost();
    }

}
