package com.darkRealm;

import com.darkRealm.Sorting_and_Searching.BinarySearchUtil;
import com.darkRealm.Sorting_and_Searching.QuickSortUtil;
import com.darkRealm.Sorting_and_Searching.Searching_Sorting;

import java.util.Arrays;

/**
 * Created by Jayam on 1/10/2017.
 */
public class Sorting_and_Searching_Main {

  public static void testMergeSort() {
//    int[] arr = new int[]{2, 4, 3, 10, 9, 8};
    int[] arr = new int[]{11, 31, 42, 4, 53, 50, 9, 2};

//    int [] arr =new int[]{122,164,121,412,314,396,468,996,210};
//    arr = MergeSortUtil.mergeSort(arr);
    arr = QuickSortUtil.quicksort(arr, 0, arr.length - 1);
    System.out.println("After Sorting : " + Arrays.toString(arr));
  }

  public static void testBinarySearch() {
    int[] arr = new int[]{0, 1, 2, 4, 6, 9, 71};
    int res = BinarySearchUtil.binarySearchRecursive(arr, 90, 0, arr.length - 1);
    System.out.println("Was in Array : " + res);
  }

  public static void testSortedMerge() {
    int[] arr = new int[8];
    arr[0] = 11;
    arr[1] = 22;
    arr[2] = 33;
    arr[3] = 44;
    arr[4] = 55;
    arr[5] = 0;
    arr[6] = 0;
    arr[7] = 0;
    int[] brr = new int[3];
    brr[0] = 9;
    brr[1] = 27;
    brr[2] = 48;

    arr = Searching_Sorting.sortedMerge(arr, brr);
    System.out.println("Sorted Merge : " + Arrays.toString(arr));
  }

  public static void testKthSmallestElement() {
    int[] arr = new int[]{11, 31, 42, 4, 53, 50, 9, 2};
    int kth = QuickSortUtil.kthSmallestElement(arr, 0, arr.length - 1, 7);
    System.out.println("Array : " + Arrays.toString(arr));
    System.out.println("Kth smalles : " + kth);

  }
  public static void testSearchRotatedArray(){
    int [] arr = new int[] {15,16,19,20,25,1,3,4,5,7,10,12,13,15};
//    int [] arr = new int[] {12,13,14,15,16,19,20,25,1,3,4,5,7};
//    int [] arr = new int[] {12,13,14,15,16,19,20,25};
    Searching_Sorting.searchRotatedArray(arr,5);
  }
}