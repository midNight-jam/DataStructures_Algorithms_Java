package darkRealm;

import java.util.HashSet;
import java.util.Set;

public class BinaryStringWithSubstringsRepresenting1ToN {

//  1016. Binary String With Substrings Representing 1 To N
//  Given a binary string S (a string consisting only of '0' and '1's) and a positive integer N, return true if and only
//  if for every integer X from 1 to N, the binary representation of X is a substring of S.
//
//      Example 1:
//
//  Input: S = "0110", N = 3
//  Output: true
//  Example 2:
//
//  Input: S = "0110", N = 4
//  Output: false
//
//  Note:
//
//      1 <= S.length <= 1000
//      1 <= N <= 10^9

  static public boolean queryString(String s, int n) {
    if (s == null || s.length() < 1) return false;
    Set<Integer> set = new HashSet<>();

    /*
     * Create all possible substrings & convert them to int, keep track of all unique ints & its size reaches n return true
     * TIme Complexity : O(S * 31 * 31)
     * */
    for (int start = 0; start < s.length(); start++) {
      int end = Math.min(s.length(), start + 31); // at max all +ve ints will take 31 bits
      for (; end > start; end--) {
        String number = s.substring(start, end);
        int val = 0;
        int mf = 1;
        for (int i = number.length() - 1; i > -1; i--) {
          val += mf * (number.charAt(i) - '0');
          mf *= 2;
        }
        if (val > 0 && val <= n)
          set.add(val);
      }
    }

    return set.size() == n;
  }


  public static void main(String[] args) {
//    String s = "0110";
//    int n = 4;
//    boolean res = queryString(s, n);
//    System.out.println(res);
//    System.out.println(!res ? "Pass" : "Fail");


//    String s = "0110";
//    int n = 3;
//    boolean res = queryString(s, n);
//    System.out.println(res);
//    System.out.println(res ? "Pass" : "Fail");

//    String s = "1111000101";
//    int n = 5;
//    boolean res = queryString(s, n);
//    System.out.println(res);
//    System.out.println(res ? "Pass" : "Fail");

//    String s = "10010111100001110010";
//    int n = 10;
//    boolean res = queryString(s, n);
//    System.out.println(res);
//    System.out.println(!res ? "Pass" : "Fail");


    String s = "011010101010111101010101011111111111111111111111111111111110000000000000011111101010101001010101010101010101010101111" +
        "010101010111111111111111111111111111111111100000000000000111111010101010010101010101010101010100";
    int n = 1000000000;
    boolean res = queryString(s, n);
    System.out.println(res);
    System.out.println(!res ? "Pass" : "Fail");

  }
}
