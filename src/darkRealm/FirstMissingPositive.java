package darkRealm;

public class FirstMissingPositive {

  /* #41 First Missing Positive
* Given an unsorted integer array, find the first missing positive integer.
* For example,
* Given [1,2,0] return 3,
* and [3,4,-1,1] return 2.
* Your algorithm should run in O(n) time and uses constant space*/
  public static int firstMissingPositive(int[] arr) {
    if (arr.length == 0) {
      return 1;
    }
    int i = 0;
    while (i < arr.length) {
      if (arr[i] == i + 1 || arr[i] <= 0 || arr[i] > arr.length) {
        i++;
      } else if (arr[arr[i] - 1] != arr[i]) {
        int temp = arr[i];
        arr[i] = arr[arr[i] - 1];
        arr[temp - 1] = temp;
      } else i++;
    }
    for (i = 1; i <= arr.length; i++) {
      if (arr[i - 1] != i) {
        return i;
      }
    }
    return i;
  }
  public static void main(String[] args) {

  }
}
