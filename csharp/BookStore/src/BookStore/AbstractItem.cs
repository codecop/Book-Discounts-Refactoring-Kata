namespace BookStore
{
    public abstract class AbstractItem : CartAble
    {
        private static readonly int NOT_READY_TO_DELIVER = -1;

        private readonly string _name;
        protected int _deliveryCost;
        private bool _readyToDeliver;

        public AbstractItem(string name)
        {
            _name = name;
        }

        public string GetName()
        {
            return _name;
        }

        public virtual void PrepareDeliveryIn(Cart cart)
        {
            if (!cart.Contains(_name))
            {
                throw new IllegalStateException("Can only calculate delivery costs for items in cart");
            }
            int gramms = ItemWeight();
            CalculateDeliveryCost(cart, gramms);
            MarkReadyToDeliver();
        }

        protected void MarkReadyToDeliver()
        {
            _readyToDeliver = true;
        }

        protected virtual void CalculateDeliveryCost(Cart cart, int gramms)
        {
            if (gramms <= 500)
            {
                _deliveryCost = 10;
            }
            else
            {
                _deliveryCost = (int)Math.Sqrt(gramms);
            }
        }

        public int GetDeliveryCost()
        {
            if (_readyToDeliver)
            {
                return _deliveryCost;
            }
            return NOT_READY_TO_DELIVER;
        }
        protected abstract int ItemWeight();

        public abstract void PutIntoMyCart(Cart cart);

        public override string ToString()
        {
            return _name + " (" + GetDeliveryCost() + "EUR)";
        }
    }
}
