package com.bookstore;

import java.util.Arrays;
import java.util.List;

/**
 * Some items (i.e. books) can be on offer. Items on offer<br>
 * - Allow for a discount on delivery cost.<br>
 * - Allow for gift options.<br>
 * - Reduce the cost of delivery if you are buying two or more of the same kind.<br>
 */
public abstract class AbstractItemOnOffer extends AbstractItem {

    private class DeliveryCostPromotionHeavyWeight implements DeliveryCostCalculator.Calculation {
        @Override
        public boolean use(Cart cart) {
            return hasDiscountOnDelivery();
        }

        @Override
        public void apply(DeliveryCost deliveryCost) {
            deliveryCost.onlyCountHalfTheWeight();
        }
    }

    public AbstractItemOnOffer(String name, Weight weight) {
        super(name, weight, Arrays.asList(new DeliveryCostByWeight(weight), //
                new DeliveryCostForTwoOrMore(name)));
        super.calcs.add(new DeliveryCostPromotionHeavyWeight()); // hack
    }

    @Override
    public void prepareDeliveryIn(Cart cart) {
        super.prepareDeliveryIn(cart);
        handleGiftOptions(cart);
    }

    protected boolean hasDiscountOnDelivery() {
        // default no discount on delivery
        return false;
    }

    protected abstract void handleGiftOptions(Cart cart);

}
