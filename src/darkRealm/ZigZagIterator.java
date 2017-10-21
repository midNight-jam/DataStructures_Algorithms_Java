package darkRealm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigZagIterator {

//  #281. Zigzag Iterator
//  Given two 1d vectors, implement an iterator to return their elements alternately.
//  For example, given two 1d vectors:
//  v1 = [1, 2]
//  v2 = [3, 4, 5, 6]
//  By calling next repeatedly until hasNext returns false, the order of elements returned by next should be:
//  [1, 3, 2, 4, 5, 6].
//  Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
//  Clarification for the follow up question - Update (2015-09-18):
//  The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you,
//  replace "Zigzag" with "Cyclic". For example, given the following input:
//      [1,2,3]
//      [4,5,6,7]
//      [8,9]
//  It should return [1,4,8,2,5,9,3,6,7].

  private List<Integer> v1, v2;
  int[] pointers;
  List<List<Integer>> lists;
  int ptr;
  int consumed;
  int k;

  public ZigZagIterator(List<Integer> v1, List<Integer> v2) {
    this.v1 = v1;
    this.v2 = v2;
    pointers = new int[2];
    lists = new ArrayList<>();
    lists.add(v1);
    lists.add(v2);
    ptr = 0;
    consumed = v1.size() + v2.size();
    k = 2;
  }

  public int next() {
    int res = 0;
    if (pointers[ptr] < lists.get(ptr).size()){
      res = lists.get(ptr).get(pointers[ptr]);
      pointers[ptr]++;
      ptr = (ptr + 1) % k;
    }
    else {
      while (pointers[ptr] == lists.get(ptr).size()) ptr = (ptr + 1) % k;
      res = lists.get(ptr).get(pointers[ptr]);
      pointers[ptr]++;
      ptr = (ptr + 1) % k;
    }
    consumed--;
    return res;
  }

  public boolean hasNext() {
    return consumed > 0;
  }

  public static void main(String[] args) {
    List<Integer> v1 = new ArrayList<>(Arrays.asList(new Integer[]{1, 2}));
    List<Integer> v2 = new ArrayList<>(Arrays.asList(new Integer[]{3, 4, 5, 6}));
    ZigZagIterator zz = new ZigZagIterator(v1, v2);
    while (zz.hasNext())
      System.out.println(zz.next());
  }
}