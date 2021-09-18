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

## Excercise

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
