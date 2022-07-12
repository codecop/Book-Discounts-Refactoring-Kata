package com.bookstore;

/**
 * Concrete books on promotion have several goodies: <br>
 * - You get a 10% discount on your next purchase.<br>
 * - You get a discount on delivery if it is heavy.<br>
 * - You get a gift wrapping for free.<br>
 */
public class PromotedBook extends AbstractItemOnOffer {

    public PromotedBook(String name) {
        this(name, new BookWeight(name));
    }

    private PromotedBook(String name, Weight weight) {
        super(name, weight, new DeliveryCostLines( // 
                new DeliveryCostPromotionHeavyWeight(weight) //
        ), new CartActions(), new CartActions(cart -> new GiftWrapping(name).putIntoMyCart(cart)));
    }

    @Override
    public void putIntoMyCart(Cart cart) {
        super.putIntoMyCart(cart);
        new DiscountVoucher(10).putIntoMyCart(cart);
    }

}
