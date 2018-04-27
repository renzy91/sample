package design.state;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-04-27 19:39
 */
public class Client {
    public static void main(String[] args) {
        LiftContext context = new LiftContext();

        context.open();
        context.close();
        context.run();
        context.open();

        System.out.println(context.getLiftState());
    }
}
