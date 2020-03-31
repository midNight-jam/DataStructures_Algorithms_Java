package darkRealm;

import java.util.HashMap;
import java.util.Map;

public class TaskScheduler {

//621. Task Scheduler
//  Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters
//  represent different tasks. Tasks could be done without original order. Each task could be done in one interval.
//  For each interval, CPU could finish one task or just be idle.
//
//      However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n
//      intervals that CPU are doing different tasks or just be idle.
//
//  You need to return the least number of intervals the CPU will take to finish all the given tasks.
//
//
//
//      Example:
//
//  Input: tasks = ["A","A","A","B","B","B"], n = 2
//  Output: 8
//  Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
//
//
//      Constraints:
//
//  The number of tasks is in the range [1, 10000].
//  The integer n is in the range [0, 100].


  public int leastInterval(char[] tasks, int n) {
    int gap  = n;
    int maxFreq = Integer.MIN_VALUE;
    int maxFreqTasks = 0;

    Map<Character, Integer> map = new HashMap<>();
    for(char t  :tasks){
      if(!map.containsKey(t))
        map.put(t, 0);
      map.put(t, map.get(t) + 1);
    }

    for(Character c : map.keySet()){
      if(map.get(c) == maxFreq)
        maxFreqTasks++;
      if(map.get(c) > maxFreq){
        maxFreq = map.get(c);
        maxFreqTasks = 1;
      }
    }

    int noOfWindows = maxFreq - 1;
    // incase there are more than 1 most freq tasks, if not the gap will stay same (1-1 == 0)
    int lenOfWindows = gap - (maxFreqTasks - 1);
    int noOfPlacesAvail = noOfWindows * lenOfWindows;
    // what ever is not the most frequent can be used to fill up the avail places.
    int fillerTasks = tasks.length - (maxFreq * maxFreqTasks);
    int idlePlacesAfterFillerTasks = Math.max(0, noOfPlacesAvail -  fillerTasks);
    // Attention on the above, if the filler tasks are more than the noOfPlaces avail, we dont need to extra idle
    // places, thus we take the max against 0.
    // Because idlePlaces are only required to be filled in the windows, not at the end.
    //e: 4, g : 4, z : 1 & gap = 3
    // 1st step => e, _, _, _, e, _, _, _, e, _, _, _, e, --end--
    // observe the # of windows with _'s are maxFreq - 1, i.e : 4 - 1 = 3

    // 2nd step => e, g, _, _, e, g, _, _, e, g, _, _, e, g
    // observe that the len of each window is gap - (maxFreqtask - 1), i.e : 3 - 1 = 2
    // which makes the #ofavailPlaces = 3 * 2 = 6.

    // 3rd step => e, g, z, _, e, g, _, _, e, g, _, _, e, g // only one filler task
    // 4th step => e, g, z, _, e, g, _, _, e, g, _, _, e, g //
    // observe #of idle places left after using filler tasks are max (0, 6 - 1) = 5.

    int res = tasks.length + idlePlacesAfterFillerTasks;

    return res;

  }
  public static void main(String[] args) {

  }
}
