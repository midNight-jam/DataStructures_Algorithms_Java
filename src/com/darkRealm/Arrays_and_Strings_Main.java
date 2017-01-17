package com.darkRealm;
import com.darkRealm.Arrays_and_Strings.*;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Jayam on 10/2/2016.
 */
public class Arrays_and_Strings_Main {
  public static void doIsUnique() {
    System.out.println(Arrays_and_Strings.IsUnique("sabcds"));
  }

  public static void doCheckPerm() {
    System.out.println(Arrays_and_Strings.CheckPermutation("sabcds", "ssbcda"));
    System.out.println(Arrays_and_Strings.CheckPermutation("sabcds", "sbcda"));
    System.out.println(Arrays_and_Strings.CheckPermutation("sabcds", "ssbcdas"));
    System.out.println(Arrays_and_Strings.CheckPermutation("sabcds", "sbcd"));
  }

  public static void doCheckPermPalindrome() {
    System.out.println(Arrays_and_Strings.palindromePermutation("abaab"));
  }

  public static void doCompresssion() {
    Arrays_and_Strings.stringCompression("abcdeeeeeeeee");
  }

  /* Q) To get the max of all the mins from the sliding window of size K
  *  Input (3, new int[]{6,5,4,3,2,1})
  *  min for 1st window would be 4 min - [6,5,4]
  *  min for 2nd window would be 3 min - [5,4,3]
  *  min for 3rd window would be 2 min - [4,3,2]
  *  min for 2nd window would be 1 min - [3,2,1]
  *  Now the output should be 4 as it is the max maong all mins
  *  */
  public static class MComparator implements Comparator<Integer> {
    public int compare(Integer x, Integer y) {
      return y - x;
    }
  }

  public static int getMaxOfMinsFromSlidingWindow(int k, int[] arr) {
    int size = arr.length;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(arr.length);
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(arr.length, new MComparator());

    for (int i = 0; i < k - 1; i++) {
      minHeap.add(arr[i]);
    }

    for (int i = k - 1; i < size; i++) {
      minHeap.add(arr[i]);
      int windowMin = minHeap.remove();
      maxHeap.add(windowMin);
      minHeap.add(windowMin);
      int index = i - k + 1;
      minHeap.remove(arr[index]);
    }
    int res = maxHeap.remove();
    return res;
  }

  public static void testGetSubArrayCombinations() {
//    Integer [] arr = new Integer[]{1,2,3};
    Integer[] arr = new Integer[]{1, 2, 3, 4};
    Arrays_and_Strings.getSubArrayCombinations(arr, 4);
  }

  public static void testPossibleSubArraysWithSumFaster() {
    int[] arr = new int[]{10, 5, 1, 2, -1, -1, 7, 1, 2};
    int targetSum = 8;
    int res = Arrays_and_Strings.possibleSubArraysWithSumFaster(arr, targetSum);
    System.out.println("Res - " + res);
  }

  public static void testSumPair() {
    int[] arr = new int[]{1, 2, 3, 4, 3, 5};
    Arrays_and_Strings.pairEqualToSum(arr, 6);
  }

  public static void testElemntsSum() {
    int[] arr = new int[]{1, 2, 3, 4, 5};
    Arrays_and_Strings.threeElementsSum(arr, 10);
  }
}