package darkRealm;

import java.util.*;

public class MergeIntervals {

//  #56. Merge Intervals
//  Given a collection of intervals, merge all overlapping intervals.
//  For example,
//  Given [1,3],[2,6],[8,10],[15,18],
//  return [1,6],[8,10],[15,18].

  public static class Interval {
    int start;
    int end;

    Interval() {
      start = 0;
      end = 0;
    }

    Interval(int s, int e) {
      start = s;
      end = e;
    }
  }

  public static List<Interval> merge(List<Interval> intervals) {
    if (intervals == null || intervals.size() == 0) return intervals;
    Collections.sort(intervals, new Comparator<Interval>() {
      @Override
      public int compare(Interval o1, Interval o2) {
        return o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start;
      }
    });
    Stack<Interval> stack = new Stack<>();
    for (Interval t : intervals) {
      while (!stack.isEmpty() && (stack.peek().start >= t.start || t.start <= stack.peek().end)) {
        t.start = Math.min(t.start, stack.peek().start);
        t.end = Math.max(t.end, stack.peek().end);
        stack.pop();
      }
      stack.push(t);
    }

    return stack;
  }

  public static void main(String[] args) {
//    List<Interval> intervals = new ArrayList<>(Arrays.asList(new Interval[]{
//        new Interval(1, 3),
//        new Interval(3, 6),
//        new Interval(7, 10),
//        new Interval(15, 18)
//    }));


    List<Interval> intervals = new ArrayList<>(Arrays.asList(new Interval[]{
        new Interval(0, 11),
        new Interval(12, 13),
        new Interval(0, 10)
    }));
    intervals = merge(intervals);
    for (Interval i : intervals)
      System.out.println(i.start + " - " + i.end);
  }
}