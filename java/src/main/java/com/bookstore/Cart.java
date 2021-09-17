package com.bookstore;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The shopping cart. The cart stores the names (IDs) of the items in the cart.
 */
public class Cart {

    private final List<String> itemRepresentations = new ArrayList<>();

    public void add(String itemRepresentation) {
        itemRepresentations.add(itemRepresentation);
    }

    public boolean contains(String item) {
        return itemRepresentations.contains(item);
    }

    public boolean containsTwiceOrMore(String itemRepresentation) {
        return itemRepresentations.stream(). //
                filter(i -> i.equalsIgnoreCase(itemRepresentation)). //
                count() >= 2;
    }

    @Override
    public String toString() {
        return "Your cart\n" + //
                itemRepresentations.stream().collect(Collectors.joining("\n"));
    }
}
