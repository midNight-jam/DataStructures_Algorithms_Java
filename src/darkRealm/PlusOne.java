package darkRealm;

public class PlusOne {

/*
  #66. Plus One
  Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
  You may assume the integer do not contain any leading zero, except the number 0 itself.
  The digits are stored such that the most significant digit is at the head of the list.
  */

  public static int[] plusOne(int[] nums) {
    if (nums == null || nums.length == 0) return nums;
    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] < 9) {
        nums[i]++;
        return nums;
      } else nums[i] = 0;
    }
    int[] newNo = new int[nums.length + 1];
    newNo[0] = 1;
    return newNo;
  }

  public static void main(String[] args) {

  }
}
