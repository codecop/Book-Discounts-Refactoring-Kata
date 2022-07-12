package com.bookstore;

public interface DeliveryCostLine {

    boolean useFor(Cart cart);

    void applyTo(DeliveryCost deliveryCost);

}
