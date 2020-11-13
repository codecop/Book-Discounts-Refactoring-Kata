package com.bookstore;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FullCartTest {

    @Test
    void fullTest() {
        Cart cart = new Cart();

        Book basicItem = new Book("C++ Functional programming");
        basicItem.putIntoMyCart(cart);

        PromotedBook promotedItem1 = new PromotedBook("Usable Software Design book");
        promotedItem1.putIntoMyCart(cart);
        PromotedBook promotedItem2 = new PromotedBook("Usable Software Design book");
        promotedItem2.putIntoMyCart(cart);

        basicItem.prepareDeliveryIn(cart);
        assertEquals(27, basicItem.getDeliveryCost());

        promotedItem1.prepareDeliveryIn(cart);
        assertEquals(5, promotedItem1.getDeliveryCost());

        promotedItem2.prepareDeliveryIn(cart);
        assertEquals(5, promotedItem2.getDeliveryCost());

        // System.out.println(cart.toString());
    }
}
