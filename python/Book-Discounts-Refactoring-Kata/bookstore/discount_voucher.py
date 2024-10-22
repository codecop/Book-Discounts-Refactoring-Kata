from bookstore.cartable import CartAble
from bookstore.cart import Cart


class DiscountVoucher(CartAble):

    def __init__(self, percentage: int):
        self.percentage = percentage

    def put_into_my_cart(self, cart: Cart):
        cart.add(f"Discount voucher for {self.percentage}% on your next order")

