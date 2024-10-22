//
// Created by mille on 28-Sep-22.
//

#ifndef CPP_WORKSHOPS_GIFTWRAPPING_H
#define CPP_WORKSHOPS_GIFTWRAPPING_H

#include "AbstractItem.h"

namespace bookstore {
  class GiftWrapping : public AbstractItem {
  public:
    explicit GiftWrapping(AbstractItem& item);
    void putIntoMyCart(Cart& cart) override;
    void calculateDeliveryCost(Cart& cart, int gramms) override;
    int itemWeight() override;
  };
}

#endif //CPP_WORKSHOPS_GIFTWRAPPING_H
