package design.observer.subject;

import design.observer.observer.Observer;

import java.util.ArrayList;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-04-20 19:20
 */
public class SubjectA implements Subject {
    ArrayList<Observer> list = null;
    public SubjectA() {
        list = new ArrayList<>();
    }

    @Override
    public void add(Observer observer) {
        list.add(observer);
    }

    @Override
    public boolean remove(Observer observer) {
        return list.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : list) {
            observer.update();
        }
    }
}
