package com.bookstore;

public class DeliveryCostByWeight implements DeliveryCostCalculator.Calculation {

    private final Weight weight;

    public DeliveryCostByWeight(Weight weight) {
        this.weight = weight;
    }

    @Override
    public boolean use(Cart cart) {
        return true;
    }

    @Override
    public void apply(DeliveryCost deliveryCost) {
        deliveryCost.basedOnWeight(weight.gram());
    }

}
