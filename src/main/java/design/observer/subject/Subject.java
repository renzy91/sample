package design.observer.subject;

import design.observer.observer.Observer;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-04-20 19:16
 */
public interface Subject {
    void add(Observer observer);
    boolean remove(Observer observer);
    void notifyObserver();
}
