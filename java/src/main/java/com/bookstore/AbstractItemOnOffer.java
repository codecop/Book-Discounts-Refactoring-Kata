package com.bookstore;

/**
 * Some items (i.e. books) can be on offer. Items on offer<br>
 * - Allow for a discount on delivery cost.<br>
 * - Allow for gift options.<br>
 * - Reduce the cost of delivery if you are buying two or more of the same kind.<br>
 */
public abstract class AbstractItemOnOffer extends AbstractItem {

    private class DeliveryCostPromotionHeavyWeight implements DeliveryCostCalculator.Calculation {
        @Override
        public boolean use() {
            return hasDiscountOnDelivery();
        }

        @Override
        public void apply(DeliveryCost deliveryCost) {
            deliveryCost.onlyCountHalfTheWeight();
        }
    }

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
        deliveryCostCalculator.apply(new DeliveryCostPromotionHeavyWeight());

        super.calculateDeliveryCost(cart, gramms);

        // buyTwoOnlyPayDeliveryForOne
        deliveryCostCalculator.apply(new DeliveryCostForTwoOrMore(getName(), cart));
    }

    protected boolean hasDiscountOnDelivery() {
        // default no discount on delivery
        return false;
    }

    protected abstract void handleGiftOptions(Cart cart);

}
