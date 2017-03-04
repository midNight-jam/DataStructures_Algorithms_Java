package darkRealm;

/**
 * Created by Jayam on 3/4/2017.
 */
public class Point {
  private final double x;
  private final double y;

  Point(double xx, double yy) {
    x = xx;
    y = yy;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public double getDist(Point second) {
    double dx = x - second.x;
    double dy = y - second.y;
    return Math.sqrt(dx * dx + dy * dy);
  }

  public static void main(String[] args) {
    Point p = new Point(0.5, 0.5);
    Point q = new Point(0.45, 0.65);
    double dist = p.getDist(q);
    System.out.println("Dits : " + dist);
  }
}