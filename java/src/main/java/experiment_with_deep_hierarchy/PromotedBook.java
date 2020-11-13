package experiment_with_deep_hierarchy;

public class PromotedBook extends AbstractItemOnOffer {

    public PromotedBook(String name) {
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
