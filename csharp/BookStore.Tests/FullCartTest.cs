namespace BookStore.Tests
{
    public class FullCartTest
    {
        [Fact]
        public void SampleTest()
        {
            var cart = new Cart();
            var basicItem = new Book("C++ Functional programming");
            basicItem.PutIntoMyCart(cart);
            var promotedItem1 = new PromotedBook("Usable Software Design book");
            promotedItem1.PutIntoMyCart(cart);
            var promotedItem2 = new PromotedBook("Usable Software Design book");
            promotedItem2.PutIntoMyCart(cart);
            basicItem.PrepareDeliveryIn(cart);
            Assert.Equal(27, basicItem.GetDeliveryCost());
            promotedItem1.PrepareDeliveryIn(cart);
            Assert.Equal(5, promotedItem1.GetDeliveryCost());
            promotedItem2.PrepareDeliveryIn(cart);
            Assert.Equal(5, promotedItem2.GetDeliveryCost());
        }

        [Fact]
        public void CannotDeliverNonAddedItemTest()
        {
            Assert.Throws<IllegalStateException>(() => new Book("Illegal").PrepareDeliveryIn(new Cart()));
        }

        [Fact]
        public void FullTest()
        {
            var cart = new Cart();

            // simple books
            var defaultBook = new Book("Software Design book");
            defaultBook.PutIntoMyCart(cart);
            var cppBook = new Book("C++ Functional programming");
            cppBook.PutIntoMyCart(cart);
            var goodPartsBook = new Book("JavaScript The Good Parts");
            goodPartsBook.PutIntoMyCart(cart);
            var giftWrapping = new GiftWrapping(goodPartsBook);
            giftWrapping.PutIntoMyCart(cart);

            // promoted books
            var defaultPromotedBook = new PromotedBook("Promoted Software Design book");
            defaultPromotedBook.PutIntoMyCart(cart);
            var cppPromotedBook = new PromotedBook("Promoted C++ book");
            cppPromotedBook.PutIntoMyCart(cart);
            var goodPartsPromotedBook = new PromotedBook("Promoted Good Parts book");
            goodPartsPromotedBook.PutIntoMyCart(cart);
            goodPartsPromotedBook.PutIntoMyCart(cart);

            // simple books delivery
            defaultBook.PrepareDeliveryIn(cart);
            Assert.Equal(10, defaultBook.GetDeliveryCost());
            Assert.Equal(-1, cppBook.GetDeliveryCost());
            cppBook.PrepareDeliveryIn(cart);
            Assert.Equal(27, cppBook.GetDeliveryCost());
            defaultPromotedBook.PrepareDeliveryIn(cart);
            Assert.Equal(10, defaultPromotedBook.GetDeliveryCost());
            giftWrapping.PrepareDeliveryIn(cart);
            Assert.Equal(0, giftWrapping.GetDeliveryCost());

            // promoted books delivery
            cppPromotedBook.PrepareDeliveryIn(cart);
            Assert.Equal(10, cppPromotedBook.GetDeliveryCost());
            goodPartsPromotedBook.PrepareDeliveryIn(cart);
            Assert.Equal(5, goodPartsPromotedBook.GetDeliveryCost());
            goodPartsBook.PrepareDeliveryIn(cart);
            Assert.Equal(10, goodPartsBook.GetDeliveryCost());

            Assert.Equal("Your cart\n" + 
                         "Software Design book\n" + 
                         "C++ Functional programming\n" + 
                         "JavaScript The Good Parts\n" + 
                         "Gift wrapping for JavaScript The Good Parts\n" + 
                         "Promoted Software Design book\n" + 
                         "Discount voucher for 10% on your next order\n" + 
                         "Promoted C++ book\n" + 
                         "Discount voucher for 10% on your next order\n" + 
                         "Promoted Good Parts book\n" + 
                         "Discount voucher for 10% on your next order\n" + 
                         "Promoted Good Parts book\n" + 
                         "Discount voucher for 10% on your next order\n" + 
                         "Gift wrapping for Promoted Software Design book\n" + 
                         "Gift wrapping for Promoted C++ book\n" +
                         "Gift wrapping for Promoted Good Parts book", cart.ToString());
        }
    }
}