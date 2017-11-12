package Threading;

public class DoubleCheckSynchronizationSingleton {

  private static final Object lock = new Object();
  // final to ensure only one lock object cannot be changed, static makes this lock shared among all the object.

  private static volatile DoubleCheckSynchronizationSingleton instance;
  // volatile keyword here makes sure that the changes made in one thread are immediately reflect in other thread


  public static DoubleCheckSynchronizationSingleton getInstance() {
    DoubleCheckSynchronizationSingleton inst = instance;
    if (inst == null) {
      synchronized (lock) {
        inst = instance;
        if (inst == null) {    // While we are waiting for the lock another thread may have initialized the instance
          inst = new DoubleCheckSynchronizationSingleton();
          instance = inst;
        }
      }
    }
    return inst; // return the newly created instance, or the one existing in the instance reference
  }

  public static void main(String[] args) {
    DoubleCheckSynchronizationSingleton obj  = DoubleCheckSynchronizationSingleton.getInstance();
  }
}
