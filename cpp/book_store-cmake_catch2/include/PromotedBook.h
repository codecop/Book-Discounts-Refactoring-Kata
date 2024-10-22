//
// Created by mille on 28-Sep-22.
//

#ifndef CPP_WORKSHOPS_PROMOTEDBOOK_H
#define CPP_WORKSHOPS_PROMOTEDBOOK_H

#include "AbstractItemOnOffer.h"

namespace bookstore {

  class PromotedBook : public AbstractItemOnOffer {
    static int DEFAULT_WEIGHT_BOOK_GRAMMS;
  public:
    explicit PromotedBook(std::string const& _name);

    void putIntoMyCart(Cart& cart) override;

  protected:
    int itemWeight() override;

    bool hasDiscountOnDelivery() override;

    void handleGiftOptions(Cart& cart) override;
  };

} // bookstore

#endif //CPP_WORKSHOPS_PROMOTEDBOOK_H
