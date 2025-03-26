//
// Created by mille on 28-Sep-22.
//

#ifndef CPP_WORKSHOPS_ABSTRACTITEM_H
#define CPP_WORKSHOPS_ABSTRACTITEM_H

#include "Cart.h"
#include "CartAble.h"

#include <string>

namespace bookstore {

  class AbstractItem : public CartAble {
    static int NOT_READY_TO_DELIVER;
    std::string name;
  private:
    bool readyToDeliver;
  protected:
    int deliveryCost;
  public:
    explicit AbstractItem(std::string  name);

    std::string getName();

    virtual void prepareDeliveryIn(Cart& cart);

  protected:
    virtual int itemWeight() = 0;

    virtual void calculateDeliveryCost(Cart& cart, int gramms);

    void markReadyToDeliver();

  public:
    [[nodiscard]] int getDeliveryCost() const;

  public:
    std::string toString();
  };

} // bookstore

#endif //CPP_WORKSHOPS_ABSTRACTITEM_H
