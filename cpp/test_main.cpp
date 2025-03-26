//
// Created by mille on 28-Sep-22.
//

#include "catch2/catch_test_macros.hpp"

#include "include/Cart.h"
#include "include/Book.h"
#include "include/PromotedBook.h"
#include "include/GiftWrapping.h"

namespace bookstore {
  TEST_CASE("sampleTestt") {
    Cart cart;
    Book basicItem("C++ Functional programming");
    basicItem.putIntoMyCart(cart);

    PromotedBook promotedItem1("Usable Software Design book");
    promotedItem1.putIntoMyCart(cart);
    PromotedBook promotedItem2("Usable Software Design book");
    promotedItem2.putIntoMyCart(cart);

    basicItem.prepareDeliveryIn(cart);
    REQUIRE(27 == basicItem.getDeliveryCost());

    promotedItem1.prepareDeliveryIn(cart);
    REQUIRE(5 == promotedItem1.getDeliveryCost());

    promotedItem2.prepareDeliveryIn(cart);
    REQUIRE(5 == promotedItem2.getDeliveryCost());
  }

  TEST_CASE("fullTest") {
    Cart cart;

    // simple books
    Book defaultBook("Software Design book");
    defaultBook.putIntoMyCart(cart);
    Book cppBook("C++ Functional programming");
    cppBook.putIntoMyCart(cart);
    Book goodPartsBook("JavaScript The Good Parts");
    goodPartsBook.putIntoMyCart(cart);
    GiftWrapping giftWrapping(goodPartsBook);
    giftWrapping.putIntoMyCart(cart);

    // promoted books
    PromotedBook defaultPromotedBook("Promoted Software Design book");
    defaultPromotedBook.putIntoMyCart(cart);
    PromotedBook cppPromotedBook("Promoted C++ book");
    cppPromotedBook.putIntoMyCart(cart);
    PromotedBook goodPartsPromotedBook("Promoted Good Parts book");
    goodPartsPromotedBook.putIntoMyCart(cart);
    goodPartsPromotedBook.putIntoMyCart(cart);

    // simple books delivery
    defaultBook.prepareDeliveryIn(cart);
    REQUIRE(10 == defaultBook.getDeliveryCost());

    REQUIRE(-1 == cppBook.getDeliveryCost());
    cppBook.prepareDeliveryIn(cart);
    REQUIRE(27 == cppBook.getDeliveryCost());

    defaultPromotedBook.prepareDeliveryIn(cart);
    REQUIRE(10 == defaultPromotedBook.getDeliveryCost());

    giftWrapping.prepareDeliveryIn(cart);
    REQUIRE(0 == giftWrapping.getDeliveryCost());

    // promoted books delivery
    cppPromotedBook.prepareDeliveryIn(cart);
    REQUIRE(10 == cppPromotedBook.getDeliveryCost());

    goodPartsPromotedBook.prepareDeliveryIn(cart);
    REQUIRE(5 == goodPartsPromotedBook.getDeliveryCost());

    goodPartsBook.prepareDeliveryIn(cart);
    REQUIRE(10 == goodPartsBook.getDeliveryCost());

    REQUIRE("Your cart\n" \
                 "Software Design book\n" \
                 "C++ Functional programming\n" \
                 "JavaScript The Good Parts\n" \
                 "Gift wrapping for JavaScript The Good Parts\n" \
                 "Promoted Software Design book\n" \
                 "Discount voucher for 10% on your next order\n" \
                 "Promoted C++ book\n" \
                 "Discount voucher for 10% on your next order\n" \
                 "Promoted Good Parts book\n" \
                 "Discount voucher for 10% on your next order\n" \
                 "Promoted Good Parts book\n" \
                 "Discount voucher for 10% on your next order\n" \
                 "Gift wrapping for Promoted Software Design book\n" \
                 "Gift wrapping for Promoted C++ book\n" \
                 "Gift wrapping for Promoted Good Parts book\n" == cart.toString());
  }

  TEST_CASE("cannot_deliver_non_added_item") {
    Cart cart;
    REQUIRE_THROWS(Book("illegal").prepareDeliveryIn(cart));
  }
}