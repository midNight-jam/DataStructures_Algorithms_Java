package darkRealm;

public class SingleElementInASortedArray {

//  540. Single Element in a Sorted Array
//  Given a sorted array consisting of only integers where every element appears exactly twice except for one element
//  which appears exactly once. Find this single element that appears only once.
//
//
//  Example 1:
//
//  Input: [1,1,2,3,3,4,4,8,8]
//  Output: 2
//  Example 2:
//
//  Input: [3,3,7,7,10,11,11]
//  Output: 10
//
//  Note: Your solution should run in O(log n) time and O(1) space.


  /*
  * Another interesting problem, the break down is to realise that all the valid pairs will always start from an even index.
  * Find the mid in usual way, if its odd reduce it to lower even & check if a valid pair is present, if yes, it means
  * that this & all others paris b4 this are valid otherwise how can this pair be valid & start at even & end at odd.
  * thus look ahead(update low = mid + 2) skip the pair.
  * If this is not a pair the single element can be on the left side, thus reduce high to mid - 1 & keep searching
  * */

  public static int singleNonDuplicate(int[] nums) {
    if (nums == null || nums.length < 1) return 0;
    int low = 0;
    int high = nums.length - 1;
    int mid;
    while (low <= high) {
      mid = low + (high - low) / 2;
      if ((mid & 1) == 1) mid--; // take mid back to even index, as thats where the pairs start

      if (mid + 1 <= high && nums[mid] == nums[mid + 1])// valid pair, move ahead, because this & all the pairs b4 this are valid
        low = mid + 2;
      else // the sinlge present number is on the left from here
        high = mid - 1;
    }
    return nums[low];
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8};
    int res = singleNonDuplicate(nums);
    System.out.println(res);
    System.out.println(res == 2 ? "Pass" : "fail");
  }
}
