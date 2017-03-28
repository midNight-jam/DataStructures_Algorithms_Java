package Threading;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Jayam on 3/27/2017.
 */

class BProcessor {
  private final int LIMIT = 10;
  private LinkedList<Integer> list = new LinkedList<>();
  private Object lock = new Object();

  public void produce() throws InterruptedException {
    int value = 0;
    while (true) {
      synchronized (lock) {
        while (list.size() == LIMIT) {
          lock.wait();  // To wait if the buffer is already full,
        }
        list.add(value++);
        lock.notify();  // this notifies is used to wake up consumer if it is data because there was no data
        // and now it can resume as producer has given some data in buffer
      }
    }
  }

  public void consume() throws InterruptedException {
    Random random = new Random();
    while (true) {
      synchronized (lock) {
        while(list.size() ==0){
          lock.wait();  // TO wait if there is no data in buffer to be consumed yet
        }
        System.out.print(" List Size : " + list.size());
        int remove = list.removeFirst();
        System.out.println(" removed : " + remove);
        lock.notify();  // notifies the producer that it has consumed some data from the buffer, and that if producer was
        // waiting because the buffer was full, it can wake up and produce again as consumer has consumed some data
      }
      Thread.sleep(random.nextInt(1000)); // to simulate that consumer is slow to consume
    }
  }
}

public class BoundedBufferWaitNotify {

  public static void main(String[] args) {
    BProcessor bProcessor = new BProcessor();
    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          bProcessor.produce();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          bProcessor.consume();
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