package design.decorator;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-04-25 18:54
 */
public abstract class Decorator implements Component{
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void print() {
        component.print();
    }
}
