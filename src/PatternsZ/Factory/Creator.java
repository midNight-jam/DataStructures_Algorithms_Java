package PatternsZ.Factory;

/**
 * Created by Jayam on 3/7/2017.
 */
public abstract class Creator {
  public abstract Engine getEngine();

  public void buildOrder() {
    Engine engine = getEngine();
    System.out.println(" Name : " + engine.getClass().getName());
    System.out.println(" Assembling Car with this engine");
  }
}