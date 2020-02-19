package darkRealm;

import java.util.*;

public class TopKFrequentElements {

//347. Top K Frequent Elements
//  Given a non-empty array of integers, return the k most frequent elements.
//
//      Example 1:
//
//  Input: nums = [1,1,1,2,2,3], k = 2
//  Output: [1,2]
//  Example 2:
//
//  Input: nums = [1], k = 1
//  Output: [1]
//  Note:
//
//  You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
//  Your algorithm's time complexity must be better than O(n log n), where n is the array's size.


  public List<Integer> topKFrequent(int[] nums, int k) {
    if (nums == null || nums.length < 1) return new ArrayList<>();

    Map<Integer, Integer> map = new HashMap<>();
    for (int n : nums) {
      if (!map.containsKey(n))
        map.put(n, 0);
      map.put(n, map.get(n) + 1);
    }

    PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] < o2[0]) return -1;
        else if (o1[0] > o2[0]) return 1;
        return o2[1] - o2[1];
      }
    });

    for (int key : map.keySet()) {
      minHeap.offer(new int[]{map.get(key), key});
      if (minHeap.size() > k)
        minHeap.poll();
    }

    List<Integer> res = new ArrayList<>();
    while (!minHeap.isEmpty())
      res.add(minHeap.poll()[1]);

    return res;
  }
}
