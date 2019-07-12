package darkRealm;

import java.util.*;

public class MergeIntervals {

//  #56. Merge Intervals
//  Given a collection of intervals, merge all overlapping intervals.
//  For example,
//  Given [1,3],[2,6],[8,10],[15,18],
//  return [1,6],[8,10],[15,18].

 public static int[][] merge(int[][] intervals) {
    if(intervals == null || intervals.length < 1) return intervals;
    
    Arrays.sort(intervals, new Comparator<int[]>(){
      public int compare(int [] o1, int[] o2){
        if(o1[0] < o2[0]) return -1;
        else if(o1[0] > o2[0]) return 1;
        return 0;
      }
    });
    
    Stack<int[]> stack = new Stack<>();
    stack.push(intervals[0]);
    
    for(int i = 1; i < intervals.length; i++){
      int [] prev = stack.peek();
      int [] curr = intervals[i]; 
    
      if(curr[0] <= prev[1]){
        int start = Math.min(prev[0], curr[0]);
        int end = Math.max(prev[1], curr[1]);
        int [] newRange = new int[]{start, end};
        stack.pop();
        stack.push(newRange);
      }
      else
        stack.push(curr);
    }
    
    int[][] res = new int[stack.size()][2];
    int i = stack.size() - 1;
    
    while(stack.size() > 0)
      res[i--] = stack.pop();
    
    
    return res;
  }

  public static void main(String[] args) {
//    List<Interval> intervals = new ArrayList<>(Arrays.asList(new Interval[]{
//        new Interval(1, 3),
//        new Interval(3, 6),
//        new Interval(7, 10),
//        new Interval(15, 18)
//    }));


    int[][] intervals = new int[][] {{1,3},{2,6},{8,10},{15,18}};
    intervals = merge(intervals);
    for (Interval i : intervals)
      System.out.println(i.start + " - " + i.end);
  }
}
