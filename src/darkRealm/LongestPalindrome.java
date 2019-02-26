package darkRealm;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {

//  Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that
//  can be built with those letters.
//  This is case sensitive, for example "Aa" is not considered a palindrome here.
//  Note:
//  Assume the length of given string will not exceed 1,010.
//  Example:
//  Input:
//      "abccccdd"
//  Output:
//      7
//  Explanation:
//  One longest palindrome that can be built is "dccaccd", whose length is 7.

  public static int longestPalidrome(String s) {
    if (s == null || s.length() < 1) return 0;

    int[] map = new int[256];
    for (char c : s.toCharArray())
      map[c]++;

    int res = 0;
    boolean odd = false;
    int freq;
    for (int i = 0; i < map.length; i++) {
      freq = map[i];
      if ((freq & 1) == 0)
        res += freq; // if even times this char can contribute to the palindrome
      else {
        odd = true;
        res += freq - 1; // as it is odd time we are taking the max even from it bcoz same no of chars on both side
      }
    }

    // now account for odd,
    // bcoz if there were any chars that were present odd times, we can only use one of them for a valid palindrome
    return odd ? res + 1 : res;
  }

  public static void main(String[] args) {
//    String str = "abAcccAcddA";
//    String str = "bb";
    String str = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatb" +
        "attlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlives" +
        "hatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannot" +
        "consecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorpon" +
        "wertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItis" +
        "forusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisra" +
        "therforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontotha" +
        "tcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainth" +
        "atthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperi" +
        "shfromtheearth";

    int res = longestPalidrome(str);
    System.out.println("Str : " + str);
    System.out.println("Res : " + res);
  }
}