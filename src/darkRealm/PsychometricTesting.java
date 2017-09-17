package darkRealm;

import java.util.Arrays;

public class PsychometricTesting {
  // Given the range of scores of candidates and 2 other arrays of ranges
  // Have to return the array result having the number of candidates that meet the range
  // Scores = [4,7,8]
  // lower = [2,4]
  // high = [8,4]
  // so ranges are {(2,8), (4,4)}
  // result will be [3,1] bcoz all 3 elements fall in the first range and only 4 falls in the second range
  
  public static int [] jobOffers(int [] scores , int [] lowerLimits, int [] upperLimits){
    Arrays.sort(scores);
    int  [] res = new int[lowerLimits.length];
    for(int i = 0; i < lowerLimits.length; i++){
      int [] range = modBInSearchHigh(scores, lowerLimits[i] -1);
      res[i] = range [1] - range[0];
    }
    return res;
  }

  public static int[] modBInSearchHigh(int [] nums, int n) {
    int low = 0, high = nums.length;
    while (low != high) {
      int mid = (low + high) / 2;
      if (nums[mid] <= n) low = mid + 1;
      else high = mid;
    }
    return new int[]{low, high};
  }

  public static String even(String sent) {
    String[] word = sent.split(" ");
    int max = Integer.MIN_VALUE;
    int index = -1;
    for (int i = 0; i < word.length; i++)
      if ((word[i].length() & 1) == 0 && word[i].length() > max) {
        max = word[i].length();
        index = i;
      }

    return index == -1 ? "00" : word[index];
  }

  public static void main(String[] args) {
    int  [] scores = new int[] {4,8,7};
    int  [] low = new int[] {2,4};
    int  [] upper = new int[] {8,4};
    int [] res = jobOffers(scores,low, upper);
//    int res  = modBInSearch(scores,80);
//    int  [] scores = new int[] {4,7, 8};
//    int res  = modBInSearchSmall(scores,8);
    System.out.println(Arrays.toString(res));
  }
}
