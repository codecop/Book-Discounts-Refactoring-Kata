package com.bookstore;

public class DeliveryCostForTwoOrMore implements DeliveryCostCalculator.Calculation {

    private final String bookName;

    public DeliveryCostForTwoOrMore(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public boolean use(Cart cart) {
        return cart.containsTwiceOrMore(bookName);
    }

    @Override
    public void apply(DeliveryCost deliveryCost) {
        deliveryCost.halfCost();
    }

}
