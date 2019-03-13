package darkRealm;

import java.util.Random;

public class RandomPickIndex {

  Random random;
  int [] nums;

  public RandomPickIndex (int[] nums) {
    random = new Random();
    this.nums = nums;
  }

  /* let target be target = 3
  *  & let array be {1,2,3,3,3,1,2,1,2,1,1,3,3,3,3,3,3,3,3,3};
  *  1's indexes : 0,5,7,9
  *  2's indexes : 1,6,8,10,11
  *  3's indexes : 2,3,4,11,12,13,14,15,16,17,18,19
  *
  *  Now we need to select any one index for 3 with equal probablity i.e "1/N", but as the array can be very large,
  *  we will not be able to store all this indexes & pick one with equal prob.
  *  So, what can be done.
  *  if we shrink down the array with jusst one occurence of target {1,2,3}, we can see the only index it will appear
  *  at is 2. We already have the information about 2 as it will be current index, we just need to determine with equal
  *  prob "1/N" to inlcude 2 in the result. As it is the only occurence of target N = 1, as thus 2 will be inlucded for
  *  sure "1/1". But when we expand the array to {1,2,3,3} now when the last 3 arrives the N will not be 1, instead it
  *  will be 2, so we will need to choose between index 2,3 with 1/2 probablity & so on...
  *  Given in the question that the target will be always present in the array gurantees that there will be atleast 1 occurence
  *  from above we know that we have to maintain count of times the target is encountered to have correct N.
  *  Now to determine to select the index with 1/N probablity we can use a random no between (0 to N-1) N items.
  *  as it is guranted that the target is present at the min the count will be 1 and for that we will have a random no "0"
  *  with 1/1 prob.
  *
  *           3's indexes : 2,3,4,11,12,13,14,15,16,17,18,19
  *  3's count till index : 1,2,3, 4, 5, 6, 7, 8, 9,10,11,12
  *
  *  if we observe on every match with target we have the count & among all rand nos between 0 to count that can be
  *  generated with 1/N prob, there is one such no that is guranteed to be present always which is 0(as the count will be
  *  1, as guranteed by the question that the target will always be present).
  *
  *  Thus, when we get the match we generate a rand no between 0toN & if the rand is 0 (with 1/N probablity) we store
  *  the index in the result, and do the same next time we get the target.
  * */

  public int pick(int target) {
    int res = -1;
    int count = 0;
    for(int i = 0; i < nums.length; i++){
      if(nums[i] == target){
        if(random.nextInt(count + 1) == 0)
          res = i;
        count++;
      }
    }
    return res;
  }
  public static void main(String[] args) {

  }
}
