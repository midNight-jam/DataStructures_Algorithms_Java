package PatternsZ.Factory;

/**
 * Created by Jayam on 3/7/2017.
 */
public class HyundaiFactory extends Creator {
  public Engine getEngine() {
    return new Hybrid();
  }
}
