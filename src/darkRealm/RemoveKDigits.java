package darkRealm;


public class RemoveKDigits {


//  402. Remove K Digits
//  Given a non-negative integer num represented as a string, remove k digits from the number so that the new number
//  is the smallest possible.
//
//      Note:
//  The length of num is less than 10002 and will be ≥ k.
//  The given num does not contain any leading zero.
//      Example 1:
//
//  Input: num = "1432219", k = 3
//  Output: "1219"
//  Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
//  Example 2:
//
//  Input: num = "10200", k = 1
//  Output: "200"
//  Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
//      Example 3:
//
//  Input: num = "10", k = 2
//  Output: "0"
//  Explanation: Remove all the digits from the number and it is left with nothing which is 0.

  public static String removeKdigits(String num, int k) {
    if(num == null || num.length() < 0) return num;

    /*
    * The idea is to remove the first peak digit from the num, why firs, because the first peak no will be of higher
    * ten power then the one which to the right (as power ten decreases from left to right). And after removing such
    * peaks remove any remaining leading 0's. Complexity : O(n*k)
    * Previously I had the solution of taking the min at each stage after removing a single digit & pass it on
    * recursively till k > 0, but that TLE's easily as the complexity was O(n2k)*/

    int peakIndex;
    String smaller;
    while(k-- > 0){
      peakIndex = 1;
      while(peakIndex < num.length() && num.charAt(peakIndex - 1) <= num.charAt(peakIndex))
          peakIndex++;
      peakIndex--; // becase the prev index was a peak when we break;
      smaller = num.substring(0, peakIndex) + num.substring(peakIndex + 1);
      num = smaller;
    }
    
    // remove leading 0's
    int zi = 0;
    for(; zi < num.length(); zi++)
      if(num.charAt(zi) != '0') break;
    
    num = num.substring(zi);
    // if no nonZero digits then whole string is madeup of 0's just return 0.
    return num.length() > 0 ? num : "0";
  }


  public static void main(String[] args) {
    String num = "000000000001000000";
    int k = 1;
    String res = removeKdigits(num, k);
    System.out.println(res);
  }
}
