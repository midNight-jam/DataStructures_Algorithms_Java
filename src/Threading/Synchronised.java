package Threading;

/**
 * Created by Jayam on 3/26/2017.
 */
public class Synchronised {
  private int count = 0;

  public void increment() {
//    synchronized (this) { // sort of Mutex, second thread has to wait till the first thread has released the lock
      count++;
//    }
  }

  public void doWork() {
    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 10000; i++) {
          increment();
        }
      }
    });

    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 10000; i++) {
          increment();
        }
      }
    });

    t1.start();
    t2.start();

    try {
      t1.join();  // wait for first  thread to join
      t2.join();  // wait for second thread to join
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // Logs < 20000 some times without synchronization as some increments are missed
    // Why because in increment() we are doing count++, if we expand this, it is count = count + 1. now when t1 thread comes
    // it fetches the value of count as 0 adds 1 to it, but before it can update count with incremented value, control is
    // taken away from t1 an t2 gets it, this time when t2 fetches the value of count it still gets 0, because despite
    // t1 being performing the addition of + 1 it didnt got chance to update the value for count, thus without synchronization
    // we loose some increments and count may not reach 20000.
    System.out.println("Count : " + count); // Logs 0 or < 20000 without join, beacuse this main thread is not waiting
    // for the worker threads to finish their work, hence after starting them it continues and logs count as 0
  }


  public static void main(String[] args) {
    Synchronised sync = new Synchronised();
    sync.doWork();
  }
}