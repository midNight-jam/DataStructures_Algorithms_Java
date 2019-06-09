package darkRealm;

import java.util.HashMap;
import java.util.Map;

public class ValidSquare {

//  #593. Valid Square
//  Given the coordinates of four points in 2D space, return whether the four points could construct a square.
//  The coordinate (x,y) of a point is represented by an integer array with two integers.
//  Example:
//  Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
//  Output: True
//  Note:
//  All the input integers are in the range [-10000, 10000].
//  A valid square has four equal sides with positive length and four equal angles (90-degree angles).
//  Input points have no order.

  public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    double[] lens = new double[]{
        getDistance(p1, p2),
        getDistance(p2, p3),
        getDistance(p3, p4),
        getDistance(p4, p1),
        getDistance(p1, p3),
        getDistance(p2, p4),
    };
    Map<Double, Integer> map = new HashMap<>();
    for (double l : lens)
      map.put(l, map.getOrDefault(l, 0) + 1);
    if(map.size() != 2) return false;
    boolean four = false, diag = false;
    for(double d: map.keySet())
      if(map.get(d) == 2) diag = true;
      else if(map.get(d) == 4) four = true;
      else return false;
    return (four && diag);
  }
  private static double getDistance(int[] p, int[] q) {
    return Math.sqrt(Math.pow(p[0] - q[0], 2) + Math.pow(p[1] - q[1], 2));
  }

  public static void main(String[] args) {
//    int[] p1 = new int[]{0, 0};
//    int[] p2 = new int[]{1, 1};
//    int[] p3 = new int[]{1, 0};
//    int[] p4 = new int[]{0, 2};
//
    int[] p1 = new int[]{0, 0};
    int[] p2 = new int[]{1, 1};
    int[] p3 = new int[]{1, 0};
    int[] p4 = new int[]{0, 1};

//    int[] p1 = new int[]{1, 0};
//    int[] p2 = new int[]{-1, 0};
//    int[] p3 = new int[]{0, 1};
//    int[] p4 = new int[]{0, -1};

//    int[] p1 = new int[]{0, 1};
//    int[] p2 = new int[]{1, 2};
//    int[] p3 = new int[]{0, 2};
//    int[] p4 = new int[]{0, 0};

    boolean res = validSquare(p1, p2, p3, p4);
    System.out.println("R : " + res);
  }
}
