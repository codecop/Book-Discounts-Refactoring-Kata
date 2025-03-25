from bookstore.abstract_item_on_offer import AbstractItemOnOffer
from bookstore.cart import Cart
from bookstore.discount_voucher import DiscountVoucher
from bookstore.gift_wrapping import GiftWrapping


class PromotedBook(AbstractItemOnOffer):
    """Concrete books on promotion have several goodies:
        - You get a 10% discount on your next purchase.
        - You get a discount on delivery if it is heavy.
        - You get a gift wrapping for free."""

    DEFAULT_WEIGHT_BOOK_GRAMMS = 500

    def __init__(self, name):
        super().__init__(name)

    def put_into_my_cart(self, cart: Cart):
        cart.add(self.name)
        DiscountVoucher(10).put_into_my_cart(cart)

    def item_weight(self) -> int:
        if "C++" in self.name:
            # C++ books are usually heavy
            return 750  # grams
        elif "Good Parts" in self.name:
            # Good Parts are only few, so thin books
            return 100

        return PromotedBook.DEFAULT_WEIGHT_BOOK_GRAMMS

    def has_discount_on_delivery(self) -> bool:
        return self.item_weight() >= PromotedBook.DEFAULT_WEIGHT_BOOK_GRAMMS

    def handle_gift_options(self, cart):
        GiftWrapping(self).put_into_my_cart(cart)
