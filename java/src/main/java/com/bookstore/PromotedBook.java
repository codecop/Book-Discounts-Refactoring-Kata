package com.bookstore;

/**
 * Concrete books on promotion have several goodies: <br>
 * - You get a 10% discount on your next purchase.<br>
 * - You get a discount on delivery if it is heavy.<br>
 * - You get a gift wrapping for free.<br>
 */
public class PromotedBook extends AbstractItemOnOffer {

    private final Weight weight;

    public PromotedBook(String name) {
        super(name, new BookWeight(name));
        weight = new BookWeight(name);
    }

    @Override
    public void putIntoMyCart(Cart cart) {
        cart.add(getName());
        new DiscountVoucher(10).putIntoMyCart(cart);
    }

    @Override
    protected boolean hasDiscountOnDelivery() {
        return weight.isHeavy();
    }

    @Override
    protected void handleGiftOptions(Cart cart) {
        new GiftWrapping(this).putIntoMyCart(cart);
    }

}
