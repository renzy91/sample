package design.observer.observer;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-04-20 19:22
 */
public class ObserverA implements Observer {
    @Override
    public void update() {
        System.out.println("update");
    }
}
