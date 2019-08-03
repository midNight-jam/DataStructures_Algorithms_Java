package darkRealm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinimumAreaRectangle {

//  939. Minimum Area Rectangle
//  Given a set of points in the xy-plane, determine the minimum area of a rectangle formed from these points, with
//  sides parallel to the x and y axes.
//  If there isn't any rectangle, return 0.
//
//  Example 1:
//  Input: [[1,1],[1,3],[3,1],[3,3],[2,2]]
//  Output: 4
//
//  Example 2:
//  Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
//  Output: 2
//
//  Note:
//      1 <= points.length <= 500
//      0 <= points[i][0] <= 40000
//      0 <= points[i][1] <= 40000
//  All points are distinct.


  private static class Point {
    int[] cords;

    // x = cords[0]
    // y = cords[1]
    Point(int[] c) {
      if (c == null || c.length != 2) return;
      cords = c;
    }

    @Override
    public int hashCode() {
      return Arrays.hashCode(cords);
    }

    @Override
    public boolean equals(Object o2) {
      Point p2 = (Point) o2;
      return Arrays.equals(cords, p2.cords);
    }
  }

  // As the given points are of sides which are parallel to X & Y axis, then for a rectangle to be formed with this limitations
  // we need to find 2 points such that other 2 points can be generated from their X & Y coordinates
  // For ex : if points (1,1) & (3,3) are of sides which are parallel to axis's & form a rectangle then the other 2 points
  // of such rectangle must be (1,3) & (3,1),
  // Means with given points (x1,y1) & (x2,y2) if (x1,y2) & (x2,y1) are also present then we have a rectangle
  // using this invariant we can confirm if there is a rectangle possible with this points and if present we calculate
  // and update the minArea

  public static int minAreaRect(int[][] points) {
    if (points == null || points.length < 1 || points[0].length < 1) return 0;
    Set<Point> set = new HashSet<>();
    for (int[] p : points)
      set.add(new Point(p));

    int res = Integer.MAX_VALUE;
    for (int i = 0; i < points.length; i++) {
      int[] x1y1 = points[i];
      for (int j = i + 1; j < points.length; j++) {
        int[] x2y2 = points[j];

        // if points on same edge continue
        if ((x1y1[0] == x2y2[0]) || (x1y1[1] == x2y2[1])) continue;

        int[] x1y2 = new int[]{x1y1[0], x2y2[1]};
        int[] x2y1 = new int[]{x2y2[0], x1y1[1]};
        if (set.contains(new Point(x1y2)) && set.contains(new Point(x2y1))) {
          int len = x2y2[0] - x1y1[0];
          int breadth = x2y2[1] - x1y1[1];
          int area = Math.abs(len * breadth);
          res = Math.min(res, area);
        }
      }
    }

    return res == Integer.MAX_VALUE ? 0 : res;
  }

  public static void main(String[] args) {
//    int[][] points = new int[][]{{1, 1}, {1, 3}, {3, 1}, {3, 3}, {2, 2}};
    int[][] points = new int[][]{{3, 2}, {3, 1}, {4, 4}, {1, 1}, {4, 3}, {0, 3}, {0, 2}, {4, 0}};

    int minAreaRect = minAreaRect(points);

    for (int[] p : points)
      System.out.println(Arrays.toString(p));

    System.out.println("Res : " + minAreaRect);
  }
}