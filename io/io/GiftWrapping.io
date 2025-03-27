doRelativeFile("./AbstractItem.io")
/**
 * We provide gift wrappings for our books.
 */
GiftWrapping := AbstractItem clone do(

    with := method(item,
        super(with("Gift wrapping for " .. item getName))
    )

    putIntoMyCart := method(cart,
        cart add(getName)
    )

    calculateDeliveryCost := method(cart, grams,
        // no delivery cost
        markReadyToDeliver()
    )

    itemWeight := method(
        5
    )

)
