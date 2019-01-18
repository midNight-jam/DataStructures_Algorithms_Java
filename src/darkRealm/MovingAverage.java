package darkRealm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MovingAverage {

//  #346. Moving Average from Data Stream
//  Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
//  For example,
//  MovingAverage m = new MovingAverage(3);
//  m.next(1) = 1
//    m.next(10) = (1 + 10) / 2
//    m.next(3) = (1 + 10 + 3) / 3
//    m.next(5) = (10 + 3 + 5) / 3

  Queue<Integer> que;
  int windowLength;
  double sum;

  public MovingAverage(int size) {
    que = new LinkedList<>();
    windowLength = size;
    sum = 0;
  }

  public double next(int val) {
    que.offer(val);
    sum += val;

    if(que.size() > windowLength)
      sum -= que.poll();

    return sum / que.size();
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