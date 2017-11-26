package darkRealm;

public class TwoKeysKeyboard {

//  #650. 2 Keys Keyboard     :::   Complexity  O(logN)
//  Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:
//  Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
//  Paste: You can paste the characters which are copied last time.
//  Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted.
//  Output the minimum number of steps to get n 'A'.
//  Example 1:
//  Input: 3
//  Output: 3
//  Explanation:
//  Intitally, we have one character 'A'.
//  In step 1, we use Copy All operation.
//  In step 2, we use Paste operation to get 'AA'.
//  In step 3, we use Paste operation to get 'AAA'.


  public static int minSteps(int n) {
    if (n < 1) return 0;
    int steps = 0;
    // why +d, bcoz copy and paste are 2 operations for 8 :
    // #1 : copy 1, paste 1 - total 2
    // #2 : copy 2, paste 2 - total 4
    // #3 : copy 4, paste 4 - total 8   Total steps : 3
    // For 5
    // #1 : copy 1, paste 1 - total 2
    // #2 :        paste 1 - total 3
    // #3 :        paste 1 - total 4
    // #4 :        paste 1 - total 5    Total Steps : 5
    for (int d = 2; d <= n; d++) {
      while (n % d == 0) {
        steps += d;
        n /= d;
      }
    }
    return steps;
  }

  public static void main(String[] args) {
    int n = 8;
    int res = minSteps(n);
    System.out.println("N : " + n);
    System.out.println("R : " + res);
    n = 7;
    res = minSteps(n);
    System.out.println("N : " + n);
    System.out.println("R : " + res);
  }
}
