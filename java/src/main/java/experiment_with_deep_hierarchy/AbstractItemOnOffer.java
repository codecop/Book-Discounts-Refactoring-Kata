package experiment_with_deep_hierarchy;

public abstract class AbstractItemOnOffer extends AbstractItem {

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

    protected void foo2() {
        privateBar();
        super.foo2();
    }

    private void privateBar() {

    }

}
