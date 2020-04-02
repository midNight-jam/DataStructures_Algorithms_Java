package darkRealm;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {


  //  986. Interval List Intersections
//  Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
//
//  Return the intersection of these two interval lists.
//
//      (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
//      The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented
//      as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
//
//
//
//  Example 1:
//
//
//
//  Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
//  Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
//  Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
//
//
//      Note:
//
//      0 <= A.length < 1000
//      0 <= B.length < 1000
//      0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
//
  public int[][] intervalIntersection(int[][] A, int[][] B) {
    if (A == null || B == null) return new int[0][0];
    List<int[]> res = new ArrayList<>();
    int ai = 0;
    int bi = 0;
    int as, ae, bs, be;
    while (ai < A.length && bi < B.length) {
      as = A[ai][0];
      ae = A[ai][1];
      bs = B[bi][0];
      be = B[bi][1];

      int ns = Math.max(as, bs);
      int ne = Math.min(ae, be);
      if (ns <= ne) // if new range is possible add it to res
        res.add(new int[]{ns, ne});

      // increment the ptrs if we have exhausted that particular range
      if (ne == ae)
        ai++;
      if (ne == be)
        bi++;
    }


    int[][] arr = new int[res.size()][];
    for (int i = 0; i < res.size(); i++)
      arr[i] = res.get(i);

    return arr;
  }

  public static void main(String[] args) {

  }
}
