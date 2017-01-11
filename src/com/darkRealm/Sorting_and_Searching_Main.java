package com.darkRealm;

import com.darkRealm.Sorting_and_Searching.MergeSortUtil;

import java.util.Arrays;

/**
 * Created by Jayam on 1/10/2017.
 */
public class Sorting_and_Searching_Main {

  public static void testMergeSort(){
//    int [] arr =new int[]{12,1,11,2,4,3,8,9,10};
    int [] arr =new int[]{122,164,121,412,314,396,468,996,210};
    arr = MergeSortUtil.mergeSort(arr);
    System.out.println("After Sorting : "+ Arrays.toString(arr));
  }
}
