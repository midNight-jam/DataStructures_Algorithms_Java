package PatternsZ.Factory;

/**
 * Created by Jayam on 3/7/2017.
 */
public class TeslaFactory extends Creator {
  public Engine getEngine() {
    return new Electric();
  }
}
