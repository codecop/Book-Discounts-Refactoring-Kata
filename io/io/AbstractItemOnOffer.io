doRelativeFile("./AbstractItem.io")
/**
 * Some items (i.e. books) can be on offer. Items on offer<br>
 * - Allow for a discount on delivery cost.<br>
 * - Allow for gift options.<br>
 * - Reduce the cost of delivery if you are buying two or more of the same kind.<br>
 */
AbstractItemOnOffer := AbstractItem clone do(

    prepareDeliveryIn := method(cart,
        super(prepareDeliveryIn(cart))
        handleGiftOptions(cart)
    )

    calculateDeliveryCost := method(cart, grams,
        reduceCost := 1
        if (hasDiscountOnDelivery,
            reduceCost = 2
        )

        super(calculateDeliveryCost(cart, grams / reduceCost))

        buyTwoOnlyPayDeliveryForOne(cart)
    )

    hasDiscountOnDelivery := method(
        // default no discount on delivery
        false
    )

    buyTwoOnlyPayDeliveryForOne := method(cart,
        if (cart containsTwiceOrMore(getName),
            deliveryCost = deliveryCost / 2
        )
    )

    handleGiftOptions := method(cart,
        Exception raise("abstract method")
    )

)
