//
// Created by mille on 28-Sep-22.
//

#include "DiscountVoucher.h"

namespace bookstore {
  DiscountVoucher::DiscountVoucher(int _percentage) {
    percentage = _percentage;
  }

  void DiscountVoucher::putIntoMyCart(Cart& cart) {
    cart.add("Discount voucher for " + std::to_string(percentage) + "% on your next order");
  }
} // bookstore