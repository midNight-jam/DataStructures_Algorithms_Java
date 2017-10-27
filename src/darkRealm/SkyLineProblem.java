package darkRealm;

import java.util.*;

public class SkyLineProblem {

  // #218. The Skyline Problem
  // TODO Tests passed 35/36
  public static List<int[]> getSkyline(int[][] buildings) {
    List<int[]> res = new ArrayList<>();
    if (buildings == null || buildings.length == 0 || buildings[0].length == 0) return res;
    List<Integer[]> edges = new ArrayList<>();
    // The idea is to capture appropriate height when any rectangle begins or ends
    for (int i = 0; i < buildings.length; i++) {
      edges.add(new Integer[]{buildings[i][0], -buildings[i][2]}); // negative because we want to differentiate between left edge & right edge
      edges.add(new Integer[]{buildings[i][1], buildings[i][2]}); // left edge means rectangle started, right edge means it ended
    }
    //Sort the edges
    Collections.sort(edges, new Comparator<Integer[]>() {
      @Override
      public int compare(Integer[] o1, Integer[] o2) {
        return (o1[0] != o2[0]) ? o1[0] - o2[0] : o1[1] - o2[1];// if they are not same, then in their position at X axis
        // else by thier height
      }
    });

    Queue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    });

    int prev = 0;
    maxHeap.offer(0); // initialization
    for (Integer[] edge : edges) {
      if (edge[1] < 0) { // if its a left edge means rectangle has started thus insert its height in to maxHeap
        maxHeap.offer(-edge[1]); // making height positive
      } else maxHeap.remove(edge[1]); // if its an right edge means rectangle has ended thus remove its height from heap
      // because this rectangle can no more have its influence over other heights
      int curr = maxHeap.peek(); // get height of tallest building in right now
      if (curr != prev) { // if curr is diff then prev, means there has been a change in height beacuse of rectangle ending thus record it
        res.add(new int[]{edge[0], curr});
        prev = curr;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[][] buildings = new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
    List<int[]> res = getSkyline(buildings);
    for (int[] a : res)
      System.out.println(Arrays.toString(a));
  }
}
