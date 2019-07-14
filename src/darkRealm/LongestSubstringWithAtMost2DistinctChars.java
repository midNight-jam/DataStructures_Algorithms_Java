package darkRealm;

public class LongestSubstringWithAtMost2DistinctChars {

//  #159. Longest Substring with At Most Two Distinct Characters
//  Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
//  For example, Given s = “eceba”,
//  T is "ece" which its length is 3.

  public int lengthOfLongestSubstringTwoDistinct(String s) {
    int maxLen = 0, k = 2;
    int left = 0, right = 0, count = 0;
    int[] map = new int[128];
    while (right < s.length()) {
      char c = s.charAt(right);
      if (map[c] == 0) count++;
      map[c]++;
      while (count > k) {
        c = s.charAt(left);
        map[c]--;
        if (map[c] == 0) count--;
        left++;
      }
      maxLen = Math.max(maxLen, right - left + 1);
      right++;
    }
    return maxLen;
  }
  
   public int lengthOfLongestSubstringTwoDistinctANOTHER(String s) {
    if(s == null || s.length() < 1) return 0;
    Map<Character, Integer> map = new HashMap<>();
    int len = 0;
    char [] arr = s.toCharArray();
    int res = Integer.MIN_VALUE;
    for(int i = 0; i < arr.length; i++){
      if(!map.containsKey(arr[i]) && map.size() == 2){
        int min = Integer.MAX_VALUE;
        char out = arr[i];
        for(char c : map.keySet()){
          if(map.get(c) < min){
            out = c;
            min = map.get(c);
          }
        }
        len = i - min - 1; //beacuse will get increment in the below statement
        map.remove(out);
      }
      map.put(arr[i], i);
      len++;
      res = Math.max(res, len);
    }    
    return res;
  }

  public static void main(String[] args) {
    System.out.println("R ");
  }
}
