package design.observer.jdk;

import java.util.Observable;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-04-21 23:45
 */
public class Subject extends Observable {
    private String name;

    public void setName(String name) {
        this.name = name;
        setChanged();
        notifyObservers();
    }

    public String getName() {
        return name;
    }
}
