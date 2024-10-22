namespace BookStore
{
    public class Cart
    {
        private IList<string> items = new List<string>();
        public void Add(string item) => items.Add(item);
        public bool Contains(string item) => items.Contains(item);
        public bool ContainsTwiceOrMore(string item) => items.Count(i => i == item) >= 2;
        public override string ToString() => $"Your cart\n{string.Join("\n", items)}";
    }
}
