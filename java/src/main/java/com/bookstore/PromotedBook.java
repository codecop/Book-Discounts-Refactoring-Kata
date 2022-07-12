package com.bookstore;

/**
 * Concrete books on promotion have several goodies: <br>
 * - You get a 10% discount on your next purchase.<br>
 * - You get a discount on delivery if it is heavy.<br>
 * - You get a gift wrapping for free.<br>
 */
public class PromotedBook extends AbstractItemOnOffer {

    public PromotedBook(String name) {
        super(name, new BookWeight(name));
        super.calcs.add(new DeliveryCostPromotionHeavyWeight(getWeight())); // hack
    }

    @Override
    public void putIntoMyCart(Cart cart) {
        cart.add(getName());
        new DiscountVoucher(10).putIntoMyCart(cart);
    }

    @Override
    protected void handleGiftOptions(Cart cart) {
        new GiftWrapping(this).putIntoMyCart(cart);
    }

}
