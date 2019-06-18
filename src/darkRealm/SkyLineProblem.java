package darkRealm;

import java.util.*;

public class SkyLineProblem {

  // #218. The Skyline Problem

    public static List<List<Integer>> getSkylineEASYTOUNDERSTAND(int[][] buildings) {
    Map<Integer, List<Integer>> leftEdge = new HashMap(); // map of list because at same point many buildings can start/end
    Map<Integer, List<Integer>> rightEdge = new HashMap();
    Set<Integer> points = new TreeSet<>(); // soreted set because these will be distinct points used for scanning our maps

    for (int i = 0; i < buildings.length; i++) {
      if(!leftEdge.containsKey(buildings[i][0]))
        leftEdge.put(buildings[i][0], new ArrayList<>());
      leftEdge.get(buildings[i][0]).add(buildings[i][2]);

      if(!rightEdge.containsKey(buildings[i][1]))
        rightEdge.put(buildings[i][1], new ArrayList<>());
      rightEdge.get(buildings[i][1]).add(buildings[i][2]);

      points.add(buildings[i][0]);
      points.add(buildings[i][1]);
    }

    // maxHeap to keep the max height for any given point
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
      public int compare(Integer o1, Integer o2) {
        if (o1 > o2) return -1;
        else if (o2 > o1) return 1;
        else return 0;
      }
    });

    int height = 0;
    int prevHeight = 0;
    List<List<Integer>> res = new ArrayList<>();

    for (int trav : points) {
      if (leftEdge.containsKey(trav)){  // add all the heights that are starting at this point
        List<Integer> heights = leftEdge.get(trav);
        for(int  h : heights)
          maxHeap.offer(h);
      }

      if (rightEdge.containsKey(trav)){// remove all the heights that are ending at this point
        List<Integer> heights = rightEdge.get(trav);
        for(int  h : heights)
          maxHeap.remove(h);
      }

      height = maxHeap.size() > 0 ? maxHeap.peek() : 0;
      if (height != prevHeight) {
        res.add(new ArrayList<Integer>(Arrays.asList(trav, height)));
      }
      prevHeight = height;
    }

    return res;
  }
  
  
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
