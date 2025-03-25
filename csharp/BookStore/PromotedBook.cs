namespace BookStore
{
    public class PromotedBook : AbstractItemOnOffer
    {
        private static readonly int DEFAULT_WEIGHT_BOOK_GRAMMS = 500;

        public PromotedBook(string name) : base(name)
        {

        }

        public override void PutIntoMyCart(Cart cart)
        {
            cart.Add(GetName());
            new DiscountVoucher(10).PutIntoMyCart(cart);
        }

        protected override int ItemWeight()
        {
            if (GetName().Contains("C++"))
            {
                // C++ books are usually heavy
                return 750; // gramm

            }
            else if (GetName().Contains("Good Parts"))
            {
                // Good Parts are only few, so thin books
                return 100; // gramm
            }

            return DEFAULT_WEIGHT_BOOK_GRAMMS;
        }

        protected override bool HasDiscountOnDelivery()
        {
            return ItemWeight() >= DEFAULT_WEIGHT_BOOK_GRAMMS;
        }

        protected override void HandleGiftOptions(Cart cart)
        {
            new GiftWrapping(this).PutIntoMyCart(cart);
        }
    }
}
