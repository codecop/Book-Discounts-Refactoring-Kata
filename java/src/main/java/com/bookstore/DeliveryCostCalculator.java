package com.bookstore;

public class DeliveryCostCalculator {

    private final DeliveryCost deliveryCost = new DeliveryCost();

    interface Calculation { // TODO DeliveryCostPart 

        boolean use(Cart cart);

        void apply(DeliveryCost deliveryCost);

    }

    public void apply(Calculation calculation, Cart cart) {
        if (calculation.use(cart)) {
            calculation.apply(deliveryCost);
        }
    }

    public int calculate() {
        return deliveryCost.calculate();
    }

}
