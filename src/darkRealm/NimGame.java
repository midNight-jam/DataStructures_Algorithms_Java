package darkRealm;

public class NimGame {
// 292. Nim Game
//  You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of
// you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the
// first turn to remove the stones.
//
//  Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can
// win the game given the number of stones in the heap.
//
//  For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you
// remove, the last stone will always be removed by your friend.

  public static boolean canWinNim(int n) {
    // The one who gets the multiple of 4 coins will always loose the game, else you can pick some coin & pass the multiple
    // of 4 coins to the opponent so that he always loose
    if (n < 1) return false;
    if (((n >> 2) << 2) == n) return false;
    // This is a fast way to check if a no is a multiple of 4.
    // If you plot the binary of multiples of 4 we will see that the last 2 bits are always 0.
    // Thus, shifting the no right by 2 (droppping the last 2 bits) and then shifting the no to right again by 2 (multiply
    // by 4) if the no remains same then the no is a multiple of 4.
    
    // if we cant loose we always win
    return true;
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
    boolean res = canWinNim(n);
    System.out.println("Stones : " + n + "\nRes : " + res);
  }
}
