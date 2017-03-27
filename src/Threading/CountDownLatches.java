package Threading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Jayam on 3/27/2017.
 */
class LProcessor implements Runnable{
  CountDownLatch latch;
  public LProcessor(CountDownLatch latch){
    this.latch  = latch;
  }

  @Override
  public void run(){
    System.out.println("Starting LProcessor");
    try{
      Thread.sleep(3000); // simulate work
    }
    catch (InterruptedException e){
      e.printStackTrace();
    }
    latch.countDown();  // decrements the countdownLatch by 1
  }
}

public class CountDownLatches {
  public static void main(String[] args) {

    CountDownLatch latch = new CountDownLatch(3); // Can be used as a counting semaphore of count 3
    ExecutorService executor = Executors.newFixedThreadPool(3);

    for (int i = 0; i < 3; i++) {
      executor.submit(new LProcessor(latch));
    }

    try {
      latch.await(); // wait till the lath has been counted down till 0
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Completed all.");
  }
}