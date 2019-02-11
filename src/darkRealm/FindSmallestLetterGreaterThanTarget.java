package darkRealm;

import java.util.Arrays;

public class FindSmallestLetterGreaterThanTarget {

//  744. Find Smallest Letter Greater Than Target
//  Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.
//  Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
//
//  Examples:
//  Input:
//  letters = ["c", "f", "j"]
//  target = "a"
//  Output: "c"
//
//  Input:
//  letters = ["c", "f", "j"]
//  target = "c"
//  Output: "f"
//
//  Input:
//  letters = ["c", "f", "j"]
//  target = "d"
//  Output: "f"
//
//  Input:
//  letters = ["c", "f", "j"]
//  target = "g"
//  Output: "j"
//
//  Input:
//  letters = ["c", "f", "j"]
//  target = "j"
//  Output: "c"
//
//  Input:
//  letters = ["c", "f", "j"]
//  target = "k"
//  Output: "c"
//  Note:
//  letters has a length in range [2, 10000].
//  letters consists of lowercase letters, and contains at least 2 unique letters.
//  target is a lowercase letter.

  public static char nextGreatestLetter(char[] chars, char target) {
    char res = (char) 0;
    if (chars == null || chars.length < 1) return res;
    int left = 0;
    int right = chars.length - 1;
    int mid;
    while (left < right) {
      mid = left + (right - left) / 2;
      if (chars[mid] > target)
        right = mid;
      else
        left = mid + 1;
    }

    return target >= chars[chars.length - 1] ? chars[0] : chars[right];
  }

  public static void main(String[] args) {
    char[] chars = new char[]{'c', 'f', 'j'};
    char target = 'd';
    char res = nextGreatestLetter(chars, target);
    System.out.println(Arrays.toString(chars));
    System.out.println("target : " + target + "  res : " + res);
  }
}
