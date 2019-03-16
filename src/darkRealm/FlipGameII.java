package darkRealm;

import java.util.Arrays;

public class FlipGameII {

  public static boolean canWin(String s) {
    return canWinOnTurn(s.toCharArray());
  }

  private static boolean canWinOnTurn(char[] arr) {
    boolean canWin = false;
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] == '+' && arr[i + 1] == '+') {
        arr[i] = arr[i + 1] = '-'; // make choice
        canWin = !canWinOnTurn(arr); //'not' bcoz if my opponent wins i loose
        arr[i] = arr[i + 1] = '+';  // revert choice
      }
      if (canWin) return true;  // return as I can even if i try this combination, no point in trying other ways
    }
    return false;
  }


  public static void main(String[] args) {
//    String s = "+++-+++++-----++";
    String s = "+++++";
    System.out.println(s);
    boolean res = canWin(s);
    System.out.println(res);
  }
}
