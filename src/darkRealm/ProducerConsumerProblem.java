package darkRealm;

import java.util.LinkedList;

/**
 * Created by Jayam on 2/23/2017.
 */
public class ProducerConsumerProblem {

  public static class BoundedBuffer {
    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 2;

    public void produce() throws InterruptedException {
      int value = 0;
      while (true) {
        synchronized (this) { // providing mutual exclusion
          while (list.size() == capacity)
            wait();
          System.out.println(" Producer - " + value);
          list.add(value);
          value++;
          notify();
          Thread.sleep(1000);
        }
      }
    }

    public void consume() throws InterruptedException {
      while (true) {
        synchronized (this) {
          while (list.size() == 0)
            wait();
          int val = list.removeFirst();
          System.out.println(" Consumer consumed - " + val);
          notify();
          Thread.sleep(1000);
        }
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    BoundedBuffer bbuff = new BoundedBuffer();
    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          bbuff.produce();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          bbuff.consume();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    t1.start();
    t2.start();

    //wait till both end
    t1.join();
    t2.join();
  }
}