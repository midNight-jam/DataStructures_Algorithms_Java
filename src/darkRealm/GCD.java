package darkRealm;

public class GCD {

  //Complexity  ::: Time - O(log(min[a,b]))
  private static int gcd(int big, int small) {
    int temp;
    // If we mod the smaller number from larger we reduce the larger number and GCD doesnt changes, so we keep
    // moding till the remainder is 0
    while (small > 0) {
      temp = small;
      small = big % small;
      big = temp;
    }
    return big;
  }

  public static void main(String[] args) {
//    int a = 10, b = 15;
//    int a = 31, b = 2;
    int a = 63, b = 28;
    int gcd = gcd(b, a);
    System.out.println("G : " + gcd);
  }
}
