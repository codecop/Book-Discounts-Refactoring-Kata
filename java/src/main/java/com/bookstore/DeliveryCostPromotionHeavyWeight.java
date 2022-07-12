package com.bookstore;

public class DeliveryCostPromotionHeavyWeight implements DeliveryCostCalculator.Calculation {

    private final Weight weight;

    public DeliveryCostPromotionHeavyWeight(Weight weight) {
        this.weight = weight;
    }

    @Override
    public boolean use(Cart cart) {
        return weight.isHeavy();
    }

    @Override
    public void apply(DeliveryCost deliveryCost) {
        deliveryCost.onlyCountHalfTheWeight();
    }

}
