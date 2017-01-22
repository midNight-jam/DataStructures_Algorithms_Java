package com.darkRealm.Sorting_and_Searching;

import java.util.ArrayList;
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


  //not very effective still goes to O(N)
  public static int searchRotatedArrayOLD(int[] arr, int k) {
    int rotated = findRotatedIndexOLD(arr, 0, arr.length);
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

  private static int findRotatedIndexOLD(int[] arr, int low, int high) {
    int rotated = 0;
    if (low <= high) {
      int mid = (low + high) / 2;
      if (low == high) {
        return 0;
      }
      if (mid != 0 && arr[mid] < arr[mid - 1]) {
        return mid;
      }

      rotated = findRotatedIndexOLD(arr, low, mid - 1);
      if (rotated != 0) {
        return rotated;
      }
      rotated = findRotatedIndexOLD(arr, mid + 1, high);
    }
    return rotated;
  }


  public static int searchRotatedArray(int[] arr, int k) {
    return findRotatedIndex(arr, 0, arr.length - 1, k);
  }

  /* [Prob 10.3]
  Q) Search in a rotated array - Given a sorted array of n integers that has been rotated an unknown munber of times
   write a code to find the element in the array. Array was originally sorted in increasing order
   A) Woudl utilize binary search. First will calculate the mid & check if the mid is bigger tahn low, if yes that means
   left half is sorted. Now does the element exists in this sorted half, check it by comparing to low & mid does it falls
   in the range. Similarly check if the right half is sroted & check in that range. IF
*/
  public static int findRotatedIndex(int[] arr, int low, int high, int k) {
    int mid = (low + high) / 2;

    if (arr[mid] == k) {
      return mid;
    }

    if (high < low) {
      return -1;
    }
    if (arr[low] < arr[mid]) {  // left half is sorted
      if (arr[low] < k && k < arr[mid]) { // and element is within the range
        return findRotatedIndex(arr, low, mid - 1, k);
      }

    }

    if (arr[mid] < arr[high]) { // right half is sorted
      if (arr[mid] < k && k < arr[high]) {  // and element is within the range
        return findRotatedIndex(arr, mid + 1, high, k);
      }
    }
    int res = findRotatedIndex(arr, low, mid - 1, k);
    if (res == -1) {
      res = findRotatedIndex(arr, mid + 1, high, k);
    }
    return res;
  }

  /*[Prob 10.2] TODO
   Q) Group Anagrmas : a method to sort an array of strings so that all the anagrams are next to each other
   A)
  * */

  /* [Prob 10.4]
  *   Q) Sorted Search,No Size : given a DS Listy that lacks the size Method , but has a elementAt(i) meth which return -1
  *   if index is out of range. Now, given a Listy which contains sorted +ve integers find the index at which a given x occurs
  *   A) will take a trav index i & will ask to get the elementAt(i), if the returned element is smaller than than the x vlaue
  *   then we will binary serach in the found range else will 2le i and fetch again at i. If -ve means we have corseed bounds
  *   then we fire again binary serach in this range to get the element. This technique is called as Exponential Backoff
  * */

  public static int sortedSearchNoSize(Listy listy, int k) {
    int i = 1;
    int low, high, mid, end;
    low = 0;
    high = 1;
    int element = 0;
    while (listy.elementAt(high) > 0) {
      mid = (low + high) / 2;
      if (listy.elementAt(mid) == k) {  // if we have found the element itself
        return mid;
      }

      if (k < listy.elementAt(high)) {  // if we have found the upperbound on the range
        break;
      }
      low = high;
      high = 2 * high; // move ahead by 2le size
    }

    if (k < listy.elementAt(high)) {
      // binary search for element in low-high range
      return BinarySearchUtil.binarySearchRecursive(listy.arr, k, low, high);
    }
    int beg = low;
    if (listy.elementAt(high) < 0) {
      // we have to serach for the end
      while (true) {
        mid = (low + high) / 2;
        if (listy.elementAt(mid) > 0) {
          low = mid;
        }
        if (listy.elementAt(mid) < 0) {
          high = mid;
        }
        if (listy.elementAt(mid + 1) < 0) {
          end = mid;
          break;
        }
      }
      return BinarySearchUtil.binarySearchRecursive(listy.arr, k, beg, end);
    }
    return -1;
  }

  static class Listy {
    int[] arr;
    int size;

    public Listy(int s) {
      arr = new int[s];
      size = s;
    }

    public int elementAt(int i) {
      if (i < size) {
        return arr[i];
      }
      return -1;
    }
  }

  public static void testSortedSearchNoSize() {
    Listy listy = new Listy(6);
    listy.arr = new int[]{11, 22, 33, 44, 55, 66};
    sortedSearchNoSize(listy, 55);
  }
}