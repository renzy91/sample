package design.observer;

import design.observer.observer.ObserverA;
import design.observer.subject.SubjectA;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-04-20 19:22
 */
public class Client {
    public static void main(String[] args) {
        ObserverA observerA = new ObserverA();
        SubjectA subjectA = new SubjectA();
        subjectA.add(observerA);

        subjectA.notifyObserver();

        subjectA.remove(observerA);
        subjectA.notifyObserver();
    }
}
