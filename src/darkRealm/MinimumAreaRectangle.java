package darkRealm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MinimumAreaRectangle {

  private static class Point {
    int x;
    int y;

    Point(int x, int y){
      this.x = x; this.y = y;
    }

    @Override
    public int hashCode() {
      //Generates a hash code for a sequence of input values.
      return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
      Point p = (Point) obj;
      return this.x == p.x && this.y == p.y;
    }
  }

  public static int minAreaRect(int[][] points) {
    if (points == null || points.length < 1 || points[0].length < 1) return 0;
    int res = Integer.MAX_VALUE;
    Set<Point> set = new HashSet<>();

    // As the given points are of sides which are parallel to X & Y axis, then for a rectangle to be formed with this limitations
    // we need to find 2 points such that other 2 points can be generated from their X & Y coordinates
    // For ex : if points (1,1) & (3,3) are of sides which are parallel to axis's & form a rectangle then the other 2 points
    // of such rectangle must be (1,3) & (3,1),
    // Means with given points (x1,y1) & (x2,y2) if (x1,y2) & (x2,y1) are also present then we have a rectangle
    // using this invariant we can confirm if there is a rectangle possible with this points and if present we calculate
    // and update the minArea

    for (int[] p : points)
      set.add(new Point(p[0], p[1]));

    int[] _1p;
    int[] _2p;
    Point _3p;
    Point _4p;
    int x1, y1, x2, y2, length, breadth, area;

    for (int i = 0; i < points.length; i++) {
      _1p = points[i];  // (x1, y1)
      for (int j = 0; j < points.length; j++) {
        if (i == j) continue;
        _2p = points[j];    // (x2, y2)
        _3p = new Point(_1p[0], _2p[1]);  // (x1,y2)
        _4p = new Point(_2p[0], _1p[1]);  // (x2,y1)

        x1 = _1p[0];
        y1 = _1p[1];
        x2 = _2p[0];
        y2 = _2p[1];

        // (1,1) & (1,3),  then x1y2 = (1,3) & x2y1 = (1,1) which are again then skip them
        // (2,1) & (3,1),  then x1y2 = (2,1) & x2y1 = (3,1) which are again then skip them
        if(x1 == x2 || y1 == y2)
          continue;

        // if other coordinates of form (x1,y2) & (x2,y1) are also present then we have a rectangle
        if (set.contains(_3p) && set.contains(_4p)) {
          // calculate the area and update the minArea
          length = Math.abs(x1 - x2);
          breadth = Math.abs(y1 - y2);
          area = length * breadth;
          res = Math.min(area, res);
        }
      }
    }
    return res == Integer.MAX_VALUE ? 0 : res;
  }

  public static void main(String[] args) {
    int[][] points = new int[][]{{1, 1}, {1, 3}, {3, 1}, {3, 3}, {2, 2}};
    int minAreaRect = minAreaRect(points);

    for(int[] p : points)
      System.out.println(Arrays.toString(p));

    System.out.println("Res : " + minAreaRect);
  }
}