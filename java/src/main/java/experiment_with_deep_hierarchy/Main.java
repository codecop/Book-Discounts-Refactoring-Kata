package experiment_with_deep_hierarchy;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Cart cart = new Cart();

        Book basicItem = new Book("Usable Software Design book");
        basicItem.putIntoMyCart(cart);
        
        PromotedBook promotedItem = new PromotedBook("C++ Functional programming");
        promotedItem.putIntoMyCart(cart);
        // TODO when certain promotion is added, it reduced delivery cost of others in the cart
        // e.g. 3 for price of two

        promotedItem.updateDelivery(cart);

        assert promotedItem.getDeliveryCost() == 10;
    }
}
