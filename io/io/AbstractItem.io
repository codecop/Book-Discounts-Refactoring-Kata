doRelativeFile("./CartAble.io")
/**
 * Base class of all our physical items. Most items are books but we also offer other things like gift cards.
 */
AbstractItem := CartAble clone do(

    NOT_READY_TO_DELIVER := -1

    name := nil
    deliveryCost := 0
    readyToDeliver := false

    with := method(name,
        result := self clone
        result name := name
        result
    )

    getName := method(
        name
    )

    prepareDeliveryIn := method(cart,
        if (cart contains(self name) not,
            Exception raise("Can only calculate delivery costs for items in cart")
        )

        grams := itemWeight
        calculateDeliveryCost(cart, grams)
        markReadyToDeliver
    )

    /**
     * Every item needs to provide its weight.
     */
    itemWeight := method(
        Exception raise("abstract method")
    )

    calculateDeliveryCost := method(cart, grams,
        if (grams <= 500,
            deliveryCost = 10
        ,
            deliveryCost = grams sqrt round
        )
    )

    markReadyToDeliver := method(
        readyToDeliver = true
    )

   getDeliveryCost := method(
        if (readyToDeliver,
            deliveryCost
        ,
            NOT_READY_TO_DELIVER
        )
    )

    asString = method(
        return name .. " (" .. getDeliveryCost .. "EUR)"
    )
)
