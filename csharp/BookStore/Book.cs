namespace BookStore
{
    public class Book : AbstractItem
    {
        private static readonly int DEFAULT_WEIGHT_BOOK_GRAMMS = 500;

        public Book(string name) : base(name)
        {
        }

        public override void PutIntoMyCart(Cart cart)
        {
            cart.Add(GetName());
        }

        protected override int ItemWeight()
        {
            if (GetName().Contains("C++"))
            {
                return 750;
            }
            else if (GetName().Contains("Good Parts"))
            {
                return 100;
            }
            return DEFAULT_WEIGHT_BOOK_GRAMMS;
        }
    }
}
