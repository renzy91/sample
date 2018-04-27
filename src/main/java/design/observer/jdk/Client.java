package design.observer.jdk;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-04-21 23:51
 */
public class Client {
    public static void main(String[] args) {
        Observer1 o1 = new Observer1();
        Subject subject = new Subject();
        subject.addObserver(o1);

        subject.setName("Tom");
        subject.setName("Jerry");

    }
}
