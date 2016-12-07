package com.darkRealm.BigO;

/**
 * Created by Jayam on 8/29/2016.
 */
public class BinarySearch {


    public static int doBinarySearch(int[] arr, int n) {
        int low = 0;
        int high = arr.length - 1;
        return binarySearch(arr, n, low, high);
    }

    private static int binarySearch(int[] arr, int n, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (n == arr[mid]) {
                return mid;
            }
            if (n < arr[mid]) {
                return binarySearch(arr, n, low, mid - 1);
            } else {
                return binarySearch(arr, n, mid + 1, high);
            }
        }
        return -1;
    }
}
