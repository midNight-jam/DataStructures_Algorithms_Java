package Threading;

/**
 * Created by Jayam on 3/26/2017.
 */
class MyRunner implements Runnable{

  @Override
  public void run() {
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
public class AppRunnable {
  public static void main(String [] args){
    Thread t1 = new Thread(new MyRunner());
    t1.start();
    Thread t2 = new Thread(new MyRunner());
    t2.start();

    // Using anonymous class
    Thread t3 = new Thread(new Runner(){
      public void run(){
        try {
          for (int i = 0; i < 10; i++) {
            System.out.println(" ~ " + i);
            Thread.sleep(1000);//
          }
        }
        catch (InterruptedException e){
          System.out.println(e);
        }
      }
    });
    t3.start();
  }
}
