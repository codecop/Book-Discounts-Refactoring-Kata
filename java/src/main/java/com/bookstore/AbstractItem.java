package com.bookstore;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class of all our physical items. Most items are books but we also offer other things like
 * gift cards.
 */
public abstract class AbstractItem implements CartAble {

    private static final int NOT_READY_TO_DELIVER = -1;

    private final String name;
    private final Weight weight;
    protected final List<DeliveryCostCalculator.Calculation> calcs;

    protected final DeliveryCostCalculator deliveryCostCalculator = new DeliveryCostCalculator();
    private boolean readyToDeliver;

    public AbstractItem(String name, Weight weight, List<DeliveryCostCalculator.Calculation> calcs) {
        this.name = name;
        this.weight = weight;
        this.calcs = new ArrayList<>(calcs);
    }

    public String getName() {
        return name;
    }

    public Weight getWeight() {
        return weight;
    }

    public void prepareDeliveryIn(Cart cart) {
        if (!cart.contains(this.name)) {
            throw new IllegalStateException("Can only calculate delivery costs for items in cart");
        }

        calcs.forEach(c -> deliveryCostCalculator.apply(c, cart));
        markReadyToDeliver();
    }

    protected final void markReadyToDeliver() {
        readyToDeliver = true;
    }

    public final int getDeliveryCost() {
        if (readyToDeliver) {
            return deliveryCostCalculator.calculate();
        }
        return NOT_READY_TO_DELIVER;
    }

    @Override
    public String toString() {
        return name + " (" + getDeliveryCost() + "EUR)";
    }
}
