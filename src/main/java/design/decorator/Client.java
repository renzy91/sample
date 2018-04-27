package design.decorator;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-04-25 18:56
 */
public class Client {
    public static void main(String[] args) {
        ComponentA componentA = new ComponentA();

        DecoratorA da = new DecoratorA(componentA);
        DecoratorB db = new DecoratorB(da);
        DecoratorB db1 = new DecoratorB(db);

        db1.print();
    }
}
