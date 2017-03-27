package Threading;

import java.util.Scanner;

/**
 * Created by Jayam on 3/26/2017.
 */
public class Processor extends Thread {
  public volatile boolean running = true; // prevent the thread from caching the variable when they are not changed

  public void shutDown() {
    running = false;
  }

  public void run() {
    try {
      while (running) {
        System.out.println(" [-_-] ");
        Thread.sleep(250);
      }
    } catch (InterruptedException e) {
      System.out.println("Interuurpted " + e);
    }
  }

  public static void main(String[] args) {
    Processor proc1 = new Processor();
    proc1.start();
    Scanner sc = new Scanner(System.in);
    sc.nextLine();  // Arificial break mechanism, as the main thread will hault for input & after the input we break
    proc1.shutDown();
  }
}