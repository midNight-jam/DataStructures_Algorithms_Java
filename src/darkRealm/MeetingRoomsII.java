package darkRealm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {

//  253. Meeting Rooms II
//  Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
//  find the minimum number of conference rooms required.
//
//  Example 1:
//
//  Input: [[0, 30],[5, 10],[15, 20]]
//  Output: 2
//  Example 2:
//
//  Input: [[7,10],[2,4]]
//  Output: 1
//  NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new
//  method signature.


  public static int minMeetingRooms(int[][] intervals) {
    if (intervals == null || intervals.length < 1) return 0;
    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int o2[]) {
        if (o1[0] < o2[0]) return -1;
        else if (o1[0] > o2[0]) return 1;
        return o1[1] - o2[1];
      }
    });

    // We will use maxHeap to keep track of the max end time of a meeting.
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

    int max = Integer.MAX_VALUE;

    for (int i = 0; i < intervals.length; i++) {
      int start = intervals[i][0];
      int end = intervals[i][1];
      // if this meeting starts after the max end times of previous meeting, then pop all such times
      while (!maxHeap.isEmpty() && start >= maxHeap.peek())
        maxHeap.poll();
      maxHeap.offer(end);

      max = Math.max(maxHeap.size(), max); // current size of heap is equal to the no of meeting rooms required
    }

    return max;
  }

  public static void main(String[] args) {
    int[][] arr = new int[][]{{0, 30}, {5, 10}, {15, 20}, {6, 9}};
    int res = minMeetingRooms(arr);
    System.out.println(res);
  }
}
