package darkRealm.CTCI;

import darkRealm.CTCI.Sorting_and_Searching.*;

import java.util.Arrays;

/**
 * Created by Jayam on 1/10/2017.
 */
public class Sorting_and_Searching_Main {

  public static void testMergeSort() {
//    int[] arr = new int[]{2, 4, 3, 10, 9, 8};
    int[] arr = new int[]{11, 31, 42, 4, 53, 50, 9, 2};

//    int [] arr =new int[]{122,164,121,412,314,396,468,996,210};
    MergeSortUtil.mergeSort(arr);
//    QuickSortUtil.quicksort(arr, 0, arr.length - 1);
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

  public static void testSearchRotatedArray() {
//    int[] arr = new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 12, 13, 15};
//    int [] arr = new int[] {12,13,14,15,16,19,20,25,1,3,4,5,7};
    int[] arr = new int[]{20, 25, 1, 3, 4, 5, 7};
//    int [] arr = new int[] {1,3,4,5};
//    int [] arr = new int[] {2,5,6,7,8,9,1};
//    int [] arr = new int[] {12,13,14,15,16,19,20,25};
    int res = Searching_Sorting.searchRotatedArray(arr, 5);
    System.out.println("index " + res);
    System.out.println("Arr " + Arrays.toString(arr));
  }

  public static void testPeaksValleys() {
//    int [] arr = new int[] {5,1,3,2,3};
//    int [] arr = new int[] {1,1,1,2,1};
//    int [] arr = new int[] {0,1,2};
//    int [] arr = new int[] {0,1,4,7,8,9};
//    int [] arr = new int[] {5,8,6,2,3,4,6};
//    int [] arr = new int[] {5,1,3,2};
    int[] arr = new int[]{11, 31, 42, 4, 53, 50, 9, 2};
    Searching_Sorting.peaksValleys(arr);
  }

  public static void testRankStream() {
    int[] arr = new int[]{5, 1, 4, 4, 5, 9, 7, 13, 3};
    int k = 9;
    int rank = Searching_Sorting.rankFromStream(arr, k);
    System.out.println("Rank of " + k + " is " + rank);
    System.out.println(Arrays.toString(arr));
  }

  public static void testSortedMatrixSearch() {
    int[][] mat = new int[][]{
        {1, 2, 5, 7, 9},
        {10, 11, 14, 16, 17},
        {20, 21, 23, 27, 29},
        {30, 34, 39, 45, 48},
        {31, 35, 40, 46, 49},
        {32, 36, 41, 47, 50}
    };
    int k = 33;
    int res = Searching_Sorting.sortedMatrixSearch(mat, k);
    System.out.println("Found some " + res);
  }

  public static void testSparseSearch() {
//    String[] arr = new String[]{"", "bbb", "", "ddd", "", "", "ggg", "", "","jjj"};
//    String[] arr = new String[]{"", "bbb", "", "","","", "", "", "", "", "","jjj"};
//    String[] arr = new String[]{"", "bbb", "", "","","", "", "", "", "hhh", "","","","","",""};
    String[] arr = new String[]{"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "hhh"};
    String res = Searching_Sorting.sparseSearch(arr, "hhh");
    System.out.println("Res : " + res);
    System.out.println(Arrays.toString(arr));
  }

  public static void testGroupAnagrams() {
    String[] arr = new String[]{"caa", "baa", "aac", "aba"};
//    String [] arr = new String[]{"caa","baa","aba","aaa","aab","aac"};
//    String [] arr = new String[]{"aca","aab","aaa","aba","aaa","baa","aac"};
//    String [] arr = new String[]{"cat","tac","sad","das","asd","act"};
    Searching_Sorting.groupAnagrams(arr);
  }

  public static void testFindDuplicates() {
    int arr[] = new int[]{1, 4, 1, 2, 3, 4, 5, 6, 7, 8, 7, 2, 3, 6};
    int memorySize = 8;
    Searching_Sorting.findDuplicates(arr, memorySize);
    System.out.println("================");
    Searching_Sorting.findDuplicatesMyBitsArray(arr, memorySize);

  }

  public static void testInsertionSort() {
//    int[] arr = new int[]{36, 14, 27, 40, 31};
//    int[] arr = new int[]{1};
//    int[] arr = new int[]{1,2};
//    int[] arr = new int[]{1,1};
//    int[] arr = new int[]{2,2,2};
//    int[] arr = new int[]{3,1,0};
    int[] arr = new int[]{3, 1, 0};
    InsertionSortUtil.insertionSort(arr);
    System.out.println("Arr : " + Arrays.toString(arr));
  }

  public static void testQuickSort() {
//    int[] arr = new int[]{36, 14, 27, 40, 31};
    int[] arr = new int[]{3, 1, 0};

    //    QuickSortUtil.quicksort(arr, 0, arr.length-1);
//    QuickSortUtil.quicksort(arr, 0, arr.length - 1);
    QuickSortUtil.quickSortZZ(arr, 0, arr.length - 1);
    System.out.println("Arr : " + Arrays.toString(arr));
  }

  public static void testCountSort() {
    int[] arr = new int[]{5, 1, 2, 2, 3};
//    QuickSortUtil.quicksort(arr, 0, arr.length-1);
    arr = CountingSortUtil.countingSort(arr, arr.length);
    System.out.println("Arr : " + Arrays.toString(arr));
  }

  public static void testRadix() {
//    int[] arr = new int[]{33101, 26440, 16341, 20101, 801};
    int[] arr = new int[]{16341, 20101, 801, 33101, 26440};
    arr = RadixSortUtil.radixSort(arr, 5);
    System.out.println("Arr : " + Arrays.toString(arr));
  }
}