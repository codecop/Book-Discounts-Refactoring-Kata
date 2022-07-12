package com.bookstore;

/**
 * Some items (i.e. books) can be on offer. Items on offer<br>
 * - Allow for a discount on delivery cost.<br>
 * - Allow for gift options.<br>
 * - Reduce the cost of delivery if you are buying two or more of the same kind.<br>
 */
public abstract class AbstractItemOnOffer extends AbstractItem {

    public AbstractItemOnOffer(String name, Weight weight) {
        super(name, weight);
    }

    @Override
    public void prepareDeliveryIn(Cart cart) {
        super.prepareDeliveryIn(cart);
        handleGiftOptions(cart);
    }

    @Override
    protected void calculateDeliveryCost(Cart cart, int gramms) {
        deliveryCost.apply(new DeliveryCost.DeliveryCostCalculation() {
            @Override
            public boolean hasDiscount() {
                return hasDiscountOnDelivery();
            }

            @Override
            public void apply(DeliveryCost deliveryCost) {
                deliveryCost.onlyCountHalfTheWeight();
            }
        });

        super.calculateDeliveryCost(cart, gramms);

        // buyTwoOnlyPayDeliveryForOne
        deliveryCost.apply(new DeliveryCost.DeliveryCostCalculation() {
            @Override
            public boolean hasDiscount() {
                return cart.containsTwiceOrMore(getName());
            }

            @Override
            public void apply(DeliveryCost deliveryCost) {
                deliveryCost.halfCost();
            }
        });
    }

    protected boolean hasDiscountOnDelivery() {
        // default no discount on delivery
        return false;
    }

    protected abstract void handleGiftOptions(Cart cart);

}
