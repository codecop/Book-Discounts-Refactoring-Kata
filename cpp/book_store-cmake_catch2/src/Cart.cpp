//
// Created by mille on 28-Sep-22.
//

#include "Cart.h"
#include <algorithm>

namespace bookstore {
  void Cart::add(std::string const& item) {
    this->items.emplace_back(item);
  }

  bool Cart::contains(std::string const& item) {
    return std::find(std::begin(items), std::end(items), item) != std::end(items);
  }

  bool Cart::containsTwiceOrMore(std::string const& item) {
    auto to_lower = [](auto const& s) {
      std::string res;
      for (auto& c : s) {
        res.push_back(std::tolower(c));
      }
      return res;
    };
    auto const itemLower = to_lower(item);
    auto const count = std::count_if(std::begin(items), std::end(items), [itemLower, to_lower](auto const& s) {
      return itemLower == to_lower(s);
    });
    return count >= 2;
  }

  std::string Cart::toString() {
    std::string res("Your cart\n");
    for(auto const& item : items) {
      res.append(item);
      res.push_back('\n');
    }
    return res;
  }
}