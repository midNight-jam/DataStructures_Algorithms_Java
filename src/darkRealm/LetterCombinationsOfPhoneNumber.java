package darkRealm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {


  /*  #17  Letter Combinations of a Phone Number
  * Given a digit string, return all possible letter combinations that the number could represent.
  * A mapping of digit to letters (just like on the telephone buttons) is given below.
  * Input:Digit string "23"
  * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
  * */

  static Map<Character , List<String>> map;
  public static List<String> letterCombinations(String digits) {
    if(digits == null || digits.length() < 1 
      || digits.indexOf("1") > -1 || digits.indexOf("0") > -1
      || digits.indexOf("*") > -1 || digits.indexOf("#") > -1)
      return new ArrayList<>();
    
    map = new HashMap<>();
    map.put('2', Arrays.asList("a","b","c"));
    map.put('3', Arrays.asList("d","e","f"));
    map.put('4', Arrays.asList("g","h","i"));
    map.put('5', Arrays.asList("j","k","l"));
    map.put('6', Arrays.asList("m","n","o"));
    map.put('7', Arrays.asList("p","q","r","s"));
    map.put('8', Arrays.asList("t","u","v"));
    map.put('9', Arrays.asList("w","x","y","z"));
    
    return helper(digits, 0);
  }
  
  private static List<String> helper(String digits, int index){
    if(index == digits.length() - 1)
      return map.get(digits.charAt(index));
    
    List<String> res = new ArrayList<>();
    List<String> here = map.get(digits.charAt(index));
    List<String> next = helper(digits, index + 1);
    
    for(String s : here)
      for(String n : next)
        res.add(s + "" + n);
    
    return res;
  }

  public static void main(String[] args) {

  }
}
