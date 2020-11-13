package experiment_with_deep_hierarchy;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractItem implements CartAble {

    protected String name;
    protected List<String> delivery = new ArrayList<>();
    protected int deliveryCost;

    public AbstractItem(String name) {
        this.name = name;
    }

    public void updateDelivery(Cart cart) {
        putIntoMyCart(cart);
        int gramms = getWeightInGramms(); // by each item
        calculateDeliveryCost(cart, gramms); // default can be overwritten
        privateFoo();
    }

    protected abstract int getWeightInGramms();

    protected void calculateDeliveryCost(Cart cart, int gramms) {
        if (gramms < 1000) {
            deliveryCost = 10;
        } else {
            deliveryCost = (int) Math.sqrt(gramms);
        }
    }

    private void privateFoo() {

    }

    public int getDeliveryCost() {
        return deliveryCost;
    }

}
