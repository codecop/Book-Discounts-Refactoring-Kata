package com.bookstore;

public class DeliveryCostByWeight implements DeliveryCostLine {

    private final Weight weight;

    public DeliveryCostByWeight(Weight weight) {
        this.weight = weight;
    }

    @Override
    public boolean useFor(Cart cart) {
        return true;
    }

    @Override
    public void applyTo(DeliveryCost deliveryCost) {
        deliveryCost.basedOnWeight(weight.gram());
    }

}
