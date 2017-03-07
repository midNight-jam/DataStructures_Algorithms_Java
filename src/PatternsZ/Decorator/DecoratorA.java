package PatternsZ.Decorator;

/**
 * Created by Jayam on 3/7/2017.
 */
public class DecoratorA extends Decorator {

  private String addedState;

  public DecoratorA(Component c) {
    super(c);
  }

  public String operation() {
    addedState = super.operation();
    return extraBehaviuor(addedState);
  }

  private String extraBehaviuor(String in) {
    return " <IT> " + in + "</IT>";
  }
}