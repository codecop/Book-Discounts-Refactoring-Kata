package com.bookstore;

public class DeliveryCost {

    protected int deliveryCost;

    public void basedOnWeight(int gramms) {
        if (gramms <= 500) {
            deliveryCost = 10;
        } else {
            deliveryCost = (int) Math.sqrt(gramms);
        }
    }

}
