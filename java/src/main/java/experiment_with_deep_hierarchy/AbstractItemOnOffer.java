package experiment_with_deep_hierarchy;

public abstract class AbstractItemOnOffer extends AbstractItem {

    public AbstractItemOnOffer(String name) {
        super(name);
    }

    @Override
    public void calculateDeliveryCost(Cart cart) {
        super.calculateDeliveryCost(cart);
        handleGiftOptions(cart);
    }

    @Override
    protected void calculateDeliveryCost(Cart cart, int gramms) {
        if (hasDiscountOnShipping()) {
            gramms /= 2;
        }

        super.calculateDeliveryCost(cart, gramms);

        buyTwoOnlyPayShippingForOne(cart);
    }

    protected boolean hasDiscountOnShipping() {
        return false;
    }

    private void buyTwoOnlyPayShippingForOne(Cart cart) {
        if (cart.containsTwice(name)) {
            deliveryCost /= 2;
        }
    }

    protected abstract void handleGiftOptions(Cart cart);

}
