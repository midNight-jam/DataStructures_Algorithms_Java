package com.darkRealm;

import com.darkRealm.Trees_and_Graphs.Trees_and_Graphs;

import java.io.IOException;

/*
* Uncomment a function to run, each is a method for solved problem.
* Testing ignored files settings*/
public class Main {

  public static void main(String[] args) {
    try {
      DarkLogger.setup();
    } catch (IOException e) {
//      e.printStackTrace();
      System.out.println("Some thing went wrong while settting up logs");
    }
    // write your code here, testing after new git
//    doArray_and_Strings_Main();
//    doStack_and_Queue();
//    doRecursion_DP();
    doTrees_Graph();
  }

  private static void doArray_and_Strings_Main() {
//        Arrays_and_Strings_Main.doIsUnique();
//        Arrays_and_Strings_Main.doCheckPerm();
//        Arrays_and_Strings_Main.doCheckPermPalindrome();
//    Arrays_and_Strings_Main.doCompresssion();
//    Arrays_and_Strings_Main.getMaxOfMinsFromSlidingWindow(3, new int[]{2, 5, 4, 6, 8});
//    Arrays_and_Strings_Main.getMaxOfMinsFromSlidingWindow(2, new int[]{1, 1, 1});
    int res = Arrays_and_Strings_Main.getMaxOfMinsFromSlidingWindow(1, new int[]{1, 2, 3, 1, 2});
    System.out.println("Res - " + res);
  }

  private static void doStack_and_Queue() {
//    Stack_and_Queues_Main.testMyStack();
//    Stack_and_Queues_Main.testMinStack();
//    Stack_and_Queues_Main.testSortStack();
//    Stack_and_Queues_Main.testSetStacks();
    Stack_and_Queues_Main.testThreeStacks();
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

  private static void doTrees_Graph(){
//    Trees_and_Graphs_Main.testBFSAndDFS();
//    Trees_and_Graphs_Main.testIsRoutePresentBetweenNodes();
//    Trees_and_Graphs_Main.testMinimalHeightTree();
//    Trees_and_Graphs_Main.testListOfDepths();
//    Trees_and_Graphs_Main.testIsBalanced();
//    Trees_and_Graphs_Main.testIsBST();
      Trees_and_Graphs_Main.testPredecessorAndSuccessor();
  }
}