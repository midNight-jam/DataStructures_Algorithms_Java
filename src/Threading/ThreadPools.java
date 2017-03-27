package Threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jayam on 3/27/2017.
 */
class TProcessor implements Runnable{

  private int id;
  public TProcessor(int id){
    this.id = id;
  }

  @Override
  public void run(){
    System.out.println(" Starting : "+id);
    try{
      Thread.sleep(5000);// simulate work
    }
    catch (InterruptedException e){
      e.printStackTrace();
    }
    System.out.println(" Finished : "+id);
  }
}
public class ThreadPools {

  public static void main(String[] args) {
    // ExecutorService has its own managerial thread
    ExecutorService executor = Executors.newFixedThreadPool(2); // no of worker threads in pool
    for (int i = 0; i < 5; i++) {
      // no of tasks to be executed by the workers in the pool
      executor.submit(new TProcessor(i));
    }

    executor.shutdown();//  Telling ExecutorService's managerial thread to stop accepting new thread/tasks from this point

    System.out.println("All Tasks Submitted");
    try {
      executor.awaitTermination(100, TimeUnit.SECONDS); // The upperbound of time for waiting for each task to
      // get completed, beyond this time this thread will continue to its own work & wont wait
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}