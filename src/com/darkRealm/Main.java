package com.darkRealm;

import com.darkRealm.BigO.BitsUtil;
import com.darkRealm.Recursion_and_DynamicProg.Recursion_and_DP;

import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
* Uncomment a function to run, each is a method for solved problem.
* Testing ignored files settings*/
public class Main {

  public static void main(String[] args) {
    try {
      DarkLogger.setup();
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Some thing went wrong while settting up logs");
    }
    // write your code here, testing after new git
//    doArray_and_Strings_Main();
//    doStack_and_Queue();
    doRecursion_DP();
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
    Stack_and_Queues_Main.testSortStack();
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
    Recursion_DP_Main.testPaintFill();
  }
}