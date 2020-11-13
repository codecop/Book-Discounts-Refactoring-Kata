package experiment_with_deep_hierarchy;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Cart cart = new Cart();

        BasicItem basicItem = new BasicItem("Usable Software Design book");
        basicItem.putIntoMyCart(cart);
        PromotedItem promotedItem = new PromotedItem("C++ Functional programming");
        promotedItem.putIntoMyCart(cart);

        promotedItem.updateDelivery(cart);

        assert promotedItem.getDelivery().equals(Arrays.asList("US", "CA"));
    }
}
