package Threading;

import java.util.Scanner;

/**
 * Created by Jayam on 3/27/2017.
 */
class WProcessor {
  public void produce() throws InterruptedException {
    synchronized (this) {
      System.out.println("Producer Thread Running ...");
      wait(); // waits & relinqueshes control of this object
      System.out.println("Resumed");
    }
  }

  public void consumer() throws InterruptedException {
    Scanner sc = new Scanner(System.in);
    Thread.sleep(2000);
    synchronized (this) {
      System.out.println("Waiting for enter Key...");
      sc.nextLine();
      notify(); // notifies any of the waiting thread on this object that it can wake up,
      // but doesnt necessaril gurantees that it will get this object, as the control has still not
      // finished this synchronized block
      Thread.sleep(5000); // this sleep proves that notify wont give control to waiting thread
    }
  }
}

public class WaitNotify {
  public static void main(String[] args) {
    WProcessor wProcessor = new WProcessor();
    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          wProcessor.produce();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          wProcessor.consumer();
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