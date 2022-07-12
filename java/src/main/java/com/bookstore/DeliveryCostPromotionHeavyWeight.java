package com.bookstore;

public class DeliveryCostPromotionHeavyWeight implements DeliveryCostLine {

    private final Weight weight;

    public DeliveryCostPromotionHeavyWeight(Weight weight) {
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
