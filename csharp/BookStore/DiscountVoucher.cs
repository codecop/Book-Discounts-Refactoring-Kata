namespace BookStore
{
    public class DiscountVoucher : CartAble
    {
        private readonly int _percentage;

        public DiscountVoucher(int percentage)
        {
            _percentage = percentage;
        }

        public void PutIntoMyCart(Cart cart)
        {
            cart.Add($"Discount voucher for {_percentage}% on your next order");
        }
    }
}
