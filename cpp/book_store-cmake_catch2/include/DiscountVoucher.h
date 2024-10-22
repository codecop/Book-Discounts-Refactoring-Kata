//
// Created by mille on 28-Sep-22.
//

#ifndef CPP_WORKSHOPS_DISCOUNTVOUCHER_H
#define CPP_WORKSHOPS_DISCOUNTVOUCHER_H

#include "CartAble.h"

namespace bookstore {

  class DiscountVoucher : public CartAble {
    int percentage;
  public:
    explicit DiscountVoucher(int _percentage);

    void putIntoMyCart(Cart& cart) override;
  };

} // bookstore

#endif //CPP_WORKSHOPS_DISCOUNTVOUCHER_H
