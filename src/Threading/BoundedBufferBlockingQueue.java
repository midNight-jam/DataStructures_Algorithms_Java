package Threading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Jayam on 3/27/2017.
 */

public class BoundedBufferBlockingQueue {
  // A bounded buffer sort of collection provided by Java
  private static BlockingQueue<Integer> bque = new ArrayBlockingQueue<Integer>(10);

  private static void producer() throws InterruptedException {
    Random random = new Random();
    while (true) {
      bque.put(random.nextInt(100));  // put will patiently wait if the que is full
    }
  }

  private static void consumer() throws InterruptedException {
    Random random = new Random();
    while (true) {
      Thread.sleep(100);
      if (random.nextInt(10) == 0) {
        Integer val = bque.take();  // take will patiently wait if the que is empty
        System.out.println("Taken value : " + val + " Queue Size : " + bque.size());
      }
    }
  }

  public static void main(String[] args) {
    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          producer();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          consumer();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    t1.start();
    t2.start();

    try {
      t1.join();
      t2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

/*
Taken value : 90 Queue Size : 10
Taken value : 7 Queue Size : 10
Taken value : 86 Queue Size : 10
Taken value : 29 Queue Size : 10
Taken value : 95 Queue Size : 10
Taken value : 91 Queue Size : 10
Taken value : 95 Queue Size : 10
Taken value : 8 Queue Size : 10
Taken value : 0 Queue Size : 10
...
*/