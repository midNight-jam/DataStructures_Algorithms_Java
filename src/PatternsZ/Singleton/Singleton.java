package PatternsZ.Singleton;

/**
 * Created by Jayam on 3/7/2017.
 */
public class Singleton {
  private static Singleton instance;

  private Singleton() {
  }

  public static Singleton getInstance() {
  // double locking
    if (instance == null) {
      synchronized (Singleton.class) {
        if (instance == null) {
          instance = new Singleton();
        }
      }
    }
    return instance;
  }
}