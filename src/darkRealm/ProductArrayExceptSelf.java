package darkRealm;

public class ProductArrayExceptSelf {

  /* #238 Product of Array Except Self
*Given an array of n integers where n > 1, numbers, return an array output such that output[i] is equal to the product
* of all the elements of numbers except numbers[i].
* Solve it without division and in O(n).
* For example, given [1,2,3,4], return [24,12,8,6].
* */
  public static int[] productExceptSelf(int[] arr) {
    int[] res = new int[arr.length];
    int temp = 1;
    // we have to create a shifted aray of products thats why we initialize with 1 and not arr[0], this will give us all
    // the nos product except the last number, now we traverse this product the array but from right, and multiply with
    // the number at same pos in res array.
    for (int i = 0; i < arr.length; i++) {
      res[i] = temp;
      temp *= arr[i];
    }
    int right = 1;
    for (int j = arr.length - 1; j >= 0; j--) {
      res[j] = res[j] * right;
      right = right * arr[j];
    }
    return res;
  }
  
  public int[] productExceptSelfMAINIDEA(int[] nums) {
    if(nums == null || nums.length < 1) return nums;
    
    int n = nums.length;
    int [] leftProd = new int[nums.length];
    int [] rightProd = new int[nums.length];
    
    int lprod = 1;
    int rprod = 1;
    int li, ri;
    
    for(int i = 0; i < n; i++){
      li = i;
      ri = n - 1 - i;
      lprod *= nums[li];
      leftProd[li] = lprod;
      rprod *= nums[ri];
      rightProd[ri] = rprod;
    }

    for(int i = 0; i < n; i++){
      int l = i > 0 ? leftProd[i-1] : 1;
      int r = i < n -1 ? rightProd[i+1] : 1;
      nums[i] = l * r;
    }
    
    return nums;
  }

  public static void main(String[] args) {

  }
}
