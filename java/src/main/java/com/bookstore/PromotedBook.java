package com.bookstore;

/**
 * Concrete books on promotion have several goodies: <br>
 * - You get a discount on next purchase.<br>
 * - You get a discount on shipping if it is heavy.<br>
 * - You get a gift wrapping for free.<br>
 */
public class PromotedBook extends AbstractItemOnOffer {

    private static final int DEFAULT_WEIGHT_BOOK = 999; // below 1kg

    public PromotedBook(String name) {
        super(name);
    }

    @Override
    public void putIntoMyCart(Cart cart) {
        cart.add(this);
        cart.add(new DiscountOnNextPurchase(0.1));
    }

    @Override
    protected int getWeightInGramms() {
        if (name.equals("Book")) {
            return 250;
        }

        return DEFAULT_WEIGHT_BOOK;
    }

    @Override
    protected boolean hasDiscountOnShipping() {
        return getWeightInGramms() > 500;
    }

    @Override
    protected void handleGiftOptions(Cart cart) {
        new GiftWrapping(this).putIntoMyCart(cart);
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
