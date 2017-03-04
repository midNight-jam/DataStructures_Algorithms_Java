package darkRealm;

import darkRealm.CTCI.Arrays_and_Strings.Arrays_and_Strings;
import darkRealm.CTCI.BigO.BitsUtil;
import darkRealm.CTCI.BigO.MathUtil;
import darkRealm.CTCI.BigO.MatrixUtil;
import darkRealm.CTCI.*;
import darkRealm.CTCI.Maths_and_Logic_Puzzels.Maths_Logic_Puzzels;
import darkRealm.LeetCode.LeetCodeMain;

/*
* Uncomment a function to run, each is a method for solved problem.
* */
public class Main {

  public static void main(String[] args) {
//    try {
//      DarkLogger.setup();
//    } catch (IOException e) {
////      e.printStackTrace();
//      System.out.println("Some thing went wrong while settting up logs");
//    }
//    doArray_and_Strings_Main();
//    doStack_and_Queue();
//    doRecursion_DP();
//    doSortingAndSearching();
//    doprint();
//    doTrees_Graph();
    doLinkedLsit();
//    doMathUtils();
//    doBitsMain();
//    doMathsLogicPuzzels();
//    doModerate();
//    doLeetCode();
//    doMatrix();
  }

  private static void doArray_and_Strings_Main() {
//        Arrays_and_Strings_Main.doIsUnique();
//        Arrays_and_Strings_Main.doCheckPerm();
//        Arrays_and_Strings_Main.doCheckPermPalindrome();
//    Arrays_and_Strings_Main.doCompresssion();
//    Arrays_and_Strings_Main.getMaxOfMinsFromSlidingWindow(3, new int[]{2, 5, 4, 6, 8});
//    Arrays_and_Strings_Main.getMaxOfMinsFromSlidingWindow(2, new int[]{1, 1, 1});
//    int res = Arrays_and_Strings_Main.getMaxOfMinsFromSlidingWindow(1, new int[]{1, 2, 3, 1, 2});
//    System.out.println("Res - " + res);
//    Arrays_and_Strings_Main.testGetSubArrayCombinations();
//    Arrays_and_Strings_Main.testPossibleSubArraysWithSumFaster();
//    int [] arr = ArrayUtil.getSmallBigArray(new int[]{5,6,3,10,9});
//    int [] arr = ArrayUtil.getSmallBigArray(new int[]{1,2,3,4,5});
//    int [] arr = ArrayUtil.getSmallBigArray(new int[]{9,8,7,6,5});
//    int [] arr = ArrayUtil.getSmallBigArray(new int[]{5,6,7,4,3,2,1});
//    int [] arr = ArrayUtil.getSmallBigArray(new int[]{7,2,9,10,12,3});
//    int [] arr = ArrayUtil.getSmallBigArray(new int[]{2,8,6,5,3,1}); //2 8 4 6 5 7 1
//    int res = Arrays_and_Strings.shortestPathBetweenWords("","",new HashMap<>());
//    System.out.println("res path - "+res);
////
//    Scanner sc = new Scanner(System.in);
//    String start, end;
//    start = sc.nextLine();
//    end = sc.nextLine();
//    int no;
//    no = Integer.parseInt(sc.nextLine());
////    HashMap<String, Boolean> dictionary = new HashMap<>();
////    TreeMap<String, Boolean> dictionary = new TreeMap<>();
//    for (int i = 0; i < no; i++) {
//      dictionary.add(sc.nextLine());
//    }

//    String res = Arrays_and_Strings.shortestPathBetweenWords("TOON", "PLEA");
//    int resc = Arrays_and_Strings.shortestPathBetweenWords(start, end, dictionary);
//    ArrayList<String> dictionary = new ArrayList<>();
//    String start, end;
//    dictionary.add("AAAAAAAA");
//    dictionary.add("AAAAAAAT");
//    dictionary.add("AAAAAATT");
//    dictionary.add("AAAAATTT");
//    start = "AAAAAAAA";
//    end = "AAAAAATT";
//
//    String [] arr = new String[dictionary.size()];
//    dictionary.toArray(arr);
//    int resc = Arrays_and_Strings.minMutation(start, end, arr);
//
//    System.out.println("Result - " + resc);


//    Arrays_and_Strings_Main.testSumPair();
//    Arrays_and_Strings_Main.testElemntsSum();
//    int res = Arrays_and_Strings.maxLengthOfSubArrayForGivenSum(new int[]{1, 2, 3}, 4);
//    System.out.println(" res " + res);

//    Arrays_and_Strings_Main.testHotelBook();
//    Arrays_and_Strings_Main.testStringRotation();
//    Arrays_and_Strings_Main.testRotateMatrix();
//    Arrays_and_Strings_Main.testStringCompression();
//    Arrays_and_Strings_Main.testOneEditAway();

//    String str = "abc"; // 00L
//    String res = Arrays_and_Strings.operation(str,0,0,'L');
//    String str = "abc"; // 22L
//    String res = Arrays_and_Strings.operation(str,2,2,'L');
    String str = "abc"; // 02R
    String res = Arrays_and_Strings.operation(str, new String[]{"0 0 L", "2 2 L", "0 2 R"});
    System.out.println(res);
  }

  private static void doStack_and_Queue() {
//    Stack_and_Queues_Main.testMyStack();
//    Stack_and_Queues_Main.testMinStack();
//    Stack_and_Queues_Main.testSortStack();
//    Stack_and_Queues_Main.testSetStacks();
//    Stack_and_Queues_Main.testThreeStacks();
//    Stack_and_Queues_Main.testRoundArray();
//    Stack_and_Queues_Main.testThreeStacks();
//    Stack_and_Queues_Main.testAnimalShelter();
  }

  private static void doRecursion_DP() {
//    Recursion_DP_Main.testNthFibonacciMemoized();
//    Recursion_DP_Main.testNthFiboIterative();
//    Recursion_DP_Main.testTripleSteps();
//    Recursion_DP_Main.testRobotGrid();
//    Recursion_DP_Main.testPowerSet();
//    Recursion_DP_Main.testAllPermutationsWithDups();
//    Recursion_DP_Main.testParensCombination();
//    Recursion_DP_Main.testMagicIndex();
    Recursion_DP_Main.testMultiply();
//    System.out.println(Math.log(256)/Math.log(2));
//    Recursion_DP_Main.testTowerOfHanoi();
//    Recursion_DP_Main.testBalancedParanthesis();
//    Recursion_DP_Main.testPaintFill();
//    Recursion_DP_Main.testWaysToReachN();
//    Recursion_DP_Main.testNQueenPlacingProblem();
//    Recursion_DP_Main.testPermuteExpression();
//    Recursion_DP_Main.testBooleanEvaluation();
//    Recursion_DP_Main.testLongestSubSequence();
//    Recursion_DP_Main.testRobotWays();
//    Recursion_DP_Main.testLongestIncreasingSubSequence();
  }

  private static void doTrees_Graph() {
//    Trees_and_Graphs_Main.testBFSAndDFS();
//    Trees_and_Graphs_Main.testIsRoutePresentBetweenNodes();
//    Trees_and_Graphs_Main.testMinimalHeightTree();
//    Trees_and_Graphs_Main.testListOfDepths();
//    Trees_and_Graphs_Main.testIsBalanced();
//    Trees_and_Graphs_Main.testIsBST();
//    Trees_and_Graphs_Main.testPredecessorAndSuccessor();
//    Trees_and_Graphs_Main.testCommonAncestor();
//    Trees_and_Graphs_Main.testCheckSubtree();
//    Trees_and_Graphs_Main.testPathsWithSums();
//    Trees_and_Graphs_Main.testInsertNode();
//    Trees_and_Graphs_Main.testBuildOrder();
//    Trees_and_Graphs_Main.testNumberOfBSTSequences();
//    Trees_and_Graphs_Main.testPossibleBSTArrays();
//    Trees_and_Graphs_Main.testPathsWithSum();
//    Trees_and_Graphs_Main.testInorderTraversalIterative();
//    Trees_and_Graphs_Main.testAdjacencyGraph();
//    Trees_and_Graphs_Main.testMinPathSum();
//    Trees_and_Graphs_Main.testRightSideView();
//    Trees_and_Graphs_Main.testPathsOfTree();
//    Trees_and_Graphs_Main.testMinHeight();
//    Trees_and_Graphs_Main.testSerialize();
//    Trees_and_Graphs_Main.testSubtreeSum();
//    Trees_and_Graphs_Main.testKthSmallest();
//    Trees_and_Graphs.doDijkstras();
//    Trees_and_Graphs_Main.testUniqueBSTCount();
//    Trees_and_Graphs_Main.testAllPossibleBST();
//    Trees_and_Graphs_Main.testTopologicalSort();
//    Trees_and_Graphs_Main.testPreorderTraversalIterative();
//    Trees_and_Graphs_Main.testPostorderTraversalIterative();
//    Trees_and_Graphs_Main.testFlatTree();
    Trees_and_Graphs_Main.testPathsIterative();
  }

  private static void doMathUtils() {
//    int gcd = MathUtil.geatestCommonDivisor(48, 180);
//    System.out.println(" gcd - " + gcd);
//
//    int n = 0;
//    int n = 1;
//    int n = 2;
//    int n = 3;
//    int n = 4;
//    int n = 5;
//    int n = 6;
//    int n = 7;
    int n = 8;
    int res = MathUtil.countPrimes(n);
//    int res = MathUtil.nthPrimeNumber(5);
    System.out.println(" count :  " + res + " N : " + n);
  }

  private static void doLinkedLsit() {
//    LinkedList_Main.testLinkedListOperations();
//    LinkedList_Main.testDeepCopyRandomList();
//    LinkedList_Main.testReverseBetween();
//    LinkedList_Main.testPalindrome();
//    LinkedList_Main.testIntersection();
//    LinkedList_Main.testSumListNatural();
//    LinkedList_Main.testSumListII();
//    LinkedList_Main.testReverseMid();
//    LinkedList_Main.testSumList();
//    LinkedList_Main.testPartition();
//		LinkedList_Main.testMergeTwoList();
//		LinkedList_Main.testMergeKLists();
//    LinkedList_Main.testReverse();
    LinkedList_Main.testMergerLinkedList();
  }

  private static void doBitsMain() {
//    BitsUtil.insertionBits(1024,19,2,6);
//    BitsUtil.insertionBits(1701,101,2,8);
//    String res = BitsUtil.FractionToBinaryString(0.125);
//    String res = BitsUtil.FractionToBinaryString(0.375);
//    String res = BitsUtil.FractionToBinaryString(0.875);
//    String res = BitsUtil.FractionToBinaryString(0.5625);
//    String res = BitsUtil.FractionToBinaryString(0.6);
//    System.out.println("Binary of fraction : " + res);

//    BitsUtil.updateIthBit(7,0,0);
//    int res = BitsUtil.oneShort(8);
//    int res = BitsUtil.oneShort(15);
//    int res = BitsUtil.oneBig(15);
//    System.out.println("One Short : " + res);
//    int winCOunt = BitsUtil.FlipBitToWin(1775);
//    int winCOunt = BitsUtil.FlipBitToWin(1743);
//    System.out.println("bitToWin: " + winCOunt);
//    int diff = BitsUtil.coversionEstimate(29,15);
//    int diff = BitsUtil.coversionEstimate(7, 8);
//    System.out.println("diff bits : " + diff);

//    int nextBigger = BitsUtil.nextBiggerWithSame_1_Bits(13948);
//    int nextBigger = BitsUtil.nextBiggerWithSame_1_Bits(8);
//    System.out.println("next bigger : " + nextBigger);

//    int nextSmaller = BitsUtil.nextSmallerWithSame_1_Bits(10115);
//    int nextSmaller = BitsUtil.nextSmallerWithSame_1_Bits(6);
//    System.out.println("next bigger : " + nextSmaller);

//    BitsUtil.swapPairOfBits(218);
//    byte[] screen = new byte[4];
//    BitsUtil.drawLine(screen, 8, 6, 18, 18);
//
    BitsUtil.flipALL(16);
  }

  private static void doMathsLogicPuzzels() {
    Maths_Logic_Puzzels.EggDropProblem();
  }

  private static void doSortingAndSearching() {
//    Sorting_and_Searching_Main.testMergeSort();
//    Sorting_and_Searching_Main.testBinarySearch();
//    Sorting_and_Searching_Main.testSortedMerge();
//    Sorting_and_Searching_Main.testKthSmallestElement();
//    Sorting_and_Searching_Main.testKthLargestElement();
//    Sorting_and_Searching_Main.testFindMinInRotatedArray();
    Sorting_and_Searching_Main.testFindMinInRotatedArrayII();
//    Sorting_and_Searching_Main.testSearchRotatedArray();
//    Searching_Sorting.testSortedSearchNoSize();
//    Sorting_and_Searching_Main.testPeaksValleys();
//    Sorting_and_Searching_Main.testRankStream();
//    Sorting_and_Searching_Main.testSortedMatrixSearch();
//    Sorting_and_Searching_Main.testSparseSearch();
//    Sorting_and_Searching_Main.testGroupAnagrams();
//    Sorting_and_Searching_Main.testFindDuplicates();
//    Sorting_and_Searching_Main.testInsertionSort();
//    Sorting_and_Searching_Main.testQuickSort();
//    Sorting_and_Searching_Main.testCountSort();
//    Sorting_and_Searching_Main.testRadix();
//    Sorting_and_Searching_Main.testQuickSort();
  }

  private static void doModerate() {
//    Moderate_Main.testNumberSwapper();
//    Moderate_Main.testWordFrequency();
//    Moderate_Main.testTicTacWin();
//    Moderate_Main.testFactorialZeroes();
//    Moderate_Main.testSmallestDifference();
//    Moderate_Main.testNumberMax();
//    Moderate_Main.testEnglishInt();
//    Moderate_Main.testSubstract();
//    Moderate_Main.testMulitply();
//    Moderate_Main.testDivide();
//    Moderate_Main.testPondSizes();
//    Moderate_Main.testLSCS();
//    Moderate_Main.testPatternMatching();
//    Moderate_Main.testOldKeyboard();
//    Moderate_Main.testMaxPopulationYear();
//    Moderate_Main.testSumSwap();
//    Moderate_Main.testMasterMind();
  }

  public static void doLeetCode() {
    LeetCodeMain.run();
  }

  public static void doprint() {
//    PrintProbs.trangle1();
//    PrintProbs.trangle2();
//    PrintProbs.trangle3();
    PrintProbs.triangle4();
  }

  public static void doMatrix() {
//    int[][] matrix = new int[][]{
//        {1, 4, 7, 11, 15},
//        {2, 5, 8, 12, 19},
//        {3, 6, 9, 16, 22},
//        {10, 13, 14, 17, 24},
//        {18, 21, 23, 26, 30}
//    };
////
    int[][] matrix = new int[][]{
        {1, 5, 9},
        {10, 11, 13},
        {12, 14, 15}
    };
////
////    int[][] matrix = new int[][]{
////        {5}
////    };
//
////    int[][] matrix = new int[][]{
////        {0,1},
////        {2,3}
////    };
////    int[][] matrix = new int[][]{
////        {1, 2},
////        {1, 3}
////    };
////    int res = MatrixUtil.searchRowSortedMatrix(matrix, 12);
////    int res = MatrixUtil.searchSortedMatrix(matrix, 12);
////    int[][] matrix = new int[][]{
////        {1, 1},
////        {1, 3}
////    };
//    int res = MatrixUtil.kthSmallestSortedMatrix(matrix, 6);
//    System.out.println(" " + MatrixUtil.getPrintableMatrix(matrix));
//    System.out.println(" Res : " + res);

//    int[][] matrix = new int[][]{
//        {0}, {1}
//    };
//    MatrixUtil.matrixZeroes(matrix);
    int[][] nmat = MatrixUtil.rotateMNMatrixClockWise(matrix);
    System.out.println(MatrixUtil.getPrintableMatrix(nmat));
    nmat = MatrixUtil.rotateMNMatrixAntiClockWise(matrix);
    System.out.println(MatrixUtil.getPrintableMatrix(nmat));
  }
}