# Book Discounts Refactoring Kata

Exercises to practice refactoring coupled hierarchies.

## Domain: Book Discounts Sub System

This code is part of the software system of our book store. The given sub system
deals with adding different goodies to orders of books when delivering, e.g. 
discounts, promotions or gifts.

The current hierarchy of classes is
 
             CartAble
                |     \
                |      \
                |        DiscountVoucher
           AbstractItem      
          /             \
         /               \
    AbstractItemOnOffer    Book & GiftWrapping
             |
             |
        PromotedBook

### Classes

`CartAble` marks items like books and other services like vouchers or gift options which can be put into the shopping cart.

`AbstractItem` is the base class of all our physical items. Most items are books but we also offer other things like gift cards.

`Book` is the most used item. A book has a weight which causes delivery costs.

`AbstractItemOnOffer` is for items (i.e. books) which can be on offer. Items on offer

* Allow for a discount on delivery cost.
* Allow for gift options.
* Reduce the cost of delivery if you are buying two or more of the same kind.

`PromotedBook` is a concrete book on promotion with several goodies:

* You get a 10% discount on your next purchase.
* You get a discount on delivery if it is heavy.
* You get a gift wrapping for free.

## Exercise

This exercise is hard. It includes several classes which form a coupled hierarchy.
Maybe start exploring a simpler code base first, which only has one level of hierarchy.

### Your Task

*[Favour composition over inheritance](https://stackoverflow.com/questions/49002/prefer-composition-over-inheritance)*
is a common phrase. Remove all hierarchies and refactor the code to only use composition. 
(Implementing interfaces is allowed.)

### Motivation

We want an exercise for working with deep inheritance hierarchies. We need at least

* 4-5 levels of hierarchy
* mutation on some levels
* 1 method calling some superclass methods
* override of some superclass methods in subclasses

## License

[BSD 3-Clause License](https://opensource.org/licenses/BSD-3-Clause), see `LICENSE` in repository.
