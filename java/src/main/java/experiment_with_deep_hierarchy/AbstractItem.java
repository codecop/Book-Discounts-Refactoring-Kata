package experiment_with_deep_hierarchy;

public abstract class AbstractItem implements CartAble {

    protected String name;
    private boolean readyToShip;
    protected int deliveryCost;

    public AbstractItem(String name) {
        this.name = name;
    }

    public void updateDelivery(Cart cart) {
        // template method
        putIntoMyCart(cart);

        int gramms = getWeightInGramms(); // by each item
        calculateDeliveryCost(cart, gramms); // default can be overwritten
        calculationComplete();
    }

    /**
     * Every item needs to provide its weight."
     */
    protected abstract int getWeightInGramms();

    protected void calculateDeliveryCost(Cart cart, int gramms) {
        if (gramms < 1000) {
            deliveryCost = 10;
        } else {
            deliveryCost = (int) Math.sqrt(gramms);
        }
    }

    private void calculationComplete() {
        readyToShip = true;
    }

    public int getDeliveryCost() {
        return deliveryCost;
    }

}
