package com.darkRealm.Sorting_and_Searching;

import java.util.Arrays;

/**
 * Created by Jayam on 1/11/2017.
 */
public class Searching_Sorting {

  /*  [Prob 10.1]
  *   Q) Sorted Merge : we are given two sorted arrays A & B, where A has a large enough buffer at the end to hold B.
  *     Write a method to merge B into A sorted Order.
  *   A) Will compare both the arrays from behind rather than front, with taking pointers Ra, Rb for reading from a & b.
  *       And take another pointer Wa for writing the elements in A from behind.
  * */
  public static int[] sortedMerge(int[] arr, int[] brr) {
    // arr is longer & has buffer to accomodate brr in it.
    int wA = arr.length - 1;
    int rA, rB;
    rA = arr.length - brr.length - 1; // as should has space at behind, thus we are reading the first element from end
    rB = brr.length - 1;
    while (rB >= 0) {
      if (rA >= 0 && arr[rA] > brr[rB]) {
        arr[wA] = arr[rA];
        rA--;
      } else {
        arr[wA] = brr[rB];
        rB--;
      }
      wA--;
    }
    return arr;
  }

  /* [Prob 10.3]
   Q) Search in a rotated array - Given a sorted array of n integers that has been rotated an unknown munber of times
    write a code to find the element in the array. Array was originally sorted in increasing order
    A) Woudl utilize binary search first to find the index from awhich the array is rotaterd & then fire binary search from there
 */
  public static int searchRotatedArray(int[] arr, int k) {
    int rotated = findRotatedIndex(arr, 0, arr.length);
    System.out.println("Rotated at : " + rotated);
    System.out.println(" " + Arrays.toString(arr));

    int res = BinarySearchUtil.binarySearchRecursive(arr, k, 0, rotated - 1);
    if (res == Integer.MIN_VALUE) {
      res = BinarySearchUtil.binarySearchRecursive(arr, k, rotated, arr.length);
    }
    System.out.println("res  : " + arr[res]);
    System.out.println("index: " + res);
    System.out.println(" " + Arrays.toString(arr));
    return res;
  }

  private static int findRotatedIndex(int[] arr, int low, int high) {
    int rotated = 0;
    if (low <= high) {
      int mid = (low + high) / 2;
      if (low == high) {
        return 0;
      }
      if (mid != 0 && arr[mid] < arr[mid - 1]) {
        return mid;
      }

      rotated = findRotatedIndex(arr, low, mid - 1);
      if (rotated != 0) {
        return rotated;
      }
      rotated = findRotatedIndex(arr, mid + 1, high);
    }
    return rotated;
  }
}