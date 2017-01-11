package com.darkRealm.Sorting_and_Searching;

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
}