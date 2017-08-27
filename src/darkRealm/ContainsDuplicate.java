package darkRealm;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
  public static boolean containsDuplicate(int [] nums){
    if(nums == null || 2 > nums.length) return false;
    Set<Integer> set = new HashSet<>();
    for(int n : nums) {
      if (set.contains(n)) return true;
      set.add(n);
    }
    return false;
  }
  public static void main(String[] args) {

  }
}
