package darkRealm;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {

//  299. Bulls and Cows
//  You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to
//  guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits
//  in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits
//  match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses
//  and hints to eventually derive the secret number.
//
//  Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls
//  and B to indicate the cows.
//
//  Please note that both secret number and friend's guess may contain duplicate digits.
//
//  Example 1:
//
//  Input: secret = "1807", guess = "7810"
//
//  Output: "1A3B"
//
//  Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
//  Example 2:
//
//  Input: secret = "1123", guess = "0111"
//
//  Output: "1A1B"
//
//  Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
//  Note: You may assume that the secret number and your friend's guess only contain digits, and their lengths are
//  always equal.

  public static String getHint(String s, String g) {
    if (s == null || g == null) return "";
    char[] arr = s.toCharArray();
    char[] brr = g.toCharArray();

    int bull, cow;
    bull = cow = 0;

    int i = 0;
    int j = 0;
    char ca, cb;
    while (i < arr.length || j < brr.length) {
      ca = i < arr.length ? arr[i] : ' ';
      cb = j < brr.length ? brr[j] : ' ';
      if (ca == cb && ca != ' ') {
        arr[i] = brr[j] = 'X';
        bull++;
      }
      i++;
      j++;
    }

    Map<Character, Integer> map = new HashMap<>();

    for (int ii = 0; ii < arr.length; ii++) {
      if (arr[ii] == 'X') continue;
      if (!map.containsKey(arr[ii]))
        map.put(arr[ii], 0);
      map.put(arr[ii], map.get(arr[ii]) + 1);
    }

    for (int jj = 0; jj < brr.length; jj++) {
      if (brr[jj] == 'X' || !map.containsKey(brr[jj])) continue;
      if (map.get(brr[jj]) > 0) {
        cow++;
        map.put(brr[jj], map.get(brr[jj]) - 1);
      }
    }

    return bull + "A" + cow + "B";
  }


  public static void main(String[] args) {
    String s = "1123";
    String g = "0111";
    String res = getHint(s, g);
    System.out.println(res);
  }
}
