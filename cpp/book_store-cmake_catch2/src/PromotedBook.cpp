//
// Created by mille on 28-Sep-22.
//

#include "PromotedBook.h"
#include "DiscountVoucher.h"
#include "GiftWrapping.h"

namespace bookstore {

  int PromotedBook::DEFAULT_WEIGHT_BOOK_GRAMMS = 500;
  PromotedBook::PromotedBook(const std::string& _name) : AbstractItemOnOffer(_name) { }

  void PromotedBook::putIntoMyCart(Cart& cart) {
    cart.add(getName());
    DiscountVoucher(10).putIntoMyCart(cart);
  }

  int PromotedBook::itemWeight() {
    if (getName().find("C++") != std::string::npos) {
      return 750;
    }
    else if (getName().find("Good Parts") != std::string::npos) {
      return 100;
    }
    return DEFAULT_WEIGHT_BOOK_GRAMMS;
  }

  bool PromotedBook::hasDiscountOnDelivery() {
    return itemWeight() >= DEFAULT_WEIGHT_BOOK_GRAMMS;
  }

  void PromotedBook::handleGiftOptions(Cart& cart) {
    GiftWrapping(*this).putIntoMyCart(cart);
  }
} // bookstore