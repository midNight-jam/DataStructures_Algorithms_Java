package PatternsZ.Factory;

/**
 * Created by Jayam on 3/7/2017.
 */
public class VolvoFactory extends Creator {
  public Engine getEngine() {
    return new Gas();
  }
}
