package darkRealm;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

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
