from bookstore.abstract_item import AbstractItem
from bookstore.cart import Cart


class GiftWrapping(AbstractItem):
    """We provide gift wrappings for our books."""

    def __init__(self, item: AbstractItem):
        super().__init__("Gift wrapping for " + item.name)

    def put_into_my_cart(self, cart: Cart):
        cart.add(self.name)

    def calculate_delivery_cost(self, cart: Cart, grams: int):
        # no delivery cost
        self.mark_ready_to_deliver()

    def item_weight(self) -> int:
        return 5




