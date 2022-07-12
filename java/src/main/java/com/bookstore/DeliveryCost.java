package com.bookstore;

public class DeliveryCost {

    private int reduceWeightFactor = 1;
    private int bookWeightGram = -1;
    private int reduceCostFactor = 1;

    public void onlyCountHalfTheWeight() {
        setReduceWeightByFactor(2);
    }

    private void setReduceWeightByFactor(int reduceWeightFactor) {
        this.reduceWeightFactor = reduceWeightFactor;
    }

    public void basedOnWeight(int gram) {
        bookWeightGram = gram;
    }

    public void halfCost() {
        setReduceCostByFactor(2);
    }

    private void setReduceCostByFactor(int reduceCostFactor) {
        this.reduceCostFactor = reduceCostFactor;
    }

    interface DeliveryCostCalculation {

        boolean hasDiscount();

        void apply(DeliveryCost deliveryCost);

    }

    public void apply(DeliveryCostCalculation calculation) {
        if (calculation.hasDiscount()) {
            calculation.apply(this);
        }
    }

    public int calculate() {
        if (bookWeightGram == -1) {
            // no cost
            return 0;
        }

        int gram = bookWeightGram / reduceWeightFactor;

        int cost;
        if (gram <= 500) {
            cost = 10;
        } else {
            cost = ((int) Math.sqrt(gram));
        }

        int deliveryCost = cost / reduceCostFactor;
        return deliveryCost;
    }

}
