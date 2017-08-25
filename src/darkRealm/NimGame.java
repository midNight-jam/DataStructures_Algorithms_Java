package darkRealm;

public class NimGame {

//  You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of
// you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the
// first turn to remove the stones.
//
//  Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can
// win the game given the number of stones in the heap.
//
//  For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you
// remove, the last stone will always be removed by your friend.

  public static boolean canWin(int n) {
    // The one who gets the multiple of 4 coins will always loose the game, else you can pick some coin & pass the multiple
    // of 4 coins to the opponent so that he always loose
    return n % 4 != 0;
  }

  public static boolean canWinOnTurn(int n, boolean turn) {
    if (n < 4) return true;
    int myPick = n % 4;
    if (myPick == 0) return !turn;
    return canWinOnTurn(n - myPick, !turn);
  }

  public static boolean canWinOLD(int n) {
    if(1 > n) return false;
    return canWinOnTurn(n, true);
  }

  public static void main(String[] args) {
//    int n = 4;
//    int n = 3;
//    int n = 2;
//    int n = 1;
//    int n = 0;
//    int n = 5;
//    int n = 6;
//    int n = 7;
    int n = 8;
    boolean res = canWin(n);
    System.out.println("Stones : " + n + "\nRes : " + res);
  }
}