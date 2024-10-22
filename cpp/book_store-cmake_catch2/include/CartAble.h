//
// Created by mille on 28-Sep-22.
//

#ifndef CPP_WORKSHOPS_CARTABLE_H
#define CPP_WORKSHOPS_CARTABLE_H

#include "Cart.h"

namespace bookstore {
  class CartAble {
  public:
    virtual void putIntoMyCart(Cart& cart) = 0;
  };
}

#endif //CPP_WORKSHOPS_CARTABLE_H
