package darkRealm;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
//  933. Number of Recent Calls
//  Write a class RecentCounter to count recent requests.
//  It has only one method: ping(int t), where t represents some time in milliseconds.
//  Return the number of pings that have been made from 3000 milliseconds ago until now.
//  Any ping with time in [t - 3000, t] will count, including the current ping.
//  It is guaranteed that every call to ping uses a strictly larger value of t than before.
//  Example 1:
//  Input: inputs = ["RecentCounter","ping","ping","ping","ping"], inputs = [[],[1],[100],[3001],[3002]]
//  Output: [null,1,2,3,3]
//  Note:
//  Each test case will have at most 10000 calls to ping.
//  Each test case will call ping with strictly increasing values of t.
//  Each call to ping will have 1 <= t <= 10^9.

  Queue<Integer> que;

  public RecentCounter() {
    que = new LinkedList<>();
  }

  public int ping(int t) {
    que.add(t);
    int old = t - 3000;
    while (que.size() > 0) {
      if (que.peek() < old) {
        que.poll();
      } else
        break;
    }
    return que.size();
  }

  public static void main(String[] args) {
    RecentCounter rc = new RecentCounter();

    System.out.println("time 1 : " + rc.ping(1));
    System.out.println("time 100 : " + rc.ping(100));
    System.out.println("time 3001 : " + rc.ping(3001));
    System.out.println("time 3002 : " + rc.ping(3002));


//    System.out.println("time 1178 : " + rc.ping(1178));
//    System.out.println("time 1483 : " + rc.ping(1483));
//    System.out.println("time 1563 : " +rc.ping(1563));
//    System.out.println("time 4054 : " + rc.ping(4054));
//    System.out.println("time 4152 : " + rc.ping(4152));
  }
}