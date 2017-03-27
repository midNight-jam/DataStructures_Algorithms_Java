package Threading;

/**
 * Created by Jayam on 3/26/2017.
 */
class Runner extends Thread{
  @Override
  public void run(){
    try {
      for (int i = 0; i < 10; i++) {
        System.out.println(" - " + i);
        Thread.sleep(1000);//
      }
    }
    catch (InterruptedException e){
      System.out.println(e);
    }
  }
}
public class AppThread {
  public static void main(String[] args) {
    Runner runner = new Runner();
    runner.start(); // Start another thread and run method in it
    // runner.run(); // This would also run the method, but it will run the runner class method in the same main thread
    // THus we use start, to start another thread for executoin
    Runner runner2 = new Runner();
    runner2.start(); // Starts another thread
    //runner.start(); // IllegalThreadStateException, starting an alreaduy running thread

  }
}
