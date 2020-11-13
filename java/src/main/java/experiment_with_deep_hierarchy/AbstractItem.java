package experiment_with_deep_hierarchy;

public abstract class AbstractItem implements CartAble {

    protected String bar;

    public void templateMethod() {
        putIntoMyCart();
        abstractFoo();
        privateFoo();
    }

    protected abstract void abstractFoo();

    protected void foo2() {

    }

    private void privateFoo() {

    }

}
