doRelativeFile("./AbstractItem.io")
/**
 * Most used item, a regular book. A book has a weight which cause delivery costs.
 */
Book := AbstractItem clone do(

    DEFAULT_WEIGHT_BOOK_GRAMMS := 500

    putIntoMyCart := method(cart,
        cart add(getName)
    )

    itemWeight := method(
        if (getName() containsSeq("C++")) then (
            // C++ books are usually heavy
            return 750; // gram

        ) elseif (getName containsSeq("Good Parts")) then (
            // Good Parts are only few, so thin books
            return 100; // gram

        ) else (
            return DEFAULT_WEIGHT_BOOK_GRAMMS
        )
    )

)
