/**
 * The shopping cart. The cart stores the names (IDs) of the items in the cart.
 */
Cart := Object clone do(

    init := method(
        self items := list
    )

    add := method(item,
        items append(item)
    )

    contains := method(item,
        items contains(item)
    )

    containsTwiceOrMore := method(item,
        items select(i, i isEqualAnyCase(item)) size >= 2
    )

    asString = method(
        "Your cart\n" .. (items join("\n"))
    )

)
