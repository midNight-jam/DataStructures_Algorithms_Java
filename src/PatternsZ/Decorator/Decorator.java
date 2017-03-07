package PatternsZ.Decorator;

/**
 * Created by Jayam on 3/7/2017.
 */
public class Decorator implements Component {
  private Component component;

  public Decorator(Component c) {
    this.component = c;
  }

  @Override
  public String operation() {
    return component.operation();
  }
}