package darkRealm;

public class ExtendedEuclideanAlgorithm {

  //  Solves the equation - a(p) + b(q) = d   - iff d is a multiple of gcd of p & q
//  p and q and computes the greatest
//  common divisor of p and q using the extended Euclid's algorithm.
//  Also prints out integers a and b such that a(p) + b(q) = gcd(p, q).
//
//  The extended Euclidean algorithm updates results of gcd(a, b) using the results calculated by recursive call
//  gcd(b%a, a). Let values of x and y calculated by the recursive call be x1 and y1. x and y are updated using
//  below expressions.
//  x = y1 - ⌊b/a⌋ * x1
//  y = x1
  private static int[] solveEquation(int p, int q) {
    if (q == 0)
      return new int[]{p, 1, 0};
    int[] vals = solveEquation(q, p % q);
    int d = vals[0];
    int a = vals[2];
    int b = vals[1] - (p / q) * a;
    return new int[]{d, a, b};
  }

  public static void main(String[] args) {
//    int p = 35, q = 15;
    int p = 4, q = 6;
    int vals[] = solveEquation(p, q);
    System.out.println("gcd(" + p + ", " + q + ") = " + vals[0]);
    System.out.println(vals[1] + "(" + p + ") + " + vals[2] + "(" + q + ") = " + vals[0]);
  }
}