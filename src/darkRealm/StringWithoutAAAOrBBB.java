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
    char bigChar = 'a';
    char smallChar = 'b';
    // exhaust the biggercount char first
    if(A < B){
      int t = A;
      A = B;
      B = t;
      t = bigChar;
      bigChar = smallChar;
      smallChar = (char)t;
    }
    StringBuilder sbr = new StringBuilder();
    // The greedy idea is to append bigger count twice if its greater than the smaller count & then append the smallercount
    while(A > 0 || B > 0){
      // first reduce bigger count
      if(A > 0){
        sbr.append(bigChar);
        A--;
      }
      // if bigger count is greater than small count reduce again
      if(A > B){
        sbr.append(bigChar);
        A--;
      }
      if(B > 0){
        sbr.append(smallChar);
        B--;
      }
    }
    
    return sbr.toString();
  }

  public static void main(String[] args) {

  }
}
