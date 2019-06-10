package darkRealm;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithKDistinctChars {
//  #340. Longest Substring with At Most K Distinct Characters
//  Given a string, find the length of the longest substring T that contains at most k distinct characters.
//  For example, Given s = “eceba” and k = 2,
//  T is "ece" which its length is 3.

  public static int lengthOfLongestSubstringKDistinct(String s, int k) {
    int maxLen = 0;
    int left  = 0, right = 0, count = 0;
    int [] map = new int[128];
    while(right < s.length()){
      char c = s.charAt(right);
      if(map[c]==0) count++;
      map[c]++;
      while(count > k){
        c = s.charAt(left);
        map[c]--;
        if(map[c]==0) count--;
        left++;
      }
      maxLen = Math.max(maxLen, right - left + 1);
      right++;
    }
    return maxLen;
  }

  public static int lengthOfLongestSubstringKDistinct_HashMap(String s, int k) {
    if(s == null || s.length() < 1 || k < 1 ) return 0;
    Map<Character, Integer> map = new HashMap<>();
    int si;
    si = 0;
    char [] arr = s.toCharArray();
    int res = 1;
    map.put(arr[0], 1);
    for(int i = 1; i < s.length(); i++){
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
      while(map.size() > k && si < i){
        char sc = arr[si];
        if(map.get(sc) == 1)
          map.remove(sc);
        else
          map.put(sc, map.get(sc) - 1);
        si++;
      }
      res = Math.max(res, i - si + 1);
    }
    return res;
  }

  public static void main(String[] args) {
//    String s = "eceba";
//    int k = 2;
    String s = "a";
    int k = 2;
    int res = lengthOfLongestSubstringKDistinct(s, k);
    System.out.println("s : "+s);
    System.out.println("k : "+k);
    System.out.println("r : "+res);
  }
}
