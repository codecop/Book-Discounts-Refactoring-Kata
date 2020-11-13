package com.bookstore;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The shopping cart. The cart stores the names (IDs) of the items in the cart.
 */
public class Cart {

    private final List<String> items = new ArrayList<>();

    public void add(String item) {
        items.add(item);
    }

    public boolean contains(String item) {
        return items.contains(item);
    }

    public boolean containsTwiceOrMore(String item) {
        return items.stream(). //
                filter(i -> i.equalsIgnoreCase(item)). //
                count() >= 2;
    }

    @Override
    public String toString() {
        return "Your cart\n" + //
                items.stream().collect(Collectors.joining("\n"));
    }
}
