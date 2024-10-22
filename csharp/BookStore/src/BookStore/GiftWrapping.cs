namespace BookStore
{
    public class GiftWrapping : AbstractItem
    {
        public GiftWrapping(AbstractItem item) : base($"Gift wrapping for {item.GetName()}")
        {
        }

        public override void PutIntoMyCart(Cart cart)
        {
            cart.Add(GetName());
        }

        protected override void CalculateDeliveryCost(Cart cart, int gramms)
        {
            // no delivery cost
            MarkReadyToDeliver();
        }

        protected override int ItemWeight()
        {
            return 5;
        }
    }
}
