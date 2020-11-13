package experiment_with_deep_hierarchy;

public class GiftWrapping implements CartAble {

    private final AbstractItem item;

    public GiftWrapping(AbstractItem item) {
        this.item = item;
    }

    @Override
    public void putIntoMyCart(Cart cart) {
        cart.add(this);
    }

}
