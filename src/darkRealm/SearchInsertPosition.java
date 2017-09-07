package darkRealm;

import java.util.Arrays;

public class SearchInsertPosition {

//  Given a sorted array and a target value, return the index if the target is found. If not, return the index where it
//  would be if it were inserted in order.
//  You may assume no duplicates in the array.
//  Here are few examples.
//      [1,3,5,6], 5 → 2
//      [1,3,5,6], 2 → 1
//      [1,3,5,6], 7 → 4
//      [1,3,5,6], 0 → 0

  public static int searchInsertPosition(int [] arr, int n){
    if(null == arr || arr.length == 0) return 0;
    if(n <= arr[0]) return 0;
    else if(n == arr[arr.length - 1]) return arr.length - 1;
    else if(n > arr[arr.length - 1]) return arr.length ;
    else{
      for(int i = 0; i  < arr.length; i++)
        if(arr[i]>= n) return i;
    }
    return 0;
  }

  public static void main(String[] args) {
//    int [] arr = new int []{1,3,5,6};
//    int n = 5;

    int [] arr = new int []{1,3};
    int n = 3;

    int pos = searchInsertPosition(arr, n);
    System.out.println("Arr: " + Arrays.toString(arr));
    System.out.println("Pos : " + pos);
  }
}
