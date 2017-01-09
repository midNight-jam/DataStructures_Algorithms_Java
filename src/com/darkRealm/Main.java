package com.darkRealm;

import com.darkRealm.BigO.ArrayUtil;
import com.darkRealm.BigO.BitsUtil;
import com.darkRealm.BigO.MathUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
* Uncomment a function to run, each is a method for solved problem.
* Testing ignored files settings*/
public class Main {

  public static void main(String[] args) {
//    try {
//      DarkLogger.setup();
//    } catch (IOException e) {
////      e.printStackTrace();
//      System.out.println("Some thing went wrong while settting up logs");
//    }


    // write your code here, testing after new git
//    doArray_and_Strings_Main();
//    doStack_and_Queue();
//    doRecursion_DP();

//    doTrees_Graph();
//    doLinkedLsit();
//    doMathUtils();

//    String res  = getTime(9,9,9,9);
//    String res = getTime(0, 0, 0, 9);
//    System.out.println("Res - " + res);


//    minLenUnSorted(new int[]{0, 1, 15, 25, 6, 7, 30, 40, 50});
//    minLenUnSorted(new int[]{10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60});
    doBitsMain();
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
  }

  private static void doStack_and_Queue() {
//    Stack_and_Queues_Main.testMyStack();
//    Stack_and_Queues_Main.testMinStack();
//    Stack_and_Queues_Main.testSortStack();
//    Stack_and_Queues_Main.testSetStacks();
//    Stack_and_Queues_Main.testThreeStacks();
//    Stack_and_Queues_Main.testRoundArray();
//    Stack_and_Queues_Main.testThreeStacks();
    Stack_and_Queues_Main.testAnimalShelter();
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
//    Recursion_DP_Main.testMultiply();
//    System.out.println(Math.log(256)/Math.log(2));
//    Recursion_DP_Main.testTowerOfHanoi();
//    Recursion_DP_Main.testBalancedParanthesis();
//    Recursion_DP_Main.testPaintFill();
//    Recursion_DP_Main.testWaysToReachN();
    Recursion_DP_Main.testNQueenPlacingProblem();
//    Recursion_DP_Main.testPermuteExpression();
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
    Trees_and_Graphs_Main.testInorderTraversalIterative();
  }

  private static void doMathUtils() {
    int gcd = MathUtil.geatestCommonDivisor(48, 180);
    System.out.println(" gcd - " + gcd);
  }

  public static String getTime(int a, int b, int c, int d) {

    ArrayList<Integer> nos = new ArrayList<>();
    nos.add(a);
    nos.add(b);
    nos.add(c);
    nos.add(d);
    nos.sort(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1 - o2;
      }
    });
    // get the max between 0-2
    Integer h1 = -1;
    for (int i = 0; i < nos.size(); i++) {
      int temp = nos.get(i);
      if (temp > h1 && temp < 3) {
        h1 = temp;
      }
    }

    if (h1 == -1) {
      return "Error";
    }
    nos.remove(h1);
    // any between 0-9
    Integer h2 = -1;
    for (int i = 0; i < nos.size(); i++) {
      int temp = nos.get(i);
      if (h1 == 2 && temp < 4 && temp > h2) {
        h2 = temp;
      } else if (h1 == 0 || h1 == 1 && (temp > h2)) {
        h2 = temp;
      }
    }
    if (h2 == -1) {
      return "Error";
    }
    nos.remove(h2);

    // any between 0-5
    Integer m1 = -1;
    for (int i = 0; i < nos.size(); i++) {
      int temp = nos.get(i);
      if (temp > m1 && temp < 6) {
        m1 = temp;
      }
    }

    if (m1 == -1) {
      return "Error";
    }
    nos.remove(m1);

    String time = "";
    time += h1;
    time += h2;
    time += ":";
    time += m1;
    time += nos.get(0);

    System.out.println("somes " + time);

    // get a no between 0-1-2 & get max, if not return Error
    // get the next number should be max from 0-9
    // get the third no between 0-5 max
    // add the last remaingin no
    return time;
  }

  public static void minLenUnSorted(int[] arr) {
    int start, end;
    start = end = -1;

    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] > arr[i + 1]) {
        start = i + 1;
        break;
      }
    }

    for (int i = arr.length - 1; i > 0; i--) {
      if (arr[i] < arr[i - 1]) {
        end = i - 1;
        break;
      }
    }

    if (start > end) {
      int t = start;
      start = end;
      end = t;
    }
    int maxR = Integer.MIN_VALUE;
    int minR = Integer.MAX_VALUE;
    // get the max from the range
    for (int k = start; k <= end; k++) {
      if (arr[k] > maxR) {
        maxR = arr[k];
      }
      if (arr[k] < minR) {
        minR = arr[k];
      }
    }

    int RStart = -1;
    // 1st index fro minR
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] <= minR && minR <= arr[i + 1]) {
        RStart = i + 1;
        break;
      }
    }

    // 1st index for maxR
    int REnd = -1;
    for (int i = arr.length - 1; i > 1; i--) {
      if (arr[i] >= maxR && maxR >= arr[i - 1]) {
        REnd = i - 1;
        break;
      }
    }
    System.out.println("is it working Rs - " + RStart + "  Re- " + REnd);
  }

  private static void doLinkedLsit() {
    LinkedList_Main.testLinkedListOperations();
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
    int winCOunt = BitsUtil.FlipBitToWin(1775);
//    int winCOunt = BitsUtil.FlipBitToWin(1743);
    System.out.println("bitToWin: " + winCOunt);
  }
}