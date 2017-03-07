package PatternsZ.Observer;

/**
 * Created by Jayam on 3/7/2017.
 */
public class Pessimist extends ConcreteObserver {

  public Pessimist(ConcreteSubject subj) {
    super(subj);
  }

  public void update() {
    if (subject.getState().equals("Price of gas 50$/gallon")) {
      observerState = "Sad end of oil";
    } else if (subject.getState().equals("Ipad is out")) {
      observerState = "Sad end of world";
    } else {
      observerState = "[-_-]";
    }
  }
}