package darkRealm;

/**
 * Created by Jayam on 1/12/2019.
 */
public class JewelsAndStones {

  /*
    #771. Jewels and Stones

    You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
    Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
    The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive,
    so "a" is considered a different type of stone from "A".

    Example 1:
    Input: J = "aA", S = "aAAbbbb"
    Output: 3

    Example 2:
    Input: J = "z", S = "ZZ"
    Output: 0

    Note:
    S and J will consist of letters and have length at most 50.
    The characters in J are distinct.
  */

  public static int numJewelsInStones(String J, String S) {
    int res = 0;
    if(J == null || S == null || J.length() < 1 || S.length() < 1)
      return res;

    // As the problem states that it will be only letters we dont need to take the array of 256 chars,
    // We are taking array of 52 ( 26 small chars + 26 capital chars)
    // will fill the small letters in the first half of the array   i = c - 'A' + 0
    // and fill the capital letters in the second half of the array i = c - 'a' + 26 (offset for 26 small chars)

    int [] arr = new int[52];
    int i = 0;
    for(char c : J.toCharArray()){
      i = c >= 65 && c <= 90 ? (c - 'A') + 0 : (c - 'a') + 26;
      arr[i]++;
    }

    for(char c : S.toCharArray()){
      i = c >= 65 && c <= 90 ? (c - 'A') + 0 : (c - 'a') + 26;
      res += arr[i];
    }
    System.out.println("@>@ res : " + res);
    return res;
  }

  public static void main(String[] args) {
//    String J = "ebd";
//    String S = "bbb";

    String J = "Aa";
    String S = "zZ";
;
//    String J = "aA";
//    String S = "aAAbbbb";

//    String J = "z";
//    String S = "ZZ";

    int res = numJewelsInStones(J, S);
    System.out.println("J : " + J);
    System.out.println("S : " + S);
    System.out.println("R : " + res);
  }
}