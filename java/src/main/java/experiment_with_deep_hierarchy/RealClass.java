package experiment_with_deep_hierarchy;

public class RealClass extends SpecificAbstract {

    @Override
    public void iFoo() {
    }

    @Override
    protected void abstractBar() {
    }

    @Override
    protected void abstractFoo() {
    }

}
/*
 * Interface
 * |
 * Abstract1
 * |          \
 * Abstract2   Real1
 * |
 * Real2
 */
