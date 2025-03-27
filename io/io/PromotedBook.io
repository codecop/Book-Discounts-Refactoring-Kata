doRelativeFile("./AbstractItemOnOffer.io")
doRelativeFile("./DiscountVoucher.io")
doRelativeFile("./GiftWrapping.io")
/**
 * Concrete books on promotion have several goodies:<br>
 * - You get a 10% discount on your next purchase.<br>
 * - You get a discount on delivery if it is heavy.<br>
 * - You get a gift wrapping for free.<br>
 */
PromotedBook := AbstractItemOnOffer clone do(

    DEFAULT_WEIGHT_BOOK_GRAMMS := 500

    putIntoMyCart := method(cart,
        cart add(getName)
        DiscountVoucher with(10) putIntoMyCart(cart)
    )

    itemWeight := method(
        if (getName() containsSeq("C++")) then (
            // C++ books are usually heavy
            return 750 // gram

        ) elseif (getName containsSeq("Good Parts")) then (
            // Good Parts are only few, so thin books
            return 100 // gram

        ) else (
            return DEFAULT_WEIGHT_BOOK_GRAMMS
        )
    )

    hasDiscountOnDelivery := method(
        itemWeight >= DEFAULT_WEIGHT_BOOK_GRAMMS
    )

    handleGiftOptions := method(cart,
        GiftWrapping with(self) putIntoMyCart(cart)
    )

)
