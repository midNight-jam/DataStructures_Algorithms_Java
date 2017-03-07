package PatternsZ.Decorator;

/**
 * Created by Jayam on 3/7/2017.
 */
public class ConcreteComponent implements Component {
  private String base = " Hello World!";

  @Override
  public String operation() {
    return base;
  }
}
