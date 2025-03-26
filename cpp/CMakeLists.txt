cmake_minimum_required(VERSION 3.16)
project(bookstore)

set(CMAKE_CXX_STANDARD 20)

Include(FetchContent)

FetchContent_Declare(
        Catch2
        GIT_REPOSITORY https://github.com/catchorg/Catch2.git
        GIT_TAG v3.0.1 # or a later release
)
FetchContent_MakeAvailable(Catch2)

add_executable(test_bookstore
        src/AbstractItem.cpp
        src/Cart.cpp include/Cart.h
        src/AbstractItemOnOffer.cpp
        src/Book.cpp include/Book.h
        src/DiscountVoucher.cpp
        src/GiftWrapping.cpp
        src/PromotedBook.cpp
        test_main.cpp)
target_include_directories(test_bookstore PRIVATE include)
target_link_libraries(test_bookstore PRIVATE Catch2::Catch2WithMain)
