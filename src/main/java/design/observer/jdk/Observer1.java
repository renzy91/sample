package design.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-04-21 23:46
 */
public class Observer1 implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        Subject su = (Subject) o;
        System.out.println(su.getName());
    }
}
