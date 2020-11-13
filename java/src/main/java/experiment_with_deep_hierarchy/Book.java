package experiment_with_deep_hierarchy;

/**
 * Basic items < 1kg
 */
public class Book extends AbstractItem {

    public Book(String name) {
        super(name);
    }

    @Override
    public void putIntoMyCart(Cart cart) {
        cart.add(this);
    }

    @Override
    protected int getWeightInGramms() {
        if (name.equals("Book")) {
            return 250;

        }
        return 999; // below 1kg
    }

}
