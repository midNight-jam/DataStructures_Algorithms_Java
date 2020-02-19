package darkRealm;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom {

//  252. Meeting Rooms
//  Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
//  determine if a person could attend all meetings.
//
//  Example 1:
//
//  Input: [[0,30],[5,10],[15,20]]
//  Output: false
//  Example 2:
//
//  Input: [[7,10],[2,4]]
//  Output: true

  public boolean canAttendMeetings(int[][] intervals) {
    if (intervals == null || intervals.length < 1) return true;

    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] < o2[0]) return -1;
        else if (o1[0] > o2[0]) return 1;
        return o1[1] - o2[1];
      }
    });

    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] < intervals[i - 1][1]) return false;
    }

    return true;
  }
}
