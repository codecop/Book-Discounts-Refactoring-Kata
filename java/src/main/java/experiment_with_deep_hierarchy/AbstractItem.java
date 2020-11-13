package experiment_with_deep_hierarchy;

public abstract class AbstractItem implements CartAble {

    private static final int NOT_READY_TO_SHIP = -1;

    protected final String name;
    private boolean readyToShip;

    protected int deliveryCost;

    public AbstractItem(String name) {
        this.name = name;
    }

    // template method
    public void calculateDeliveryCost(Cart cart) {
        if (!cart.contains(this)) {
            throw new IllegalStateException("Can only calculate costs for items in cart");
        }

        int gramms = getWeightInGramms(); // by each item
        calculateDeliveryCost(cart, gramms); // default can be overwritten
        calculationComplete();
    }

    /**
     * Every item needs to provide its weight."
     */
    protected abstract int getWeightInGramms();

    protected void calculateDeliveryCost(@SuppressWarnings("unused") Cart cart, int gramms) {
        if (gramms < 1000) {
            deliveryCost = 10;
        } else {
            deliveryCost = (int) Math.sqrt(gramms);
        }
    }

    protected void calculationComplete() {
        readyToShip = true;
    }

    public int getDeliveryCost() {
        if (readyToShip) {
            return deliveryCost;
        }
        return NOT_READY_TO_SHIP;
    }

}
