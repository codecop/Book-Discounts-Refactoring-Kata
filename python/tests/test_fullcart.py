from bookstore.book import Book
from bookstore.cart import Cart
from bookstore.gift_wrapping import GiftWrapping
from bookstore.promoted_book import PromotedBook


def test_sample():
    cart = Cart()

    basic_item = Book("C++ Functional programming")
    basic_item.put_into_my_cart(cart)

    promoted_item1 = PromotedBook("Usable Software Design book")
    promoted_item1.put_into_my_cart(cart)
    promoted_item2 = PromotedBook("Usable Software Design book")
    promoted_item2.put_into_my_cart(cart)

    basic_item.prepare_delivery_in(cart)
    assert basic_item.get_delivery_cost() == 27

    promoted_item1.prepare_delivery_in(cart)
    assert promoted_item1.get_delivery_cost() == 5

    promoted_item2.prepare_delivery_in(cart)
    assert promoted_item2.get_delivery_cost() == 5

    print('\n' + str(cart))


def test_full():
    cart = Cart()

    # simple books
    default_book = Book("Software Design book")
    default_book.put_into_my_cart(cart)

    cpp_book = Book("C++ Functional programming")
    cpp_book.put_into_my_cart(cart)

    good_parts_book = Book("JavaScript The Good Parts")
    good_parts_book.put_into_my_cart(cart)

    gift_wrapping = GiftWrapping(good_parts_book)
    gift_wrapping.put_into_my_cart(cart)

    # promoted books
    default_promoted_book = PromotedBook("Promoted Software Design book")
    default_promoted_book.put_into_my_cart(cart)
    cpp_promoted_book = PromotedBook("Promoted C++ book")
    cpp_promoted_book.put_into_my_cart(cart)
    good_parts_promoted_book = PromotedBook("Promoted Good Parts book")
    good_parts_promoted_book.put_into_my_cart(cart)
    good_parts_promoted_book.put_into_my_cart(cart)

    # simple books delivery
    default_book.prepare_delivery_in(cart)
    assert default_book.get_delivery_cost() == 10

    assert cpp_book.get_delivery_cost() == -1
    cpp_book.prepare_delivery_in(cart)
    assert cpp_book.get_delivery_cost() == 27

    default_promoted_book.prepare_delivery_in(cart)
    assert default_promoted_book.get_delivery_cost() == 10

    gift_wrapping.prepare_delivery_in(cart)
    assert gift_wrapping.get_delivery_cost() == 0

    # promoted books delivery
    cpp_promoted_book.prepare_delivery_in(cart)
    assert cpp_promoted_book.get_delivery_cost() == 10

    good_parts_promoted_book.prepare_delivery_in(cart)
    assert good_parts_promoted_book.get_delivery_cost() == 5

    good_parts_book.prepare_delivery_in(cart)
    assert good_parts_book.get_delivery_cost() == 10

    assert str(cart) == """Your cart
Software Design book
C++ Functional programming
JavaScript The Good Parts
Gift wrapping for JavaScript The Good Parts
Promoted Software Design book
Discount voucher for 10% on your next order
Promoted C++ book
Discount voucher for 10% on your next order
Promoted Good Parts book
Discount voucher for 10% on your next order
Promoted Good Parts book
Discount voucher for 10% on your next order
Gift wrapping for Promoted Software Design book
Gift wrapping for Promoted C++ book
Gift wrapping for Promoted Good Parts book"""

