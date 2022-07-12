package com.bookstore;

public class DeliveryCostCalculator {

    private final DeliveryCost deliveryCost = new DeliveryCost();

    public void apply(DeliveryCostLine costLine, Cart cart) {
        if (costLine.useFor(cart)) {
            costLine.applyTo(deliveryCost);
        }
    }

    public int calculate() {
        return deliveryCost.calculate();
    }

}
