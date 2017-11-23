package darkRealm;
public class StringCompression {

//  #443. String Compression  :::   Complexity  - Time : O(N) ,  Space  : O(1)
//  Given an array of characters, compress it in-place.
//  The length after compression must always be smaller than or equal to the original array.
//  Every element of the array should be a character (not int) of length 1.
//  After you are done modifying the input array in-place, return the new length of the array.
//  Follow up:
//  Could you solve it using only O(1) extra space?
//  Example 1:
//  Input:
//      ["a","a","b","b","c","c","c"]
//  Output:
//  Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
//  Explanation:
//      "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
//  Example 2:
//  Input:
//      ["a"]
//  Output:
//  Return 1, and the first 1 characters of the input array should be: ["a"]
//  Explanation:
//  Nothing is replaced.
//      Example 3:
//  Input:
//      ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
//  Output:
//  Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
//  Explanation:
//  Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
//  Notice each digit has it's own entry in the array.
//  Note:
//  All characters have an ASCII value in [35, 126].
//      1 <= len(chars) <= 1000.



  public static int compress(char[] chars) {
    if (chars == null || chars.length == 0) return 0;
    int k = 0, h = 0, t = 0, o = 0, ptr = 0;
    char prev = chars[0];
    int count = 1;
    for (int i = 1; i < chars.length; i++) {
      if (ptr >= chars.length) return chars.length;
      if (chars[i] == prev) {
        count++;
      } else {
        chars[ptr++] = prev;
        if (count == 1) {
          prev = chars[i];
          continue;
        }
        char[] carr = String.valueOf(count).toCharArray();
        for (int p = 0; p < carr.length; p++)
          chars[ptr + p] = carr[p];
        ptr += carr.length;
        prev = chars[i];
        count = 1;
      }
    }
    chars[ptr++] = prev;
    if (count > 1) {
      char[] carr = String.valueOf(count).toCharArray();
      for (int p = 0; p < carr.length; p++)
        chars[ptr + p] = carr[p];
      ptr += carr.length;
    }
    return ptr <= chars.length - 1 ? ptr : chars.length;
  }

  public static void main(String[] args) {
//    String s = "abbbbbbbbbbbb";
//    String s = "aaaaaba";
//    String s = "aaaaab";
//    String s = "aabbccc";
//    String s = "a";
    String s = "abc";
//    String s = "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
//        "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
//        "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
//        "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
//        "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
//        "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
//        "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
//        "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
//        "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
//        "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo";

//    String s = "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
//        "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
//        "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
//        "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
//        "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
//        "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
//        "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
//        "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
//        "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo";
    char[] arr = s.toCharArray();
    System.out.println(arr);
    int res = compress(arr);
    String p = new String(arr);
    System.out.println(p.substring(0, res));
    System.out.println("R : " + res);
    System.out.println("----------------------------");
    System.out.println(arr);
  }
}
