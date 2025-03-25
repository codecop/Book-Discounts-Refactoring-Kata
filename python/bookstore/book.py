from bookstore.abstract_item import AbstractItem
from bookstore.cart import Cart


class Book(AbstractItem):
    """Most used item, a regular book. A book has a weight which cause delivery costs."""

    DEFAULT_WEIGHT_BOOK_GRAMMS = 500

    def __init__(self, name: str) -> None:
        super().__init__(name)

    def put_into_my_cart(self, cart: Cart):
        cart.add(self.name)

    def item_weight(self) -> int:
        if "C++" in self.name:
            # C++ books are usually heavy
            return 750  # grams
        elif "Good Parts" in self.name:
            # Good Parts are only few, so thin books
            return 100

        return Book.DEFAULT_WEIGHT_BOOK_GRAMMS
