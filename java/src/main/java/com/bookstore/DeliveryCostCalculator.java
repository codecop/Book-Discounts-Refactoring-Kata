package com.bookstore;

public class DeliveryCostCalculator {

    private final DeliveryCost deliveryCost = new DeliveryCost();

    interface Calculation {

        boolean use();

        void apply(DeliveryCost deliveryCost);

    }

    public void apply(Calculation calculation) {
        if (calculation.use()) {
            calculation.apply(deliveryCost);
        }
    }

    public int calculate() {
        return deliveryCost.calculate();
    }

}
