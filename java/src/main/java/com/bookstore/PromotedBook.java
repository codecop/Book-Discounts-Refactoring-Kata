package com.bookstore;

/**
 * Concrete books on promotion have several goodies: <br>
 * - You get a 10% discount on your next purchase.<br>
 * - You get a discount on delivery if it is heavy.<br>
 * - You get a gift wrapping for free.<br>
 */
public class PromotedBook extends AbstractItemOnOffer {

    private static final int DEFAULT_WEIGHT_BOOK_GRAMMS = 500;

    public PromotedBook(String name) {
        super(name);
    }

    @Override
    public void putIntoMyCart(Cart cart) {
        cart.add(getName());
        new DiscountVoucher(10).putIntoMyCart(cart);
    }

    @Override
    protected int itemWeight() {
        if (getName().contains("C++")) {
            // C++ books are usually heavy
            return 750; // gramm

        } else if (getName().contains("Good Parts")) {
            // Good Parts are only few, so thin books
            return 100; // gramm
        }

        return DEFAULT_WEIGHT_BOOK_GRAMMS;
    }

    @Override
    protected boolean hasDiscountOnDelivery() {
        return itemWeight() >= DEFAULT_WEIGHT_BOOK_GRAMMS;
    }

    @Override
    protected void handleGiftOptions(Cart cart) {
        new GiftWrapping(this).putIntoMyCart(cart);
    }

}
