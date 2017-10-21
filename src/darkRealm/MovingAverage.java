package darkRealm;

import java.util.ArrayList;
import java.util.List;

public class MovingAverage {

//  #346. Moving Average from Data Stream
//  Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
//  For example,
//  MovingAverage m = new MovingAverage(3);
//  m.next(1) = 1
//    m.next(10) = (1 + 10) / 2
//    m.next(3) = (1 + 10 + 3) / 3
//    m.next(5) = (10 + 3 + 5) / 3

  private int windowSize;
  private List<Integer> window;
  private double movingAvg;
  private long sum;

  public MovingAverage(int size) {
    windowSize = size;
    this.sum = 0;
    window = new ArrayList<>();
    movingAvg = 0.0;
  }

  public double next(int val) {
    if (window.size() < windowSize) {
      sum += val;
      window.add(val);
    } else {
      sum -= window.get(0);
      window.remove(0);
      window.add(val);
      sum += val;
    }
    movingAvg = sum / window.size();
    return (int)movingAvg;
  }

  public static void main(String[] args) {
    MovingAverage m = new MovingAverage(3);
    double avg = m.next(1);
    System.out.println("M : " + avg);
    avg = m.next(10);
    System.out.println("M : " + avg);
    avg = m.next(3);
    System.out.println("M : " + avg);
    avg = m.next(5);
    System.out.println("M : " + avg);
  }
}