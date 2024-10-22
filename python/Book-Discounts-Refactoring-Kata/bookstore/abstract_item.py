import math
from abc import abstractmethod

from bookstore.cart import Cart
from bookstore.cartable import CartAble


class AbstractItem(CartAble):
    """Base class of all our physical items. Most items are books, but we also offer other things like gift cards."""
    NOT_READY_TO_DELIVER: int = -1

    def __init__(self, name: str) -> None:
        self.name = name
        self.delivery_cost = 0
        self.ready_to_deliver = False

    @abstractmethod
    def item_weight(self) -> int:
        pass

    def prepare_delivery_in(self, cart: Cart):
        if not cart.contains(self.name):
            raise RuntimeError()

        grams: int = self.item_weight()
        self.calculate_delivery_cost(cart, grams)
        self.mark_ready_to_deliver()

    def calculate_delivery_cost(self, cart: Cart, grams: int):
        if grams <= 500:
            self.delivery_cost = 10
        else:
            self.delivery_cost = int(math.sqrt(grams))

    def mark_ready_to_deliver(self):
        self.ready_to_deliver = True

    def get_delivery_cost(self) -> int:
        return self.delivery_cost if self.ready_to_deliver else AbstractItem.NOT_READY_TO_DELIVER

    def __str__(self) -> str:
        return f"{self.name} ({self.get_delivery_cost()}EUR)"
