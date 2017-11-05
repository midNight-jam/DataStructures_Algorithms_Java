package darkRealm;

import java.util.HashMap;
import java.util.Map;

public class ValidAbbrevation {

//  #288. Unique Word Abbreviation
//  An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:
//  a) it                      --> it    (no abbreviation)
//     1
//  b) d|o|g                   --> d1g
//              1    1  1
//                  1---5----0----5--8
//  c) i|nternationalizatio|n  --> i18n
//              1
//                  1---5----0
//  d) l|ocalizatio|n          --> l10n
//  Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
//  Example:
//  Given dictionary = [ "deer", "door", "cake", "card" ]
//  isUnique("dear") ->
//      false
//  isUnique("cart") ->
//      true
//  isUnique("cane") ->
//      false
//  isUnique("make") ->
//      true


  Map<String, String> map;

  public ValidAbbrevation(String[] dictionary) {
    map = new HashMap<>();
    for (String s : dictionary) {
      String abr = getAbbrevation(s);
      // if an abbrevation is already present and it is not against the same word, then this aabrevation cannot be
      // given to any other word because it is already consumed by dictionary word, thus remove its words from map.
      if (map.containsKey(abr) && !map.get(abr).equals(s)) map.put(abr, "");
      else map.put(abr, s); // if an abbrevation is not present add it to map
    }
  }

  private String getAbbrevation(String s) {
    if (s.length() < 3) return s;
    return s.charAt(0) + "" + (s.length() - 2) + "" + (s.charAt(s.length() - 1)) + "";
  }

  public boolean isUnique(String s) {
    String abr = getAbbrevation(s);
    return !map.containsKey(abr) || map.get(abr).equals(s);
  }

  public static void main(String[] args) {
    String[] dict = new String[]{"deer", "door", "cake", "card", "door"};
    ValidAbbrevation vab = new ValidAbbrevation(dict);
//    boolean res = vab.isUnique("dear");
//    boolean res = vab.isUnique("cart");
//    boolean res = vab.isUnique("cane");
    boolean res = vab.isUnique("make");
    System.out.println("r : " + res);
  }
}
