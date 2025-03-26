//
// Created by mille on 28-Sep-22.
//

#ifndef CPP_WORKSHOPS_BOOK_H
#define CPP_WORKSHOPS_BOOK_H

#include "AbstractItem.h"

namespace bookstore {

  class Book : public AbstractItem {
    static int DEFAULT_WEIGHT_BOOK_GRAMMS;
  public:
    Book(std::string const& name);

    void putIntoMyCart(Cart& cart) override;

  protected:
    int itemWeight() override;
  };

} // bookstore

#endif //CPP_WORKSHOPS_BOOK_H
