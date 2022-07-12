package com.bookstore;

/**
 * Some items (i.e. books) can be on offer. Items on offer<br>
 * - Allow for a discount on delivery cost.<br>
 * - Allow for gift options.<br>
 * - Reduce the cost of delivery if you are buying two or more of the same kind.<br>
 */
public abstract class AbstractItemOnOffer extends AbstractItem {

    public AbstractItemOnOffer(String name, Weight weight, DeliveryCostLines deliveryCostParts) {
        super(name, weight, //
                deliveryCostParts.add(new DeliveryCostByWeight(weight), new DeliveryCostForTwoOrMore(name)));
    }

    @Override
    public void prepareDeliveryIn(Cart cart) {
        super.prepareDeliveryIn(cart);
        handleGiftOptions(cart);
    }

    protected abstract void handleGiftOptions(Cart cart);

}
