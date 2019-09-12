package darkRealm;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HighFive {

//  1086. High Five
//  Given a list of scores of different students, return the average score of each student's top five scores in the
//  order of each student's id.
//
//  Each entry items[i] has items[i][0] the student's id, and items[i][1] the student's score.  The average score is
//  calculated using integer division.
//
//  Example 1:
//
//  Input: [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
//  Output: [[1,87],[2,88]]
//  Explanation:
//  The average of the student with id = 1 is 87.
//  The average of the student with id = 2 is 88.6. But with integer division their average converts to 88.
//
//
//  Note:
//
//      1 <= items.length <= 1000
//  items[i].length == 2
//  The IDs of the students is between 1 to 1000
//  The score of the students is between 1 to 100
//  For each student, there are at least 5 scores


  public int[][] highFive(int[][] items) {
    if (items == null || items.length < 1) return new int[0][0];
    Map<Integer, PriorityQueue> map = new LinkedHashMap<>();

    for (int i = 0; i < items.length; i++) {
      if (!map.containsKey(items[i][0]))
        map.put(items[i][0], getMinHeap());
      map.get(items[i][0]).offer(items[i][1]);
      if (map.get(items[i][0]).size() > 5)
        map.get(items[i][0]).poll();
    }

    int[][] res = new int[map.size()][2];
    int index = 0;
    for (int k : map.keySet()) {
      res[index][0] = k;
      int avg = 0;
      PriorityQueue<Integer> pq = map.get(k);
      while (pq.size() > 0)
        avg += pq.poll();
      res[index][1] = avg / 5;
      index++;
    }

    return res;
  }

  private PriorityQueue<Integer> getMinHeap() {
    return new PriorityQueue<Integer>(new Comparator<Integer>() {
      public int compare(Integer o1, Integer o2) {
        return Integer.compare(o1, o2);
      }
    });
  }

  public static void main(String[] args) {

  }
}
