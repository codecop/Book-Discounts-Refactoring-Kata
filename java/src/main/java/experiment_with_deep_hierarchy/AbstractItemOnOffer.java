package experiment_with_deep_hierarchy;

public abstract class AbstractItemOnOffer extends AbstractItem {

    public AbstractItemOnOffer(String name) {
        super(name);
    }

    @Override
    public void updateDelivery(Cart cart) {
        super.updateDelivery(cart);
        handleGiftOptions(cart);
    }

    @Override
    protected void calculateDeliveryCost(Cart cart, int gramms) {
        if (isHalfPrice()) {
            gramms /= 2;
        }
        super.calculateDeliveryCost(cart, gramms);
        buyTwoOnlyPayShippingForOne(cart);
    }

    protected abstract boolean isHalfPrice();

    private void buyTwoOnlyPayShippingForOne(Cart cart) {
        if (cart.containsTwice(name)) {
            deliveryCost /= 2;
        }
    }

    protected abstract void handleGiftOptions(Cart cart);

}
