package darkRealm;

public class SquareRoot {

//  Implement int sqrt(int x).
//  Compute and return the square root of x.

  public static int sqrt(int x) {
    if(x < 1) return 0;
    if(x == 1) return x;

    int low = 0, high = x, mid;
    // pay attention to high - 1
    // bcoz @ 1 < 2 - 1, we should terminate, else endless loop
    while (low < high - 1) {
      mid = low + (high - low) / 2;
      //ATTENTION HERE : previuosly I was using (mid * mid  < x) expression, but this was causing overflow for higher
      // mids, thats why I shift one mid in denominator and use (mid < (x / mid))
      if (mid  < (x / mid)) low = mid;
      else if (mid > (x / mid)) high = mid;
      else  return mid;
    }
    return low;
  }

  public static void main(String[] args) {
//    int x = 25;
//    int x = 16;
//    int x = 15;
//    int x = 10;
//    int x = 3;
//    int x = 9;
    int x = 2147395599;
    int res = sqrt(x);
    System.out.println("N : " + x + "\nR : " + res);
  }
}
