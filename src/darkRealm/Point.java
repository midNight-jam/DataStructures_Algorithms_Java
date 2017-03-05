package darkRealm;

/**
 * Created by Jayam on 3/4/2017.
 */
public class Point {
  private final double x;
  private final double y;

  Point() {
    x = y = 0;
  }

  Point(double xx, double yy) {
    x = xx;
    y = yy;
  }

  @Override
  public String toString() {
    return x + " , " + y;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public Point shifted(double nx, double ny) {
    return new Point(x + nx, y + ny);
  }

  public double getDist(Point second) {
    double dx = x - second.x;
    double dy = y - second.y;
    return Math.sqrt(dx * dx + dy * dy);
  }

  public double distanceFromOrigin() {
    Point origin = new Point();
    double dx = x - origin.x;
    double dy = y - origin.y;
    return Math.sqrt(dx * dx + dy * dy);
  }

  public static void main(String[] args) {
    Point p = new Point(0.5, 0.5);
    Point q = new Point(0.45, 0.65);
    double dist = p.getDist(q);
    System.out.println("Dits : " + dist);
    System.out.println("Dist from origin  : " + p.distanceFromOrigin());
    System.out.println("Dist from origin  : " + q.distanceFromOrigin());
    System.out.println("shifted : " + p.shifted(1, 2));
  }
}