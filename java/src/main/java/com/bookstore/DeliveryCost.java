package com.bookstore;

public class DeliveryCost {

    protected int deliveryCost = 0;
    private int reduceCost = 1;
    private int halfCost = 1;

    public void onlyCountHalfWeight() {
        this.reduceCost = 2;
    }

    public void basedOnWeight(int gramms) {
        if (gramms / reduceCost <= 500) {
            deliveryCost = 10 / halfCost;
        } else {
            deliveryCost = ((int) Math.sqrt(gramms / reduceCost)) / halfCost;
        }
    }

    public void halfCost() {
        this.halfCost = 2;
        // TODO temporal coupling
        deliveryCost /= 2;
    }

}
