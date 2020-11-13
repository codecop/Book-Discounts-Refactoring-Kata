package experiment_with_deep_hierarchy;

import java.util.List;

public abstract class AbstractItem implements CartAble {

    protected String bar;

    public void updateDelivery(Cart cart) {
        putIntoMyCart(cart);
        abstractFoo();
        privateFoo();
    }

    protected abstract void abstractFoo();

    protected void foo2() {

    }

    private void privateFoo() {

    }

    public List<String> getDelivery() {
        return null;
    }

}
