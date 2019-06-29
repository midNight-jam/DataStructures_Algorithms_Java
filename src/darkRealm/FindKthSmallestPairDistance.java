package darkRealm;

public class FindKthSmallestPairDistance {

  public static int smallestDistancePair(int[] nums, int k) {
    if(nums == null || nums.length < 2 || k < 1 || k > nums.length * (nums.length - 1) / 2 ) return 0;

    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for(int i : nums){
      min = Math.min(min, i);
      max = Math.max(max, i);
    }

    int [] diffMap = new int [(max - min) + 1]; //maxDiff can be 10 ^ 6, because given is 0 <= nums[i] < 1000000.

    System.out.println(diffMap.length);
    for(int i = 0; i < nums.length; i++){
      for(int j = i + 1; j < nums.length; j++){
        int d = Math.abs(nums[i] - nums[j]);
        diffMap[d]++;
      }
    }

    int sum = 0;
    for(int i = 0;i < diffMap.length;i++){
      sum+= diffMap[i];
      if(sum >= k) // we have skipped first k diffs
        return i;
    }

    return 0;
  }

  public static void main(String[] args) {
//    int[] nums = new int[]{1, 3, 1, 2, 4};
//    int k = 5;
//    int[] nums = new int[]{1, 3, 1};
//    int k = 1;
    int[] nums = new int[]{62, 100, 4};
    int k = 2;
    int res = smallestDistancePair(nums, k);
    System.out.println(res);
  }
}
