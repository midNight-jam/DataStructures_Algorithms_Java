package darkRealm;

public class WaterJugProblem {

//
//  #365. Water and Jug Problem   :::   Complexity  -  Time : O(log(min[a,b]))  same as of GCD
//  You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available.
//  You need to determine whether it is possible to measure exactly z litres using these two jugs.
//  If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.
//  Operations allowed:
//  Fill any of the jugs completely with water.
//  Empty any of the jugs.
//  Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
//  Example 1: (From the famous "Die Hard" example)
//  Input: x = 3, y = 5, z = 4
//  Output: True
//  Example 2:
//  Input: x = 2, y = 6, z = 5
//  Output: False

  private static int getGCD(int a, int b) {
    if (a == 0) return b;
    return getGCD(b % a, a);
  }

  public static boolean canMeasureWater(int x, int y, int z) {
    if (z == 0) return true;
    if (x == 0 || y == 0 || x + y < z) return false;
    int gcd = getGCD(x, y);
    return z % gcd == 0;
  }

  public static void main(String[] args) {
    int x = 35, y = 15, z = 4;
//    int x = 3, y = 5, z = 4;
//    int x = 2, y = 6, z = 5;
    boolean res = canMeasureWater(x, y, z);
    System.out.println("x : " + x + " y : " + y + " z : " + z);
    System.out.println("R : " + res);
  }
}
