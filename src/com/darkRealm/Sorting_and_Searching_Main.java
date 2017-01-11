package com.darkRealm;

import com.darkRealm.Sorting_and_Searching.BinarySearchUtil;
import com.darkRealm.Sorting_and_Searching.MergeSortUtil;
import com.darkRealm.Sorting_and_Searching.QuickSortUtil;
import com.darkRealm.Sorting_and_Searching.Searching_Sorting;

import java.util.Arrays;

/**
 * Created by Jayam on 1/10/2017.
 */
public class Sorting_and_Searching_Main {

  public static void testMergeSort() {
    int[] arr = new int[]{2, 4, 3, 10, 9, 8};
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
}