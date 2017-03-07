package PatternsZ.Observer;

/**
 * Created by Jayam on 3/7/2017.
 */
public class ConcreteObserver implements Observer {
  protected String observerState;
  protected ConcreteSubject subject;

  public ConcreteObserver(ConcreteSubject subj) {
    subject = subj;
  }

  public void showState() {
    System.out.println(this.getClass().getName() + " in State : " + observerState);
  }

  @Override
  public void update() {
    // do nothing
  }
}