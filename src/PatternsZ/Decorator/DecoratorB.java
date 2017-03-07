package PatternsZ.Decorator;

/**
 * Created by Jayam on 3/7/2017.
 */
public class DecoratorB extends Decorator {
  private String addedState;

  public DecoratorB(Component c){
    super(c);
  }

  public String operation() {
    addedState = super.operation();
    return extraBehaviuor(addedState);
  }

  private String extraBehaviuor(String in) {
    return " <B> " + in + "</B>";
  }
}
