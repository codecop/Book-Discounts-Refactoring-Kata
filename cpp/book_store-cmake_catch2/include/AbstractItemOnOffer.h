//
// Created by mille on 28-Sep-22.
//

#ifndef CPP_WORKSHOPS_ABSTRACTITEMONOFFER_H
#define CPP_WORKSHOPS_ABSTRACTITEMONOFFER_H

#include "AbstractItem.h"

#include <string>

namespace bookstore {

  class AbstractItemOnOffer : public AbstractItem {
  public:
    explicit AbstractItemOnOffer(std::string const& name);

    void prepareDeliveryIn(Cart& cart) override;

  protected:
    void calculateDeliveryCost(Cart& cart, int gramms) override;

    virtual bool hasDiscountOnDelivery();

  private:
    void buyTwoOnlyPayDeliveryForOne(Cart& cart);

  protected:
    virtual void handleGiftOptions(Cart& cart) = 0;
  };
} // bookstore

#endif //CPP_WORKSHOPS_ABSTRACTITEMONOFFER_H
