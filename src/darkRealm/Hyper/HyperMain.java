package darkRealm.Hyper;

import ADT.LLNode;
import darkRealm.CTCI.BigO.MatrixUtil;
import ADT.LinkedList;
import ADT.TNode;
import ADT.Tree;
import darkRealm.CTCI.Trees_and_Graphs.Trees_and_Graphs;
import darkRealm.LeastFrequentlyUsed;
import darkRealm.LeastRecentlyUsed;
import darkRealm.RandomizedSet;
import darkRealm.TinyURL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jayam on 1/27/2017.
 */
public class HyperMain {
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
//    testThreeSumSmaller();
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
//    testSubsetsII();
//    testRotateFunction();
//    testNumberOfIslands();
//    testWordLadder();
//    testWordLadderII();
//    testRegularExpression();
//    testLongestPalindromeString();
//    testTwoSum();
//    testSubStringPattern();
//    testMostFrequentSum();
//    testGrayCode();
//    testFrequencySort();
//    testWordBreak();
//    testLongestPalindromicSubsequence();
//    testWordBreakSequence();
//    testSN();`
//    testMaxProfitII();
//    testMaxProfitIII();
//    testMaxProfitIV();
//    testLongestTwoCHarString();
//    testLongestKDistinctString();
//    testLRU();
//    testLFU();
//    testWashingMachines();
//    testLongestValidParanthesis();
//    testLongestStringWithoutRepeatingChars();
//    testLongestSubstringWithAtLeastKRepeatingCharacters();
//    testTextJustification();
//    testSlidingWindowMaximum();
//    testKthLargest();
//    testRussianDolls();
//    testMulitply();
//    testPlusOne();
//    testAddBinary();
//    testAddDigits();
//    testDetectCapitals();
//    testLevelMaxValues();
//    testIterativeLevelOrder();
//    testBottomLeft();
//    testCircumference();
//    testMaxPathSum();
//    testInorderIterative();
//    testzigZag();
//    testPostOrderIterative();
//    testMoveZeroes();
//    testDivide();
//    testBaseChange();
//    testSortLinkedList();
//    testTinyUrl();
//    testKPairs();
//    testNumberPalindrome();
//    testHappyNumber();
  }

  public static void testLongestPalindrome() {
//
  }
  public static void testSurroundRegion() {
//    char[][] board = new char[][]{
//        {'X', 'X', 'X', 'X'},
//        {'X', 'O', 'O', 'X'},
//        {'X', 'X', 'O', 'X'},
//        {'X', 'O', 'X', 'X'},
//    };


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

  public static void testSingleNumber() {
//    int [] arr  = new int[]{3,2,3,4,1,2,1};
//    int [] arr  = new int[0];
//    int [] arr  = new int[]{1};
    int[] arr = new int[]{1, 1};
//    int [] arr  = new int[]{1,1,-1};
    int res = LC_Prob_Med.singleNumber(arr);
    System.out.println("res  : " + res + "  " + Arrays.toString(arr));
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
  public static void testThreeSumClosest() {
//    int[] arr = new int[]{-1, 2, 1, -4};
//    int[] arr = new int[]{0, 0, 0, 0};
    int[] arr = new int[]{0, 1, 2};
//    int[] arr = new int[]{ 1, -4  };
//    int[] arr = new int[]{ 1, -4};
    int target = 3;
    int res = LC_Prob_Med.threeSumClosest(arr, target);
    System.out.println("res : " + res + " Arr : " + Arrays.toString(arr));
  }

  public static void testMaxProfitII() {
//    int[] arr = new int[]{7, 1, 5, 3, 6, 4};
//    int[] arr = new int[]{7, 6, 4, 3, 1};
//    int[] arr = new int[]{7, 6, 4, 3, 1, 5, 7};
//    int[] arr = new int[]{2, 4, 1};
    int[] arr = new int[]{-2, 2, 4, 1, 2, 3, 5, 6};
    int res = LC_Prob_Med.maxProfitII(arr);
    System.out.println("res : " + res + "  prices : " + Arrays.toString(arr));
  }

  public static void testMaxProfitIII() {
//    int[] arr = new int[]{7, 1, 5, 3, 6, 4};
//    int[] arr = new int[]{7, 6, 4, 3, 1};
//    int[] arr = new int[]{7, 6, 4, 3, 1, 5, 7};
//    int[] arr = new int[]{2, 4, 1};
//    int[] arr = new int[]{-2, 2, 4, 1, 2, 3, 5, 6};
    int[] arr = new int[]{1, 4, 5, 7, 6, 3, 2, 9};
//    int res = LC_Prob_Med.maxProfitIIIDP(arr);
    int res = LC_Prob_Med.maxProfitIII(arr);
    System.out.println(Arrays.toString(arr) + "  prices : " + "res : " + res);
  }

  public static void testMaxProfitIV() {
//    int[] arr = new int[]{7, 1, 5, 3, 6, 4};
//    int[] arr = new int[]{7, 6, 4, 3, 1};
//    int[] arr = new int[]{7, 6, 4, 3, 1, 5, 7};
//    int[] arr = new int[]{2, 4, 1};
//    int[] arr = new int[]{-2, 2, 4, 1, 2, 3, 5, 6};
//    int[] arr = new int[]{1, 4, 5, 7, 6, 3, 2, 9};
    int[] arr = new int[]{2, 5, 7, 1, 4, 3, 1, 3};
    int k = 3;
    int res = LC_Prob_Med.maxProfitFinal(arr, k);
    System.out.println(Arrays.toString(arr) + "  prices : " + "res : " + res);
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
//    int[] arr = new int[]{1, 2, 3};
    int[] arr = new int[]{1, 2, 2};
    List<List<Integer>> res = LC_Prob_Med2.subSet(arr);
    System.out.println(" Arr : " + Arrays.toString(arr));
    System.out.println(" Subsets : " + res);
  }

  public static void testSubsetsII() {
//    int[] arr = new int[]{1, 2, 2};
    int[] arr = new int[]{4, 4, 4, 1, 4};
//    int[] arr = new int[]{1,2,3};
//    int[] arr = new int[]{1,2,3,4,5};
//    int[] arr = new int[]{1, 2, 2, 3 ,4};
    List<List<Integer>> res = LC_Prob_Med2.subSetII(arr);
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

//    String[] arr = new String[]{"hot", "cog", "dot", "dog", "hit", "lot", "log"};
//    dict.addAll(Arrays.asList(arr));
//    String start = "hit";
//    String end = "cog";


    String[] arr = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
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

  public static void testWordLadderII() {
    List<String> dict = new ArrayList<>();

//    String[] arr = new String[]{"hot", "cog", "dot", "dog", "hit", "lot", "log"};
//    dict.addAll(Arrays.asList(arr));
//    String start = "hit";
//    String end = "cog";


    String[] arr = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
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

    List<List<String>> res = LC_Prob_Med2.wordLadderII(start, end, dict);
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

  public static void testFrequencySort() {
//    String str = "tree";
//    String str = "zaaactcccfddtddzdeef";
//    String str = "cccaaa";
    String str = "Aabb";
    String res = LC_Prob_Med2.sortByFrequency(str);
    System.out.println("Str : " + str + " Sorted : " + res);
  }

  public static void testWordBreak() {
//    String str = "leetcoder";
//    List<String> dict = new ArrayList<>();
//    dict.add("leet");
//    dict.add("code");
//    dict.add("coder");

    String str = "catsanddog";
    List<String> dict = new ArrayList<>();
    dict.add("cat");
    dict.add("sand");
    dict.add("dog");
//    String str = "Iamace";
//    List<String> dict = new ArrayList<>();
//    dict.add("I");
//    dict.add("a");
//    dict.add("am");
//    dict.add("ace");
//
//    String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
//        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
//    String str = "aaaabaaaaaa";
//    List<String> dict = new ArrayList<>();
//    dict.add("b");
//    dict.add("a");
//    dict.add("aa");
//    dict.add("aaa");
//    dict.add("aaaa");
//    dict.add("aaaaa");
//    dict.add("aaaaaa");
//    dict.add("aaaaaaa");
//    dict.add("aaaaaaaa");
//    dict.add("aaaaaaaaa");
//    dict.add("aaaaaaaaaa");
//
//    String str = "bb";
//    List<String> dict = new ArrayList<>();
//    dict.add("b");
//    dict.add("a");
//    dict.add("bbb");
//    dict.add("bbbb");
    Long start = System.currentTimeMillis();
    boolean res = LC_Prob_Med2.wordBreak(str, dict);
    System.out.println(" " + (System.currentTimeMillis() - start));
    System.out.println(" Res : " + res + " str : " + str + " Dict : " + dict);
  }

  public static void testWordBreakSequence() {
//    String str = "leetcoder";
//    List<String> dict = new ArrayList<>();
//    dict.add("leet");
//    dict.add("code");
//    dict.add("coder");

//    String str = "catsanddog";
    String str = "catsanddogstop";
//    String str = "catsanddogstopz";
//    String str = "catsanddogs";
//    String str = "catsanddog";
//    String str = "catanddog";
//    String str = "catsand";
//    String str = "catand";
//    String str = "cat";
//    String str = "ca";
//    String str = "c";
//    String str = "";
//    String str = null;
    List<String> dict = new ArrayList<>();
    dict.add("cat");
    dict.add("sand");
    dict.add("dog");
    dict.add("dogs");
    dict.add("and");
    dict.add("top");
    dict.add("stop");
    dict.add("cats");
//    String str = "Iamace";
//    List<String> dict = new ArrayList<>();
//    dict.add("I");
//    dict.add("a");
//    dict.add("am");
//    dict.add("ace");
//
//    String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
//        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
//    String str = "aaaabaaaaaa";
//    List<String> dict = new ArrayList<>();
//    dict.add("b");
//    dict.add("a");
//    dict.add("aa");
//    dict.add("aaa");
//    dict.add("aaaa");
//    dict.add("aaaaa");
//    dict.add("aaaaaa");
//    dict.add("aaaaaaa");
//    dict.add("aaaaaaaa");
//    dict.add("aaaaaaaaa");
//    dict.add("aaaaaaaaaa");
//
//    String str = "bb";
//    List<String> dict = new ArrayList<>();
//    dict.add("b");
//    dict.add("a");
//    dict.add("bbb");
//    dict.add("bbbb");
    List<String> res = LC_Prob_Med2.wordBreakII(str, dict);
    System.out.println(" str : " + str + " Dict : " + dict);
    System.out.println(" Res : " + res);
  }

  public static void testLongestPalindromicSubsequence() {
    String str = "bbbab";
//    String str = "cbbd";
    int res = LC_Prob_Med2.longestPalidromicSubsequence(str);
    System.out.println("Res : " + res + " Str : " + str);
  }

  public static void testSN() {
//    char[][] matrix = null;
//    char[][] matrix = new char[][]{};
//    char[][] matrix = new char[][]{{}};
//    char[][] matrix = new char[][]{{'a','b'}};
//    char[][] matrix = new char[][]{{'a','b','c'}};
//    char[][] matrix = new char[][]{{'a','b','c','d'}};
//    char[][] matrix = new char[][]{
//        {'a','b','c','d'},
//        {'a','c','b','d'},
//        {'a','d','c','b'},
//        {'a','b','c','z'},
//    };

//    char[][] matrix = new char[][]{
//        {'a','b'},
//        {'e','f'}
//    };
//    char[][] matrix = new char[][]{
//        {'a','b','c'},
//        {'d','e','f'},
//        {'g','h','i'}
//    };
    char[][] matrix = new char[][]{
        {'a', 'b', 'c', 'd'},
        {'e', 'f', 'g', 'h'},
        {'i', 'j', 'k', 'l'},
        {'m', 'n', 'o', 'z'},
    };
    String res = LC_Prob_Med2.shortestPath(matrix, 'n', 'd');
    System.out.println(" Res : " + res);
  }

  public static void testLongestTwoCHarString() {
//    String str = "eeba";
    String str = "eebabbebe";
    int res = LC_Prob_Med2.lengthOfLongestSubstringTwoDistinct(str);
    System.out.println(" Res : " + res + " Str : " + str);
  }

  public static void testLongestKDistinctString() {
//    String str = "eeba";
//    String str = "kkzzeebabbebezzz";
//    String str = "eebababebbeb";
//    int k = 2;
//    String str = "a";
//    int k = 3;

    String str = "aaabb";
    int k = 2;
    int res = LC_Prob_Med2.lengthOfLongestSubstringKDistinct(str, k);
    System.out.println(" KKK Res : " + res + " Str : " + str);
  }

  public static void testLongestStringWithoutRepeatingChars() {
//    String str = "ee";
    String str = "eebae";
//    String str = "eedfaaec";
//    String str = "kkzzeebabbebezzz";
//    String str = "eebababebbeb";
//    String str = "a";
//    String str = "aaabb";
    int res = LC_Prob_Med2.longestSubStringWithoutRepeatingCharacters(str);
    System.out.println("Res : " + res + " Str : " + str);
  }

  public static void testLongestSubstringWithAtLeastKRepeatingCharacters() {
    String str = "aaabb";
    int k = 3;

//    String str = "ababbc";
//    int k = 2;
//
//    String str = "aaccbbeeddggffiihhkkjjmmllzxyvwturspqno";
//    int k = 2;
//
//    String str = "abcdedghijklmnopqrstuvwxyz";
//    int k = 2;

//    int res = LC_Prob_Med2.longestSubstringWithAtLeastKRepeatingCharacters(str, k);
//    System.out.println(" Res : " + res + " Str : " + str);
  }

  public static void testLRU() {
    LeastRecentlyUsed leastRecentlyUsed = new LeastRecentlyUsed(2);
    leastRecentlyUsed.put(1, 1);
    leastRecentlyUsed.put(2, 2);
    int res = leastRecentlyUsed.get(1);
    leastRecentlyUsed.put(3, 3);
    res = leastRecentlyUsed.get(2);
    leastRecentlyUsed.put(4, 4);
    res = leastRecentlyUsed.get(1);
    res = leastRecentlyUsed.get(3);
    res = leastRecentlyUsed.get(4);
  }

  public static void testLFU() {
    LeastFrequentlyUsed leastFrequentlyUsed = new LeastFrequentlyUsed(2);
    leastFrequentlyUsed.put(1, 1);
    leastFrequentlyUsed.put(2, 2);
    leastFrequentlyUsed.get(1);
    leastFrequentlyUsed.put(3, 3);
    leastFrequentlyUsed.get(2);
    leastFrequentlyUsed.get(3);
    leastFrequentlyUsed.put(4, 4);
    leastFrequentlyUsed.get(1);
    leastFrequentlyUsed.get(3);
    leastFrequentlyUsed.get(4);
  }

  private static void testIterativeLevelOrder() {
//    Tree tree = new Tree();
//    tree.root = new TNode(8);
//    tree.root.left = new TNode(5);
//    tree.root.right = new TNode(4);
//    tree.root.left.left = new TNode(9);
//    tree.root.left.right = new TNode(7);
//    tree.root.left.right.left = new TNode(1);
//    tree.root.left.right.right = new TNode(12);
//    tree.root.left.right.right.left = new TNode(2);
//    tree.root.right.right = new TNode(11);
//    tree.root.right.right.left = new TNode(3);

    Tree tree = new Tree();
    tree.insert(10);
    tree.insert(5);
    tree.insert(15);
    tree.insert(3);
    tree.insert(6);
    tree.insert(13);
    tree.insert(25);
    tree.insert(1);
    tree.insert(4);
    tree.insert(8);
    tree.insert(14);
    tree.insert(18);
    tree.iterativeLevelOrder(tree.root);
  }

  public static void testPostOrderIterative() {
    Tree tree = new Tree();
    tree.insert(10);
    tree.insert(5);
    tree.insert(15);
//    tree.insert(3);
//    tree.insert(6);
//    tree.insert(13);
//    tree.insert(25);
//    tree.insert(1);
//    tree.insert(4);
//    tree.insert(8);
//    tree.insert(14);
//    tree.insert(18);
    tree.postOrderTraversalIterative(tree.root);
  }

  public static void testBottomLeft() {
    Tree tree = new Tree();
    tree.root = new TNode(8);
    tree.root.left = new TNode(5);
    tree.root.right = new TNode(4);
    tree.root.left.left = new TNode(9);
    tree.root.left.right = new TNode(7);
    tree.root.left.right.left = new TNode(1);
    tree.root.left.right.right = new TNode(12);
    tree.root.left.right.right.left = new TNode(2);
    tree.root.right.right = new TNode(11);
    tree.root.right.right.left = new TNode(3);

//    Tree tree = new Tree();
//    tree.insert(10);
//    tree.insert(5);
//    tree.insert(15);
//    tree.insert(3);
//    tree.insert(6);
//    tree.insert(13);
//    tree.insert(25);
//    tree.insert(1);
//    tree.insert(4);
//    tree.insert(8);
//    tree.insert(14);
//    tree.insert(18);
    int res = tree.bottomLeftTreeValue(tree.root);
    System.out.println("Res : " + res);
  }

  public static void testCircumference() {
//    Tree tree = new Tree();
//    tree.root = new TNode(8);
//    tree.root.left = new TNode(5);
//    tree.root.right = new TNode(4);
//    tree.root.left.left = new TNode(9);
//    tree.root.left.right = new TNode(7);
//    tree.root.left.right.left = new TNode(1);
//    tree.root.left.right.right = new TNode(12);
//    tree.root.left.right.right.left = new TNode(2);
//    tree.root.right.right = new TNode(11);
//    tree.root.right.right.left = new TNode(3);

    Tree tree = new Tree();
    tree.insert(10);
    tree.insert(5);
    tree.insert(15);
    tree.insert(3);
    tree.insert(6);
    tree.insert(13);
    tree.insert(25);
    tree.insert(1);
    tree.insert(4);
    tree.insert(8);
    tree.insert(14);
    tree.insert(18);
    String res = tree.antiClockWiseCircumference(tree.root);
    System.out.println("Res : " + res);
  }

  public static void testMaxPathSum() {
//    Tree tree = new Tree();
//    tree.root = new TNode(-2);
//    tree.root.left = new TNode(-5);
//    tree.root.right = new TNode(9);
//    tree.root.left.left = new TNode(-1);
//    tree.root.left.right = new TNode(2);
//    tree.root.right.left = new TNode(3);
//    tree.root.right.right = new TNode(-2);
//    tree.root.left.right.left = new TNode(1);
//    tree.root.left.right.right = new TNode(12);
//    tree.root.left.right.right.left = new TNode(2);
//    tree.root.right.right = new TNode(11);
//    tree.root.right.right.left = new TNode(3);

    Tree tree = new Tree(1);
    tree.root = new TNode(-2);
    tree.root.left = new TNode(3);
    tree.root.right = new TNode(9);
//    tree.root.left.left = new TNode(-1);
//    tree.root.left.right = new TNode(2);
//    tree.root.right.left = new TNode(3);
//    tree.root.right.right = new TNode(-2);

    int res = tree.maxPathSum(tree.root);
    System.out.println("Res : " + res);
  }

  public static void testInorderIterative() {
    Tree tree = new Tree(10);
    tree.insert(5);
    tree.insert(15);
    tree.insert(3);
    tree.insert(6);
    tree.insert(13);
    tree.insert(25);
    tree.insert(1);
    tree.insert(4);
    tree.insert(8);
    tree.insert(14);
    tree.insert(18);

    List<Integer> list = tree.inorderTraversalIterative(tree.root);
    System.out.println(list);
  }

  public static void testzigZag() {
    Tree tree = new Tree();
    tree.insert(10);
    tree.insert(5);
    tree.insert(15);
    tree.insert(3);
    tree.insert(6);
    tree.insert(13);
    tree.insert(25);
    tree.insert(1);
    tree.insert(4);
    tree.insert(8);
    tree.insert(14);
    tree.insert(18);
    List<List<Integer>> list = tree.zigZagLevelOrder(tree.root);
    System.out.println(" list : " + list);
  }

  public static void testSortLinkedList() {
    LLNode n3 = new LLNode(1);
    LLNode n1 = new LLNode(2);
    LLNode n5 = new LLNode(3);
    LLNode n0 = new LLNode(4);
    LLNode n4 = new LLNode(5);
    LLNode n2 = new LLNode(6);
    n0.next = n1;
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    LinkedList L1 = new LinkedList();
    L1.head = n0;
    System.out.println(" B4 : " + L1.toString());
    LLNode newHead = L1.sortLinkedList();
    LinkedList L2 = new LinkedList();
    L2.head = newHead;
    System.out.println(" after : " + L2.toString());
  }
}