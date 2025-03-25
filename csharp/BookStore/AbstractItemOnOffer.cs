namespace BookStore
{
    public abstract class AbstractItemOnOffer : AbstractItem
    {
        public AbstractItemOnOffer(string name) : base(name)
        {
        }

        public override void PrepareDeliveryIn(Cart cart)
        {
            base.PrepareDeliveryIn(cart);
            HandleGiftOptions(cart);
        }

        protected override void CalculateDeliveryCost(Cart cart, int gramms)
        {
            int reduceCost = 1;
            if (HasDiscountOnDelivery())
            {
                reduceCost = 2;
            }
            base.CalculateDeliveryCost(cart, gramms / reduceCost);
            BuyTwoOnlyPayDeliveryForOne(cart);
        }

        private void BuyTwoOnlyPayDeliveryForOne(Cart cart)
        {
            if (cart.ContainsTwiceOrMore(GetName()))
            {
                _deliveryCost /= 2;
            }
        }

        protected virtual bool HasDiscountOnDelivery()
        {
            // no discount on delivery by default
            return false;
        }

        protected abstract void HandleGiftOptions(Cart cart);
    }
}
