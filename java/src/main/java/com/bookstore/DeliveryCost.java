package com.bookstore;

public class DeliveryCost {

    protected int deliveryCost = 0;
    private int reduceCost = 1;

    public void basedOnWeight(int gramms) {
        if (gramms / reduceCost <= 500) {
            deliveryCost = 10;
        } else {
            deliveryCost = (int) Math.sqrt(gramms / reduceCost);
        }
    }

    public void setReduction(int reduceCost) {
        this.reduceCost = reduceCost;

    }

}
