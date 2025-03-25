from abc import ABC, abstractmethod

from bookstore.cart import Cart


class CartAble(ABC):
    """Items like books and other services like vouchers or gift options can be put into the shopping cart."""

    @abstractmethod
    def put_into_my_cart(self, cart: Cart):
        pass
