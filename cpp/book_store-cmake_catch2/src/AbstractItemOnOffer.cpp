//
// Created by mille on 28-Sep-22.
//

#include "AbstractItemOnOffer.h"

namespace bookstore {
  AbstractItemOnOffer::AbstractItemOnOffer(std::string const& name) : AbstractItem(name) { }

  void AbstractItemOnOffer::prepareDeliveryIn(Cart& cart) {
    AbstractItem::prepareDeliveryIn(cart);
    handleGiftOptions(cart);
  }

  void AbstractItemOnOffer::calculateDeliveryCost(Cart& cart, int gramms) {
    int reduceCost = 1;
    if (hasDiscountOnDelivery()) {
      reduceCost = 2;
    }
    AbstractItem::calculateDeliveryCost(cart, gramms / reduceCost);
    buyTwoOnlyPayDeliveryForOne(cart);
  }

  bool AbstractItemOnOffer::hasDiscountOnDelivery() {
    return false;
  }

  void AbstractItemOnOffer::buyTwoOnlyPayDeliveryForOne(Cart& cart) {
    if (cart.containsTwiceOrMore(getName())) {
      deliveryCost /= 2;
    }
  }
} // bookstore