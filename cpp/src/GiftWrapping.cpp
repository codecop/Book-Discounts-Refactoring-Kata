//
// Created by mille on 28-Sep-22.
//

#include "GiftWrapping.h"

namespace bookstore {
  GiftWrapping::GiftWrapping(bookstore::AbstractItem& item) : AbstractItem("Gift wrapping for " + item.getName()){

  }

  void GiftWrapping::putIntoMyCart(bookstore::Cart& cart) {
    cart.add(getName());
  }

  void GiftWrapping::calculateDeliveryCost(bookstore::Cart& cart, int gramms) {
    markReadyToDeliver();
  }

  int GiftWrapping::itemWeight() {
    return 5;
  }
}