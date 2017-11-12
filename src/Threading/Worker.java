package Threading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Jayam on 3/27/2017.
 */
public class Worker {
  private List<Integer> list1 = new ArrayList<>();
  private List<Integer> list2 = new ArrayList<>();
  private Random random;

  // Seperate LOCK OBJECTS
  private Object lock1 = new Object();
  private Object lock2 = new Object();

  public void insertOne() {
    synchronized (lock1) {
      try {
        Thread.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
//    synchronized (this) {
      random = new Random(100);
      list1.add(random.nextInt());
//    }
    }
  }

  public void insertTwo() {
    synchronized (lock2) {
      try {
        Thread.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
//    synchronized (this) { // synchornised imporves performance all over tkaes 2 secs rather than whole synchronized method
      // which takes 4 sec, but here we will be locking wholes lists that is not a good poractice
      // A good practices is to declare & use seperate "LOCK OBJECTS", takes 2 sec on whole
      random = new Random(100);
      list2.add(random.nextInt());
//    }
    }
  }

  public void process() {
    for (int i = 0; i < 1000; i++) {
      insertOne();
      insertTwo();
    }
  }

  public static void main(String[] args) {
    Worker worker = new Worker();
    long start = System.currentTimeMillis();

    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        worker.process();
      }
    });

    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        worker.process();
      }
    });

    t1.start();
    t2.start();
    t1.interrupt();
    try {
      t1.join();
      t2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    long end = System.currentTimeMillis();
    System.out.println(end - start);

    System.out.println("List one : " + worker.list1.size() + "  List Two : " + worker.list2.size());
  }
}