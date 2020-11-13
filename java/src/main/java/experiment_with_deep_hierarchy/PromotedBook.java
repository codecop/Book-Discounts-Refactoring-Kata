package experiment_with_deep_hierarchy;

public class PromotedBook extends AbstractItemOnOffer {

    public PromotedBook(String name) {
        super(name);
    }

    @Override
    public void putIntoMyCart(Cart cart) {
        cart.add(this);
    }

    @Override
    protected void handleGiftOptions(Cart cart) {
        cart.add(giftWrappingFor(this));
    }

    private CartAble giftWrappingFor(PromotedBook promotedBook) {
        return new GiftWrapping(promotedBook);
    }

    @Override
    protected boolean isHalfPrice() {
        return false;
        // TODO logic
    }

    @Override
    protected int getWeightInGramms() {
        return 0;
        // TODO logic
    }

    private static class GiftWrapping implements CartAble {

        public GiftWrapping(PromotedBook promotedBook) {
        }

        @Override
        public void putIntoMyCart(Cart cart) {

        }

    }

}
/*
 * Interface = CartAble
 * |
 * Abstract1 =  AbstractItem
 * |                        \
 * Abstract2 = OnOffer        Real1 = Book
 * |
 * Real2 = PromotedBook
 */
