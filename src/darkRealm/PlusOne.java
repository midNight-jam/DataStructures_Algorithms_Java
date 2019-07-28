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

  public static int[] plusOneXtra(int[] digits) {
    if(digits == null || digits.length < 1) return digits;
    int sum = 1;
    int carry = 0;
    for(int i = digits.length - 1; i >= 0; i--){
      sum  += digits[i] + carry;
      carry = sum / 10;
      sum = sum % 10;
      digits[i] = sum;
      sum = 0;
    }
    if(carry < 1)
      return digits;
    int [] res = new int[digits.length + 1];
    for(int i = 0; i <digits.length; i++)
      res[i+1] = digits[i];
    res[0] =carry;
    return res;
  }
  
  
  public static void main(String[] args) {

  }
}
