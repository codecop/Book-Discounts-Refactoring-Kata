package com.bookstore;

public class DeliveryCostDiscountForTwoOrMore implements DeliveryCostLine {

    private final String bookName;

    public DeliveryCostDiscountForTwoOrMore(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public boolean useFor(Cart cart) {
        return cart.containsTwiceOrMore(bookName);
    }

    @Override
    public void applyTo(DeliveryCost deliveryCost) {
        deliveryCost.halfCost();
    }

}
