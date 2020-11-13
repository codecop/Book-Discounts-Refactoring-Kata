package experiment_with_deep_hierarchy;

public abstract class AbstractItemOnOffer extends AbstractItem {

    public AbstractItemOnOffer(String name) {
        super(name);
    }

    @Override
    public void updateDelivery(Cart cart) {
        if (false) {
            super.updateDelivery(cart);
        } else {
            putIntoMyCart(cart);
            bar2();
            abstractBar();
            privateBar();
        }
    }

    protected abstract void abstractBar();

    protected void bar2() {

    }

    protected void calculateDeliveryCost(Cart cart) {
        privateBar();
        super.calculateDeliveryCost(cart, 0);
    }

    private void privateBar() {

    }

}
