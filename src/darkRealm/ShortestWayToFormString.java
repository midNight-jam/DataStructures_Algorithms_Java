package darkRealm;

public class ShortestWayToFormString {

//1055. Shortest Way to Form String
//  From any string, we can form a subsequence of that string by deleting some number of characters (possibly no
//  deletions).
//
//  Given two strings source and target, return the minimum number of subsequences of source such that their
//  concatenation equals target. If the task is impossible, return -1.
//
//  Example 1:
//
//  Input: source = "abc", target = "abcbc"
//  Output: 2
//  Explanation: The target "abcbc" can be formed by "abc" and "bc", which are subsequences of source "abc".
//  Example 2:
//
//  Input: source = "abc", target = "acdbc"
//  Output: -1
//
//  Explanation: The target string cannot be constructed from the subsequences of source string due to the
//  character "d" in target string.
//      Example 3:
//
//  Input: source = "xyz", target = "xzyxz"
//  Output: 3
//  Explanation: The target string can be constructed as follows "xz" + "y" + "xz".
//
//  Note:
//
//  Both the source and target strings consist of only lowercase English letters from "a"-"z".
//  The lengths of source and target string are between 1 and 1000.

  public static int shortestWay(String source, String target) {
    char[] arr = source.toCharArray();
    char[] brr = target.toCharArray();
    int res = 0;
    int ai = 0;
    int bi = 0;
    int dist = -1;

    while (bi < brr.length) {
      if (arr[ai] != brr[bi]) {
        if (dist == arr.length) return -1;
        dist++;
      } else{
        bi++;
        dist = 0;
      }
      ai = (ai + 1) % arr.length;
      if (ai == 0)
        res++;
    }

    // if in middle of a ongoing scan
    if(ai > 0 && ai < arr.length)
      res++;
    return res;
  }

  public static void main(String[] args) {
//    String src = "abc";
//    String trg = "acdbc";
//    String src = "xyz";
//    String trg = "xzyxz";

    String src = "aaaaa";
    String trg = "aaaaa";
    int res = shortestWay(src, trg);
    System.out.println(res);
  }
}
