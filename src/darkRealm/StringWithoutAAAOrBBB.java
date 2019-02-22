package darkRealm;

public class StringWithoutAAAOrBBB {

//  984. String Without AAA or BBB
//  Given two integers A and B, return any string S such that:
//  S has length A + B and contains exactly A 'a' letters, and exactly B 'b' letters;
//  The substring 'aaa' does not occur in S;
//  The substring 'bbb' does not occur in S.
//
//      Example 1:
//  Input: A = 1, B = 2
//  Output: "abb"
//  Explanation: "abb", "bab" and "bba" are all correct answers.
//
//  Example 2:
//  Input: A = 4, B = 1
//  Output: "aabaa"
//
//  Note:
//      0 <= A <= 100
//      0 <= B <= 100
//  It is guaranteed such an S exists for the given A and B.

  public static String strWithout3a3b(int A, int B) {
    char aChar = 'a', bChar = 'b';
    if (B > A) {
      int temp = A;
      A = B;
      B = temp;
      temp = aChar;
      aChar = bChar;
      bChar = (char) temp;
    }

    StringBuilder sbr = new StringBuilder();
    while (A > 0) {
      if (A > 0) {
        sbr.append(aChar);
        A--;
      }
      if (A > B) {
        sbr.append(aChar);
        A--;
      }
      if (B > 0) {
        sbr.append(bChar);
        B--;
      }
    }
    return sbr.toString();
  }

  public static void main(String[] args) {

  }
}
