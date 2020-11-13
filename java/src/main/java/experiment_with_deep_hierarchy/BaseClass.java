package experiment_with_deep_hierarchy;

public abstract class BaseClass implements IInterface {

    protected String bar;

    public void templateMethod() {
        iFoo();
        abstractFoo();
        privateFoo();
    }

    protected abstract void abstractFoo();

    protected void foo2() {

    }

    private void privateFoo() {

    }

}
