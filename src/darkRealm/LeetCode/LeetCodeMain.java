package darkRealm.LeetCode;

import darkRealm.CTCI.LinkedLists.LinkedList;
import darkRealm.CTCI.LinkedLists.Node;

/**
 * Created by Jayam on 1/27/2017.
 */
public class LeetCodeMain {
  public static void run() {
//    testAddTwoNumbers();
//    testlongestSubstring();
//    testLongestPalindrome();
//    testZigZag();
//    testReverseInteger();
//    testStringToInteger();
//    testReverseWords();
//    testCompareVersion();
    testSurroundRegion();
  }

  public static void testAddTwoNumbers() {
    LinkedList l1 = new LinkedList();
    LinkedList l2 = new LinkedList();
    l1.add(2);
    l1.add(4);
    l1.add(3);

    l2.add(5);
    l2.add(6);
    l2.add(4);

//    LinkedList res = LC_Prob_1_50.AddTwoNumbers(l1, l2);
    Node trav = LC_Prob_1_50.AddTwoNumbers(l1, l2);
//    Node trav = res.head;
    while (trav != null) {
      System.out.println(" d : " + trav.data);
      trav = trav.next;
    }
  }

  public static void testlongestSubstring() {
//    String str = "abcabcbb";
//    String str = "bbbbb";
//    String str = "pwwkew";
    String str = "dvdf";
    int res = LC_Prob_1_50.lengthOfLongestSubstring(str);
    System.out.println(" Str : " + str + "  Longest substring : " + res);
  }

  public static void testLongestPalindrome() {
//    String str = "edbabcdcbaba";
//    String str = "ccc";
//    String str = "abb";
//    String str = "aaaa";
//    String str = "bb";
//    String str = "asdasdabceecbaasdasdasd";
//    String str = "asdasdasdbbaabbasdasdasdasdasdasdasdasdsafiwenrfblw ebrfbwjhrfb";
//    String str = "azwdzwmwcqzgcobeeiphemqbjtxzwkhiqpbrprocbppbxrnsxnwgikiaqutwpftbiinlnpyqstkiqzbggcsdzzjbrkfmhgtnbujzszxsycmvipjtktpebaafycngqasbbhxaeawwmkjcziybxowkaibqnndcjbsoehtamhspnidjylyisiaewmypfyiqtwlmejkpzlieolfdjnxntonnzfgcqlcfpoxcwqctalwrgwhvqvtrpwemxhirpgizjffqgntsmvzldpjfijdncexbwtxnmbnoykxshkqbounzrewkpqjxocvaufnhunsmsazgibxedtopnccriwcfzeomsrrangufkjfzipkmwfbmkarnyyrgdsooosgqlkzvorrrsaveuoxjeajvbdpgxlcrtqomliphnlehgrzgwujogxteyulphhuhwyoyvcxqatfkboahfqhjgujcaapoyqtsdqfwnijlkknuralezqmcryvkankszmzpgqutojoyzsnyfwsyeqqzrlhzbc";
    String str = "aaaaaaaaaaaaaaaaaabbbbbbbbbbbb";
//   String str = "bppbasooos";
    String plain = LC_Prob_1_50.longestPalindrome(str);
    System.out.println(" Str : " + str);
    System.out.println("  Longest substring : " + plain);
    System.out.println(" len " + plain.length());
  }

  public static void testZigZag() {
    String str = "paypalishiring";
    int k = 4;
//
//    String str = "ab";
//    int k = 1;

//    String str = "ABC";
//    int k = 2;

    String res = LC_Prob_1_50.zigZagConversion(str, k);
    System.out.print("str : " + str + " Level : " + k);
    System.out.print("  res : " + res);
  }

  public static void testReverseInteger() {
    int x = -123;
//    int x = Integer.MAX_VALUE;
//    int x = 10;
//    int x = 1534236469;
    int res = LC_Prob_1_50.reverseInteger(x);
    System.out.println(" x : " + x + "   res : " + res);
  }

  public static void testStringToInteger() {
//    String str = "+123";
//    String str = "+1";
//    String str = "  -0012a42";
//    String str = Integer.MAX_VALUE+"";
//    String str = "1534236469";
//    String str = "-2147483648";
    String str = "2147483648";


    int res = LC_Prob_1_50.stringToInteger(str);
    System.out.println(" Str : " + str + "   res : " + (res));
  }

  public static void testReverseWords() {
    String str = "The sky  is blue";
//    String str = "";
//    String str = "   lag     bat ";
    String res = LC_Prob_1_50.reverseWords(str);
    System.out.println(" Str : " + str + "   res : " + res);
    System.out.println(" Str : " + str.length() + "   res : " + res.length());
  }

  public static void testCompareVersion() {
//    String v1 = "  1.1.3  ";
//    String v2 = "  1.12   ";

    String v1 = "1.2.2...1";
    String v2 = "1.2.3...1";

    int res = LC_Prob_1_50.compareVersion(v1, v2);
    System.out.println(" V1: " + v1 + "   V2 : " + v2);
    System.out.println("   res : " + res);
  }

  public static void testSurroundRegion() {
//    char[][] board = new char[][]{
//        {'X', 'X', 'X', 'X'},
//        {'X', 'O', 'O', 'X'},
//        {'X', 'X', 'O', 'X'},
//        {'X', 'O', 'X', 'X'},
//    };

//    char[][] board = new char[][]{
//        {'X', 'X', 'X', 'X', 'X', 'X', 'X'},
//        {'X', 'O', 'O', 'O', 'X', 'O', 'X'},
//        {'X', 'O', 'X', 'O', 'X', 'O', 'X'},
//        {'X', 'O', 'X', 'X', 'O', 'O', 'X'},
//        {'X', 'O', 'X', 'O', 'O', 'X', 'X'},
//        {'X', 'O', 'O', 'O', 'X', 'O', 'X'},
//        {'X', 'X', 'X', 'O', 'X', 'X', 'X'},
//    };
    char[][] board = new char[0][0];

    LC_Prob_1_50.surroundedRegions(board);
  }
}