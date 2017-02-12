package darkRealm.LeetCode;

import darkRealm.CTCI.BigO.MatrixUtil;
import darkRealm.CTCI.LinkedLists.LinkedList;
import darkRealm.CTCI.LinkedLists.Node;
import darkRealm.CTCI.Trees_and_Graphs.TNode;
import darkRealm.CTCI.Trees_and_Graphs.Tree;
import darkRealm.CTCI.Trees_and_Graphs.Trees_and_Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
//    testSurroundRegion();
//    testThreeSum();
//    testThreeSumClosest();
//    testCountingBits();
//    testCircularLoop();
//    testDuplicates();
//    testMissing();
//    testMissingFirstPositive();
//    testDuplicateNumber();
//    testSingleNumber();
//    testFindAnagram();
//    testValidString();
//    testRotateClockwise();
//    testexceptSelf();
//    testRandomizeSet();
//    testSlidingMaximum();
//    testFirstUniqueChar();
//    testMaxProfit();
//    testLetterCombinations();
//    testGroupAnagram();
//    testValidAnagram();
//    testTrappingRainWater();
//    testRotateAntiClockWise();
//    testPascalsTriangle();
//    testThirdMaximum();
//    testSubsets();
//    testRotateFunction();
//    testNumberOfIslands();
//    testWordLadder();
//    testRegularExpression();
//    testLongestPalindromeString();
//    testTwoSum();
//    testSubStringPattern();
//    testMostFrequentSum();
//    testGrayCode();
    testFrequencySort();
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

//    LinkedList res = LC_Prob_Med.AddTwoNumbers(l1, l2);
    Node trav = LC_Prob_Med.AddTwoNumbers(l1, l2);
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
    int res = LC_Prob_Med.lengthOfLongestSubstring(str);
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
    String plain = LC_Prob_Med.longestPalindrome(str);
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

    String res = LC_Prob_Med.zigZagConversion(str, k);
    System.out.print("str : " + str + " Level : " + k);
    System.out.print("  res : " + res);
  }

  public static void testReverseInteger() {
    int x = -123;
//    int x = Integer.MAX_VALUE;
//    int x = 10;
//    int x = 1534236469;
    int res = LC_Prob_Med.reverseInteger(x);
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


    int res = LC_Prob_Med.stringToInteger(str);
    System.out.println(" Str : " + str + "   res : " + (res));
  }

  public static void testReverseWords() {
    String str = "The sky  is blue";
//    String str = "";
//    String str = "   lag     bat ";
    String res = LC_Prob_Med.reverseWords(str);
    System.out.println(" Str : " + str + "   res : " + res);
    System.out.println(" Str : " + str.length() + "   res : " + res.length());
  }

  public static void testCompareVersion() {
//    String v1 = "  1.1.3  ";
//    String v2 = "  1.12   ";

    String v1 = "1.2.2...1";
    String v2 = "1.2.3...1";

    int res = LC_Prob_Med.compareVersion(v1, v2);
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

    char[][] board = new char[][]{
        {'X', 'X', 'X', 'X', 'X', 'X', 'X'},
        {'X', 'O', 'O', 'O', 'X', 'O', 'X'},
        {'X', 'O', 'X', 'O', 'X', 'O', 'X'},
        {'X', 'O', 'X', 'X', 'O', 'O', 'X'},
        {'X', 'O', 'X', 'O', 'O', 'X', 'X'},
        {'X', 'O', 'O', 'O', 'X', 'O', 'X'},
        {'X', 'X', 'X', 'O', 'X', 'X', 'X'},
    };
//    char[][] board = new char[0][0];

    LC_Prob_Med.surroundedRegions(board);
  }

  public static void testThreeSum() {
    int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
//    int[] arr = new int[]{-2, 0, 1, 2, -1, 4};
//    int[] arr = new int[]{-1, 3, 1, 2, -1, -2};
//    int[] arr = new int[]{-1,0,1,2,-1,-4};
//    int[] arr = new int[]{0, 0, 0, 0};
//    int[] arr = new int[]{-12, 3, 4, 1, 6, 9};
//    int[] arr = new int[]{-2,0,1,1,2};

    List<List<Integer>> res = LC_Prob_Med.threeSum(arr);
    for (int i = 0; i < res.size(); i++) {
      System.out.println("   res : " + Arrays.toString(res.get(i).toArray()));
    }
  }

  public static void testCountingBits() {
//    int n =-3;
//    int n =0;
    int n = 5;
    int[] arr = LC_Prob_Med.countingBits(n);
    System.out.println("n : " + n + "  " + Arrays.toString(arr));
  }

  public static void testCircularLoop() {
//    int[] arr = new int[]{2, -1, 1, 2, 2};
//    int[] arr = new int[]{1, -2, 1};
//    int[] arr = new int[]{1, 1, 1};
    int[] arr = new int[]{-2, 1, -1 - 2, -2};
//    int[] arr = new int[]{-1,2};
    boolean res = LC_Prob_Med.isCircularArrayLoop(arr);
    System.out.println("res  : " + res + "  " + Arrays.toString(arr));
  }

  public static void testDuplicates() {
//    int[] arr = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
    int[] arr = new int[]{4, 3, 2, 5, 6, 1, 3, 4, 5};
    List<Integer> res = LC_Prob_Med.findDuplicates(arr);
    System.out.println("res  : " + Arrays.toString(res.toArray()) + "  " + Arrays.toString(arr));
  }

  public static void testMissing() {
//    int[] arr = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
    int[] arr = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
    List<Integer> res = LC_Prob_Med.disappearedNumbers(arr);
    System.out.println("res  : " + Arrays.toString(res.toArray()) + "  " + Arrays.toString(arr));
  }

  public static void testMissingFirstPositive() {
//    int[] arr = new int[0];
//    int[] arr = new int[]{-2,2,3};
//    int[] arr = new int[]{3,4,2,1};
//    int[] arr = new int[]{3,4,-1,1};
//    int[] arr = new int[]{1, 2, 0};
//    int[] arr = new int[]{1};
//    int[] arr = new int[]{2};
//    int[] arr = new int[]{0};
    int[] arr = new int[]{1, 1};
    int res = LC_Prob_Med.firstMissingPositive(arr);
    System.out.println("res  : " + res + "  " + Arrays.toString(arr));
  }

  public static void testDuplicateNumber() {
//    int[] arr = new int[]{2, 5, 1, 1, 4, 3};
//    int[] arr = new int[]{1, 1};
    int[] arr = new int[]{3, 1, 3, 4, 2};
//    int[] arr = new int[]{4,1,2,3,2};
//    int[] arr = new int[]{1,2,3,2};
    int res = LC_Prob_Med.duplicateNumber(arr);
    System.out.println("res  : " + res + "  " + Arrays.toString(arr));
  }

  public static void testSingleNumber() {
//    int [] arr  = new int[]{3,2,3,4,1,2,1};
//    int [] arr  = new int[0];
//    int [] arr  = new int[]{1};
    int[] arr = new int[]{1, 1};
//    int [] arr  = new int[]{1,1,-1};
    int res = LC_Prob_Med.singleNumber(arr);
    System.out.println("res  : " + res + "  " + Arrays.toString(arr));
  }

  public static void testFindAnagram() {
    String str = "cbaebabacd";
//    String str = "aaa";
//    String str = "cba";
//    String str = "abab";
    String anagram = "ab";
//    String str = "ccacc";
//    String anagram ="cc";
//    String anagram ="aa";
    List<Integer> res = LC_Prob_Med.findAnagrams(str, anagram);
    System.out.println(" Str : " + str + "  anagram : " + anagram);
    System.out.println(" Str : " + Arrays.toString(res.toArray()));
  }

  public static void testValidString() {
    String str = "[]]";
    boolean res = LC_Prob_Med.isValidParanthesis(str);
    System.out.println(" Str : " + str + "  valid : " + res);
  }

  public static void testRotateClockwise() {
    int[][] matrix = new int[][]{
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}
    };

    MatrixUtil.rotateMatrixClockWise(matrix);
    System.out.println(MatrixUtil.getPrintableMatrix(matrix));
  }

  public static void testRotateAntiClockWise() {
    int[][] matrix = new int[][]{
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}
    };
    System.out.println(MatrixUtil.getPrintableMatrix(matrix));
    MatrixUtil.rotateMatrixAntiClockWise(matrix);
    System.out.println(MatrixUtil.getPrintableMatrix(matrix));
  }

  public static void testexceptSelf() {
    int[] arr = new int[]{1, 2, 3, 4};
    arr = LC_Prob_Med.productExceptSelf(arr);
    System.out.println(" Arr : " + Arrays.toString(arr));
  }

  public static void testThreeSumClosest() {
//    int[] arr = new int[]{-1, 2, 1, -4};
    int[] arr = new int[]{0, 0, 0, 0};
//    int[] arr = new int[]{ 1, -4};
    int target = 1;
    int res = LC_Prob_Med.threeSumClosest(arr, target);
    System.out.println("res : " + res + " Arr : " + Arrays.toString(arr));
  }

  public static void testRandomizeSet() {
    RandomizedSet rset = new RandomizedSet();
    boolean res = rset.insert(13);
    res = rset.insert(13);
    rset.insert(5);
    int rand = rset.getRandom();
    rand = rset.getRandom();
    rand = rset.getRandom();
    rand = rset.getRandom();

    res = rset.remove(1);
    res = rset.remove(13);
  }

  public static void testSlidingMaximum() {
    int[] arr = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
    int k = 3;
//    int[] arr = new int[]{9,10,9,-7,-4,-8,2,-6};
//    int k = 5;

    int[] nos = LC_Prob_Med.slidingWindowMaximum(arr, k);
    System.out.println("Arr : " + Arrays.toString(arr));
    System.out.println("List : " + Arrays.toString(nos));
  }

  public static void testFirstUniqueChar() {
//    String str = "leetcode";
//    String str = "loveleetcode";
    String str = null;
    int res = LC_Prob_Med.firstUniqueCharacter(str);
    System.out.println("res : " + res + "  Str : " + str);
  }

  public static void testMaxProfit() {
//    int[] arr = new int[]{7, 1, 5, 3, 6, 4};
//    int[] arr = new int[]{7, 6, 4, 3, 1};
//    int[] arr = new int[]{7, 6, 4, 3, 1, 5, 7};
//    int[] arr = new int[]{2, 4, 1};
    int[] arr = new int[]{-2, 2, 4, 1, 2, 3, 5, 6};
    int res = LC_Prob_Med.maxProfit(arr);
    System.out.println("res : " + res + "  prices : " + Arrays.toString(arr));
  }

  public static void testLetterCombinations() {
//    int num = 23;
//    int num = 21;
//    List<String> res = LC_Prob_Med2.letterCombinations(num);
//    System.out.println("Arr : " + Arrays.toString(res.toArray()));

    String num = "3";

    List<String> res = LC_Prob_Med2.letterCombinations(num);
    System.out.println("Arr : " + Arrays.toString(res.toArray()));
  }

  public static void testGroupAnagram() {
//    String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
//    String[] strs = new String[]{""};
//    String[] strs = new String[]{"tea","","eat","","tea",""};
//    String[] strs = new String[]{"ape","and","cat"};
    String[] strs = new String[]{"", "b"};
    List<List<String>> res = LC_Prob_Med2.groupAnagrams(strs);
    System.out.println("Res : " + Arrays.toString(res.toArray()));
  }

  public static void testValidAnagram() {
    String s = "anagram", t = "nagaram";
//    String s = "", t = "nagaram";
//    String s = "", t = "";
//    String s = "", t = null;
//    String s = "a", t ="a";

    boolean res = LC_Prob_Med2.validAnagram(s, t);
    System.out.println("Res : " + res + " S : " + s + "  T : " + t);
  }

  public static void testTrappingRainWater() {
//    int[] world = new int[]{2, 1, 0, 1, 3, 2, 1};
//    int[] world = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    int[] world = new int[]{5, 4, 1, 2};
    int res = LC_Prob_Med2.trappingRainWater(world);
    System.out.println("Res : " + res);
  }

  public static void testPascalsTriangle() {
    int n = 5;
    List<Integer> res = LC_Prob_Med2.pascalsTriangleRow(n);
    System.out.println(n + "th row : " + res);
  }

  public static void testThirdMaximum() {
//    int[] arr = new int[]{3, 2, 1};
//    int[] arr = new int[]{2, 2, 3, 1};
//    int[] arr = new int[]{1,2,2,5,3,5};
//    int[] arr = new int[]{1,2};
//    int[] arr = new int[]{1,1,2};
//    int[] arr = new int[]{2, 1};
//    int[] arr = new int[]{2, 1,Integer.MIN_VALUE};
    int[] arr = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
    int res = LC_Prob_Med2.thirdMaximumNumber(arr);
    System.out.println(" res : " + res + "  Arr : " + Arrays.toString(arr));
  }

  public static void testSubsets() {
    int[] arr = new int[]{1, 2, 3};
    List<List<Integer>> res = LC_Prob_Med2.subSet(arr);
    System.out.println(" Arr : " + Arrays.toString(arr));
    System.out.println(" Subsets : " + res);
  }

  public static void testRotateFunction() {
    int[] arr = new int[]{4, 3, 2, 6};
    int res = LC_Prob_Med2.rotate(arr);
    System.out.println("res : " + res + " Arr : " + Arrays.toString(arr));
  }

  public static void testNumberOfIslands() {
    int[][] matrix = new int[][]{{1, 1, 0, 0, 0},
        {0, 1, 0, 0, 1},
        {1, 0, 0, 1, 1},
        {0, 0, 0, 0, 0},
        {1, 0, 1, 0, 1}
    };
    int islands = LC_Prob_Med2.numberOfIslands(matrix);
    System.out.println(" Islands : " + islands);
    System.out.println(MatrixUtil.getPrintableMatrix(matrix));
  }

  public static void testWordLadder() {
    List<String> dict = new ArrayList<>();

    String[] arr = new String[]{"hot", "cog", "dot", "dog", "hit", "lot", "log"};
    dict.addAll(Arrays.asList(arr));
    String start = "hit";
    String end = "cog";

//    String[] arr = new String[]{"hot", "dot", "dog", "lot", "log"};
//    dict.addAll(Arrays.asList(arr));
//    String start = "hit";
//    String end ="cog";
//
//    String[] arr = new String[]{"a","b","c"};
//    dict.addAll(Arrays.asList(arr));
//    String start = "a";
//    String end = "c";

    int res = LC_Prob_Med2.wordLadder(start, end, dict);
//    List<List<String>> res = LC_Prob_Med2.wordLadderDFS(start, end, dict);
    System.out.println("res : " + res);
  }

  public static void testRegularExpression() {
//    String str = "aab";
//    String pat = "c*a*b";
//
//    String str = "xaabyc";
//    String pat = "xa*b.c";
//
    String str = "abcd";
    String pat = "d*";


    boolean res = LC_Prob_Med2.regularExpressionMatching(str, pat);
    System.out.println(" Str : " + str + "  Pattern : " + pat);
    System.out.println(" Res : " + res);
  }

  public static void testLongestPalindromeString() {
//    String str = "babad";
//    String str = "dababad";
//    String str = "cbbd";
    String str = "bb";
//    String str = "a";

    String res = LC_Prob_Med2.longestPalindrome(str);
    System.out.println("Str : " + str + " res : " + res);
  }

  public static void testTwoSum() {
//    int[] arr = new int[]{2, 7, 11, 15};
//    int targer = 9;

//    int[] arr = new int[]{3,3};
//    int targer = 6;

    int[] arr = new int[]{3, 2, 4};
    int targer = 6;
    int[] res = LC_Prob_Med2.twoSum(arr, targer);
    System.out.println(Arrays.toString(arr) + "  target : " + targer);
    System.out.println(Arrays.toString(res));
  }

  public static void testSubStringPattern() {
//    String str = "aaaabbaaaaba";
//    String str = "abab";
//    String str = "aba";
    String str = "abcabcabcabc";
    boolean res = LC_Prob_Med2.repeatedSubStringPattern(str);
    System.out.println("Res : " + res + " Str : " + str);
  }

  public static void testMostFrequentSum() {
//    TNode node = new TNode(5);
//    node.left = new TNode(2);
//    node.right = new TNode(-3);
//    Tree tree = new Tree();
//    tree.root = node;

    TNode node = new TNode(5);
    node.left = new TNode(2);
    node.right = new TNode(-5);
    Tree tree = new Tree();
    tree.root = node;

    int[] res = Trees_and_Graphs.findFrequentTreeSum(tree.root);
    System.out.println(" Final res : " + Arrays.toString(res));
  }

  public static void testGrayCode() {
    int n = 3;
    List<Integer> res = LC_Prob_Med2.grayCode(n);
    System.out.println(" N : " + n + " gray : " + res);
  }

  public static void testFrequencySort(){
//    String str = "tree";
//    String str = "zaaactcccfddtddzdeef";
//    String str = "cccaaa";
    String str = "Aabb";
    String res = LC_Prob_Med2.sortByFrequency(str);
    System.out.println("Str : "+str+" Sorted : "+res);
  }
}