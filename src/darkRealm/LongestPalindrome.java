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

  public static int longestPalidrome(String str) {
    if (null == str || 0 == str.length())
      return 0;
    Set<Character> set = new HashSet<>();
    int count = 0;
    for (char c : str.toCharArray())
      if (set.contains(c)) {
        count++;
        set.remove(c);
      } else
        set.add(c);
    return set.isEmpty() ? count * 2 : count * 2 + 1;
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