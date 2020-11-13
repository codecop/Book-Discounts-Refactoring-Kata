package experiment_with_deep_hierarchy;

public class PromotedItem extends AbstractItemOnOffer {

    public PromotedItem(String name) {
        super(name);
    }

    @Override
    public void putIntoMyCart(Cart cart) {
    }

    @Override
    protected void abstractBar() {
    }

    @Override
    protected int getWeightInGramms() {
        return 0;
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
