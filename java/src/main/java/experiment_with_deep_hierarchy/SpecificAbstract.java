package experiment_with_deep_hierarchy;

public abstract class SpecificAbstract extends BaseClass {

    @Override
    public void templateMethod() {
        if (false) {
            super.templateMethod();
        } else {
            iFoo();
            bar2();
            abstractBar();
            privateBar();
        }
    }

    protected abstract void abstractBar();

    protected void bar2() {

    }

    protected void foo2() {
        privateBar();
        super.foo2();
    }

    private void privateBar() {

    }

}
