package darkRealm;

public class SearchInASortedArrayOfUnknownSize {

//  702. Search in a Sorted Array of Unknown Size
//  Given an integer array sorted in ascending order, write a function to search target in nums.  If target exists,
//  then return its index, otherwise return -1. However, the array size is unknown to you. You may only access the
//  array using an ArrayReader interface, where ArrayReader.get(k) returns the element of the array at index k (0-indexed).
//
//  You may assume all integers in the array are less than 10000, and if you access the array out of bounds,
//  ArrayReader.get will return 2147483647.
//
//  Example 1:
//  Input: array = [-1,0,3,5,9,12], target = 9
//  Output: 4
//  Explanation: 9 exists in nums and its index is 4
//
//  Example 2:
//  Input: array = [-1,0,3,5,9,12], target = 2
//  Output: -1
//  Explanation: 2 does not exist in nums so return -1
//  Note:
//  You may assume that all elements in the array are unique.
//  The value of each element in the array will be in the range [-9999, 9999].

  private static class ArrayReader {
    ArrayReader() {

    }

    public int get(int index) {
      return 0; // this is not the actual implementation of get, that thing is provided by leetCode, I am just mocking it
      //  so compilation doesnt fails
    }
  }

  
  public static int search(ArrayReader reader, int target) {
    int left = 0;
    int right = 1;
    int peek = reader.get(right);
    while (peek != Integer.MAX_VALUE) {
      if (target < peek) break;
      right = right * 2;
      peek = reader.get(right);
    }

    if (reader.get(right) == Integer.MAX_VALUE) {
      int mid;
      while (left <= right) {
        mid = left + (right - left) / 2;
        if (reader.get(mid) == Integer.MAX_VALUE)
          right = mid - 1;
        else
          left = mid;
      }

      right = left;
    }

    return binSearch(reader, 0, right, target);
  }

  private static int binSearch(ArrayReader reader, int low, int high, int target) {
    int mid;
    while (low <= high) {
      mid = low + (high - low) / 2;
      int am = reader.get(mid);
      if (am < target) low = mid;
      else if (am > target) high = mid - 1;
      else return mid;
    }

    return -1;
  }

  
  
  public static int searchOLD(ArrayReader reader, int target) {
    int left = 0;
    int upperBoundRight = 1;
    // find upperbound of the right end, using power 2
    while (reader.get(upperBoundRight) != 2147483647)
      upperBoundRight *= 2;

    // now as we have the upperbound for right, find the exactRight

    int lowerRight = 1;
    int exactRight = 0;

    while (lowerRight <= upperBoundRight) {
      exactRight = lowerRight + (upperBoundRight - lowerRight) / 2;
      if (reader.get(exactRight) > 2147483646)
        upperBoundRight = exactRight - 1;
      else if (reader.get(exactRight) < 2147483647)
        lowerRight = exactRight + 1;
      else
        break;
    }

    int right = exactRight;
    // now perform the usual binary Search as we have calculated the left + right
    int mid;
    while (left <= right) {
      mid = left + (right - left) / 2;
      if (reader.get(mid) > target)
        right = mid - 1;
      else if (reader.get(mid) < target)
        left = mid + 1;
      else return mid;
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
    int target = 2;
    int res = search(new ArrayReader(), target);
    System.out.println(res);
  }
}
