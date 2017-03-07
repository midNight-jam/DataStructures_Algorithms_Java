package PatternsZ.Observer;

import java.util.ArrayList;

/**
 * Created by Jayam on 3/7/2017.
 */
public class ConcreteSubject implements Subject {
  private String subjectState;
  private ArrayList<Observer> observers = new ArrayList<>();

  ConcreteSubject(String str) {
    subjectState = str;
  }

  public String getState() {
    return subjectState;
  }

  public void setState(String str) {
    subjectState = str;
    notifyObserver();
  }

  public void showState(String str) {
    System.out.println("subject State : " + subjectState);
  }

  @Override
  public void attach(Observer o) {
    observers.add(o);
  }

  @Override
  public void detach(Observer o) {
    observers.remove(o);
  }

  @Override
  public void notifyObserver() {
    for (Observer o : observers)
      o.update();
  }
}