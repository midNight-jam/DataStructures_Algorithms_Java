package darkRealm;

import java.util.*;

public class MinimumAreaRectangleII {
  
  
//   963. Minimum Area Rectangle II
// Given a set of points in the xy-plane, determine the minimum area of any rectangle formed from these points, with sides not
//  necessarily parallel to the x and y axes.
// If there isn't any rectangle, return 0.
// Example 1:
// Input: [[1,2],[2,1],[1,0],[0,1]]
// Output: 2.00000
// Explanation: The minimum area rectangle occurs at [1,2],[2,1],[1,0],[0,1], with an area of 2.
// Example 2:
// Input: [[0,1],[2,1],[1,1],[1,0],[2,0]]
// Output: 1.00000
// Explanation: The minimum area rectangle occurs at [1,0],[1,1],[2,1],[2,0], with an area of 1.
// Example 3:
// Input: [[0,3],[1,2],[3,1],[1,3],[2,1]]
// Output: 0
// Explanation: There is no possible rectangle to form from these points.
// Example 4:
// Input: [[3,1],[1,1],[0,1],[2,1],[3,3],[3,2],[0,2],[2,3]]
// Output: 2.00000
// Explanation: The minimum area rectangle occurs at [2,1],[2,3],[3,3],[3,1], with an area of 2.

// Note:
// 1 <= points.length <= 50
// 0 <= points[i][0] <= 40000
// 0 <= points[i][1] <= 40000
// All points are distinct.
// Answers within 10^-5 of the actual value will be accepted as correct.

  public static double minAreaFreeRect(int[][] points) {
    if (points == null || points.length < 1 || points[0].length < 1) return 0.0;
    double minArea = Double.MAX_VALUE;
    Set<String> set = new HashSet<>();
    // add all cordinates to the hash set
    for (int[] p : points) {
      set.add(p[0] + "," + p[1]);
    }
    // We use a property for finding the 3rd point of the rectangle, if we are given 3 points
    // p1 = x1,y1
    // p2 = x2,y2
    // p3 = x3,y3
    // p4 = x4,y4
    // then :
    // x4 = (x2-x1) + x3
    // y4 = (y2-y1) + y3
    //https://www.youtube.com/watch?v=FB7ZuqR_vao
    // to get vector if 2 points are given, vectors are not scalar, only their dot product is , thus we can capture
    // dot product magnitude in code
    //  (x1, y1) & (x2, y2)
    // Vector = (x2 - x1), (y2-y1)
    // Dot product of vectors of form Av = (a1, a2, a3) & Bv = (b1, b2, b3)
    // Av.Bv = (a1.b1 +  a2.b2 + a3.b3)
    // Dor product of 2 perpendicular vectors is = 0
    // A.B = 0
    int x1, x2, x3, x4, y1, y2, y3, y4;
    double m1, m2;
    for (int i = 0; i < points.length; i++) {
      for (int j = 0; j < i; j++) {
        for (int k = 0; k < j; k++) {
          int[] p1 = points[i], p2 = points[j], p3 = points[k];
          // get the fourth point
          int x = p2[0] + p3[0] - p1[0];
          int y = p2[1] + p3[1] - p1[1];
          // two lines needs to be vertical

          // finding 2 vectors using 3 points
          // v1 = (x2 - x1), (y2 - y1)
          // v2 = (x3 - x1), (y3 - y1)
          // Dot Product of V1.V2 == 0 if they are perpendicular
          boolean dotProductOfVectors = checkDirectionHelper(points[i], points[j], points[k]);

          // if 4th point present and dotproduct == 0
          if (set.contains(x + "," + y) && dotProductOfVectors) {
            double area = areaHelper(p1, p2, p3);
            System.out.println(area);
            minArea = Math.min(area, minArea);
          }
        }
      }
    }
    return minArea == Double.MAX_VALUE ? 0.0 : minArea;
  }

  private static double distance(int[]p1, int []p2) {
    return Math.sqrt(Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
  }
  private static boolean  checkDirectionHelper(int[] p1, int[] p2, int[] p3) {
    int x1 = p1[0], y1 = p1[1], x2 = p2[0], y2 = p2[1], x3 = p3[0], y3 = p3[1];
    return (y2 - y1) * (y3 - y1) + (x2 - x1) * (x3 - x1) == 0;
  }
  private static double areaHelper(int[] p1, int[] p2, int[] p3) {
    double d1 = distance(p1, p2);
    double d2 = distance(p2, p3);
    double d3 = distance(p1, p3);
    List<Double> distances = new ArrayList<Double>();
    distances.add(d1);
    distances.add(d2);
    distances.add(d3);
    Collections.sort(distances);
    return distances.get(0) * distances.get(1);
  }

  public static void main(String[] args) {
//    int[][] points = new int[][]{{1, 2}, {2, 1}, {1, 0}, {0, 1}};
//    int[][] points = new int[][]{{0, 1}, {2, 1}, {1, 1}, {1, 0}, {2, 0}};
    int[][] points = new int[][]{{0, 3}, {1, 2}, {3, 1}, {1, 3}, {2, 1}};
    Double res = minAreaFreeRect(points);
    System.out.println("res : " +res);
  }
}
