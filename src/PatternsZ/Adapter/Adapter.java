package PatternsZ.Adapter;

/**
 * Created by Jayam on 3/7/2017.
 */
public class Adapter extends OldImplementation implements NewContract {
  @Override
  public void sayHello() {
    super.printMessage("Hello!!");
  }
}
