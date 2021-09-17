package com.bookstore;

/**
 * Concrete books on promotion have several goodies: <br>
 * - You get a 10% discount on your next purchase.<br>
 * - You get a discount on delivery if it is heavy.<br>
 * - You get a gift wrapping for free.<br>
 */

//OnOffer could be decorator
public class PromotedBook extends AbstractItemOnOffer {

    private final Book book;

    public PromotedBook(String name) {
        super(name, new PutItemWithVoucherIntoCart());
        this.book = new Book(name, new PutItemWithVoucherIntoCart());
    }

    @Override
    protected int itemWeight() {
        return this.book.itemWeight();
    }

    @Override
    protected boolean hasDiscountOnDelivery() {
        return itemWeight() >= Book.DEFAULT_WEIGHT_BOOK_GRAMMS;
    }

    @Override
    protected void handleGiftOptions(Cart cart) {
        new GiftWrapping(this).putIntoMyCart(cart);
    }

}
