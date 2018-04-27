package design.decorator;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-04-25 18:56
 */
public class DecoratorB extends Decorator{
    public DecoratorB(Component component) {
        super(component);
    }

    @Override
    public void print() {
        super.print();
        System.out.println("DecoratorB");
    }
}
