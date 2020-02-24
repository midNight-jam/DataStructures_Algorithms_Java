package darkRealm;

import java.util.Arrays;

public class FindSmallestLetterGreaterThanTarget {

//  744. Find Smallest Letter Greater Than Target
//  Given a list of sorted characters letters containing only lowercase letters, and given a target letter target,
//  find the smallest element in the list that is larger than the given target.
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

  public static char nextGreatestLetter(char[] letters, char tar) {
    if(letters == null) return (char)0;
    // base check if tar is already out of letters, return low.
    if(tar >= letters[letters.length - 1] || tar < letters[0]) return letters[0];

    int low = 0;
    int high = letters.length - 1;
    int mid;
    while(low <= high){
      mid = low + (high - low) / 2;
      if(letters[mid] <= tar) // skip all the lower & equal elements
        low = mid + 1;
      else if(letters[mid] > tar)
        high = mid - 1;
    }
    System.out.println(low +" : " + high);
    return letters[low]; // low is the insertion position, thus return the char at low
  }

  public static void main(String[] args) {
//    char[] chars = new char[]{'c', 'f', 'j'};
//    char target = 'd';

    char[] chars = new char[]{'e','e','e','e','e','e','n','n','n','n'};
    char target = 'e';

    char res = nextGreatestLetter(chars, target);
    System.out.println(Arrays.toString(chars));
    System.out.println("target : " + target + "  res : " + res);
  }
}
