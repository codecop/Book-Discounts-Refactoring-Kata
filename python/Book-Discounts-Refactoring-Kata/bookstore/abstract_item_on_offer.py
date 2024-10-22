from bookstore.abstract_item import *


class AbstractItemOnOffer(AbstractItem):
    """Some items (i.e. books) can be on offer. Items on offer
        - Allow for a discount on delivery cost.
        - Allow for gift options.
        - Reduce the cost of delivery if you are buying two or more of the same kind."""

    def __init__(self, name: str) -> None:
        super().__init__(name)

    def prepare_delivery_in(self, cart: Cart):
        super().prepare_delivery_in(cart)
        self.handle_gift_options(cart)

    def calculate_delivery_cost(self, cart: Cart, grams: int):
        reduce_cost = 1
        if self.has_discount_on_delivery():
            reduce_cost = 2

        super().calculate_delivery_cost(cart, grams // reduce_cost)
        self.buy_two_only_pay_delivery_for_one(cart)

    def has_discount_on_delivery(self) -> bool:
        # default no discount on delivery
        return False

    def buy_two_only_pay_delivery_for_one(self, cart: Cart):
        if cart.contains_twice_or_more(self.name):
            self.delivery_cost /= 2

    @abstractmethod
    def handle_gift_options(self, cart: Cart):
        pass
