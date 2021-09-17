package com.bookstore;

/**
 * We provide gift wrappings for our books.
 */
public class GiftWrapping extends AbstractItem {

    public GiftWrapping(AbstractItem item) {
        super("Gift wrapping for " + item.getName());
    }
    private final PutIntoCart putIntoCart = new PutItemIntoCart();

    @Override
    public void putIntoMyCart(Cart cart) {
        putIntoCart.putIntoCart(cart, this::getName);
    }

    @Override
    protected void calculateDeliveryCost(@SuppressWarnings("unused") Cart cart,
            @SuppressWarnings("unused") int gramms) {
        // no delivery cost
        markReadyToDeliver();
    }

    @Override
    protected int itemWeight() {
        return 5;
    }

}
