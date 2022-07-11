package com.bookstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class FullCartTest {

    @Test
    void sampleTest() {
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
    }

    @Test
    void fullTest() {
        Cart cart = new Cart();

        // simple books
        Book defaultBook = new Book("Software Design book");
        defaultBook.putIntoMyCart(cart);
        Book cppBook = new Book("C++ Functional programming");
        cppBook.putIntoMyCart(cart);
        Book goodPartsBook = new Book("JavaScript The Good Parts");
        goodPartsBook.putIntoMyCart(cart);
        GiftWrapping giftWrapping = new GiftWrapping(goodPartsBook);
        giftWrapping.putIntoMyCart(cart);

        // promoted books
        PromotedBook defaultPromotedBook = new PromotedBook("Promoted Software Design book");
        defaultPromotedBook.putIntoMyCart(cart);
        PromotedBook cppPromotedBook = new PromotedBook("Promoted C++ book");
        cppPromotedBook.putIntoMyCart(cart);
        PromotedBook goodPartsPromotedBook = new PromotedBook("Promoted Good Parts book");
        goodPartsPromotedBook.putIntoMyCart(cart);
        goodPartsPromotedBook.putIntoMyCart(cart);

        // simple books delivery
        defaultBook.prepareDeliveryIn(cart);
        assertEquals(10, defaultBook.getDeliveryCost());

        assertEquals(-1, cppBook.getDeliveryCost());
        cppBook.prepareDeliveryIn(cart);
        assertEquals(27, cppBook.getDeliveryCost());

        defaultPromotedBook.prepareDeliveryIn(cart);
        assertEquals(10, defaultPromotedBook.getDeliveryCost());

        giftWrapping.prepareDeliveryIn(cart);
        assertEquals(0, giftWrapping.getDeliveryCost());

        // promoted books delivery
        cppPromotedBook.prepareDeliveryIn(cart);
        assertEquals(10, cppPromotedBook.getDeliveryCost());

        goodPartsPromotedBook.prepareDeliveryIn(cart);
        assertEquals(5, goodPartsPromotedBook.getDeliveryCost());

        goodPartsBook.prepareDeliveryIn(cart);
        assertEquals(10, goodPartsBook.getDeliveryCost());

        assertEquals("Your cart\n" + //
                "Software Design book\n" + //
                "C++ Functional programming\n" + //
                "JavaScript The Good Parts\n" + //
                "Gift wrapping for JavaScript The Good Parts\n" + //
                "Promoted Software Design book\n" + //
                "Discount voucher for 10% on your next order\n" + //
                "Promoted C++ book\n" + //
                "Discount voucher for 10% on your next order\n" + //
                "Promoted Good Parts book\n" + //
                "Discount voucher for 10% on your next order\n" + //
                "Promoted Good Parts book\n" + //
                "Discount voucher for 10% on your next order\n" + //
                "Gift wrapping for Promoted Software Design book\n" + //
                "Gift wrapping for Promoted C++ book\n" + //
                "Gift wrapping for Promoted Good Parts book", cart.toString());
    }

    @Test
    void cannot_deliver_non_added_item() {
        assertThrows(IllegalStateException.class, () -> new Book("illegal").prepareDeliveryIn(new Cart()));
    }
}
