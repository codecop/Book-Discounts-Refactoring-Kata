doRelativeFile("./CartAble.io")

DiscountVoucher := CartAble clone do(

    percentage := nil

    with := method(percentage,
        result := self clone
        result percentage := percentage
        result
    )

    putIntoMyCart := method(cart,
        cart add("Discount voucher for " .. percentage .. "% on your next order")
    )

)
