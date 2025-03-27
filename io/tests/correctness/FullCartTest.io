doRelativeFile("../../io/Cart.io")
doRelativeFile("../../io/Book.io")
doRelativeFile("../../io/PromotedBook.io")
doRelativeFile("../../io/GiftWrapping.io")

FullCartTest := UnitTest clone do(

    testSample := method(
        cart := Cart clone

        basicItem := Book with("C++ Functional programming")
        basicItem putIntoMyCart(cart)

        promotedItem1 := PromotedBook with("Usable Software Design book")
        promotedItem1 putIntoMyCart(cart)
        promotedItem2 := PromotedBook with("Usable Software Design book")
        promotedItem2 putIntoMyCart(cart)

        basicItem prepareDeliveryIn(cart)
        assertEquals(27, basicItem getDeliveryCost)

        promotedItem1 prepareDeliveryIn(cart)
        assertEquals(5, promotedItem1 getDeliveryCost)

        promotedItem2 prepareDeliveryIn(cart)
        assertEquals(5, promotedItem2 getDeliveryCost)
    )

    testFull := method(
        cart := Cart clone

        // simple books
        defaultBook := Book with("Software Design book")
        defaultBook putIntoMyCart(cart)
        cppBook := Book with("C++ Functional programming")
        cppBook putIntoMyCart(cart)
        goodPartsBook := Book with("JavaScript The Good Parts")
        goodPartsBook putIntoMyCart(cart)
        giftWrapping := GiftWrapping with(goodPartsBook)
        giftWrapping putIntoMyCart(cart)

        // promoted books
        defaultPromotedBook := PromotedBook with("Promoted Software Design book")
        defaultPromotedBook putIntoMyCart(cart)
        cppPromotedBook := PromotedBook with("Promoted C++ book")
        cppPromotedBook putIntoMyCart(cart)
        goodPartsPromotedBook := PromotedBook with("Promoted Good Parts book")
        goodPartsPromotedBook putIntoMyCart(cart)
        goodPartsPromotedBook putIntoMyCart(cart)

        // simple books delivery
        defaultBook prepareDeliveryIn(cart)
        assertEquals(10, defaultBook getDeliveryCost)

        assertEquals(-1, cppBook getDeliveryCost)
        cppBook prepareDeliveryIn(cart)
        assertEquals(27, cppBook getDeliveryCost)

        defaultPromotedBook prepareDeliveryIn(cart)
        assertEquals(10, defaultPromotedBook getDeliveryCost)

        giftWrapping prepareDeliveryIn(cart)
        assertEquals(0, giftWrapping getDeliveryCost)

        // promoted books delivery
        cppPromotedBook prepareDeliveryIn(cart)
        assertEquals(10, cppPromotedBook getDeliveryCost)

        goodPartsPromotedBook prepareDeliveryIn(cart)
        assertEquals(5, goodPartsPromotedBook getDeliveryCost)

        goodPartsBook prepareDeliveryIn(cart)
        assertEquals(10, goodPartsBook getDeliveryCost)

        assertEquals("Your cart\n" .. //
                "Software Design book\n" .. //
                "C++ Functional programming\n" .. //
                "JavaScript The Good Parts\n" .. //
                "Gift wrapping for JavaScript The Good Parts\n" .. //
                "Promoted Software Design book\n" .. //
                "Discount voucher for 10% on your next order\n" .. //
                "Promoted C++ book\n" .. //
                "Discount voucher for 10% on your next order\n" .. //
                "Promoted Good Parts book\n" .. //
                "Discount voucher for 10% on your next order\n" .. //
                "Promoted Good Parts book\n" .. //
                "Discount voucher for 10% on your next order\n" .. //
                "Gift wrapping for Promoted Software Design book\n" .. //
                "Gift wrapping for Promoted C++ book\n" .. //
                "Gift wrapping for Promoted Good Parts book", cart asString)
    )

    testCannotDeliverNonAddedItem := method(
        e := try( Book with("illegal") prepareDeliveryIn(Cart clone) )
        e catch(Exception,
            assertEquals("Can only calculate delivery costs for items in cart", e error)
        )
    )
)
