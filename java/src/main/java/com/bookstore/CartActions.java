package com.bookstore;

import java.util.Arrays;
import java.util.List;

public class CartActions {

    private final List<CartAction> actions;

    public static CartActions none() {
        return new CartActions();
    }

    public CartActions(CartAction... actions) {
        this(Arrays.asList(actions));
    }

    private CartActions(List<CartAction> actions) {
        this.actions = actions;
    }

    public void run(Cart cart) {
        actions.forEach(action -> action.run(cart));
    }

}
