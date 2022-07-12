package com.bookstore;

public class DeliveryCostDiscountHeavyWeight implements DeliveryCostLine {

    private final Weight weight;

    public DeliveryCostDiscountHeavyWeight(Weight weight) {
        this.weight = weight;
    }

    @Override
    public boolean useFor(Cart cart) {
        return weight.isHeavy();
    }

    @Override
    public void applyTo(DeliveryCost deliveryCost) {
        deliveryCost.onlyCountHalfTheWeight();
    }

}
