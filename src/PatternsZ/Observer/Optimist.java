package PatternsZ.Observer;

/**
 * Created by Jayam on 3/7/2017.
 */
public class Optimist extends ConcreteObserver {
  public Optimist(ConcreteSubject subj) {
    super(subj);
  }

  public void update() {
    if (subject.getState().equals("Price of gas 50$/gallon")) {
      observerState = "Happy Free rides";
    } else if (subject.getState().equals("Ipad is out")) {
      observerState = "More Gadgets";
    } else {
      observerState = "[*_*]";
    }
  }
}
