/**
 * Items like books and other services like vouchers or gift options can be put into the shopping cart.
 */
CartAble := Object clone do(

    putIntoMyCart := method(cart,
        Exception raise("abstract method")
    )

)
