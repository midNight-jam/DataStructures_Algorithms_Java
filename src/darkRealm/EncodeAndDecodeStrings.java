package darkRealm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeStrings {

//  #271. Encode and Decode Strings
//  Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and
//  is decoded back to the original list of strings.
//      Machine 1 (sender) has the function:
//  string encode(vector<string> strs) {
//    // ... your code
//    return encoded_string;
//  }
//  Machine 2 (receiver) has the function:
//  vector<string> decode(string s) {
//    //... your code
//    return strs;
//  }
//  So Machine 1 does:
//  string encoded_string = encode(strs);
//  and Machine 2 does:
//  vector<string> strs2 = decode(encoded_string);
//  strs2 in Machine 2 should be the same as strs in Machine 1.
//  Implement the encode and decode methods.
//  Note:
//  The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be
//  generalized enough to work on any possible characters.
//  Do not use class member/global/static variables to store states. Your encode and decode algorithms should be
//  stateless.
//  Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode
//  algorithm.

  public static String encode(List<String> strs) {
    if (strs == null || strs.size() == 0) return "";
    StringBuilder sbr = new StringBuilder();
    // Intuition is to mark how the long the string is + followed by a separator + followed by the actual String
    // why separator, beacuse we need a way to determin the size of the string, if we just append the size of string
    // ahead of its contend we cannot be sure how long the string is if string begins with number.
    for (String s : strs)
      sbr.append(s.length() + "##" + s);
    return sbr.toString();
  }

  public static List<String> decode(String s) {
    List<String> res = new ArrayList<>();
    if (s == null) return res;

    int index = 0;
    String sep = "##";
    int sepIndex = -1;
    int len, seplen = 2;
    while (index < s.length()) {
      sepIndex = s.indexOf(sep, index);
      len = Integer.parseInt(s.substring(index, sepIndex));
      String r = s.substring(sepIndex + seplen, sepIndex + seplen + len);
      res.add(r);
      index = sepIndex + seplen + len;
    }

    return res;
  }

  public static String encodeZZ(List<String> strs) {
    StringBuilder sbr = new StringBuilder();

    for (String s : strs) {
      sbr.append((s.length() + "#") + s);
    }

    return sbr.toString();
  }

  // Decodes a single string to a list of strings.
  public static List<String> decodeZZ(String s) {
    int ptr = 0;
    List<String> res = new ArrayList<>();

    for (int i = 0; i < s.length(); ) {
      ptr = 0;
      while (s.charAt(i) != '#') {
        ptr = ptr * 10 + s.charAt(i) - '0';
        i++;
      }
      i++; // skip the hash
      String sub = s.substring(i, i + ptr);
      res.add(sub);
      i += ptr;
    }

    return res;
  }

  public static void main(String[] args) {
//    String[] sarr = new String[]{"abc", "///", "123"};
    String[] sarr = new String[]{"C#", "&", "~Xp|F", "R4QBf   9()))g=_", "", " 0"};
    List<String> strs = new ArrayList<>(Arrays.asList(sarr));
    System.out.println(strs);
    String encodedStr = encodeZZ(strs);
    System.out.println(encodedStr);
    strs = decodeZZ(encodedStr);
    for (String s : strs)
      System.out.println(s);
  }
}
