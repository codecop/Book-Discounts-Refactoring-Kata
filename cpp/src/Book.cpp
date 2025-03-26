//
// Created by mille on 28-Sep-22.
//

#include "Book.h"

namespace bookstore {
  int Book::DEFAULT_WEIGHT_BOOK_GRAMMS = 500;

  Book::Book(std::string const& name) : AbstractItem(name) {
  }

  void Book::putIntoMyCart(Cart& cart) {
    cart.add(getName());
  }

  int Book::itemWeight() {
    if (getName().find("C++") != std::string::npos) {
      return 750;
    }
    else if (getName().find("Good Parts") != std::string::npos) {
      return 100;
    }
    return DEFAULT_WEIGHT_BOOK_GRAMMS;
  }
} // bookstore