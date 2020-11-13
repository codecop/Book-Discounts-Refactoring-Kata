package experiment_with_deep_hierarchy;

public class PromotedItem extends AbstractItemOnOffer {

    public PromotedItem(String name) {
    }

    @Override
    public void putIntoMyCart(Cart cart) {
    }

    @Override
    protected void abstractBar() {
    }

    @Override
    protected void abstractFoo() {
    }

}
/*
 * Interface
 * |
 * Abstract1
 * |          \
 * Abstract2   Real1
 * |
 * Real2
 */
