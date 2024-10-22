

class Cart:
    """The shopping cart. The cart stores the names (IDs) of the items in the cart."""

    def __init__(self) -> None:
        self.items = []

    def add(self, item: str):
        self.items.append(item)

    def contains(self, item: str) -> bool:
        return item in self.items

    def contains_twice_or_more(self, item: str) -> bool:
        # return len(list(filter(lambda i: i.lower() == item.lower(), self.items))) > 1
        return len([i for i in self.items if i.lower() == item.lower()]) > 1

    def __str__(self) -> str:
        return 'Your cart\n' + '\n'.join(self.items)


