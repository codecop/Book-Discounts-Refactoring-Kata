package com.bookstore;

public class DeliveryCostForTwoOrMore implements DeliveryCostLine {

    private final String bookName;

    public DeliveryCostForTwoOrMore(String bookName) {
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
