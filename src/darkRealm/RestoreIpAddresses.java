package darkRealm;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {

//  #93. Restore IP Addresses
//  Given a string containing only digits, restore it by returning all possible valid IP address combinations.
//  For example:
//  Given "25525511135",
//      return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

  public static List<String> restoreIpAddresses(String s) {
    if (s == null || s.length() < 1 || s.length() > 12) return new ArrayList<>();
    List<String> res = new ArrayList<>();
    helperDFS(s, 0, "", res, 0);
    return res;
  }

  private static void helperDFS(String s, int index, String ip, List<String> res, int part) {
    if (part > 4) return;
    if (part == 4 && index == s.length()) {
      res.add(ip);
      return;
    }
    for (int i = 1; i <= 3 && index + i <= s.length(); i++) {
      String sub = s.substring(index, index + i);
      int num = Integer.parseInt(sub);
      if (num > 255 || (sub.startsWith("0") && sub.length() > 1)) continue;
      String next = ip.length() == 0 ? sub : ip + "." + sub;
      helperDFS(s, index + i, next, res, part + 1);
    }
  }


  public static void main(String[] args) {
//    String s = "25525511135";
//    String s = "123456789";
//    String s = "255255255255";
//    String s = "25515255250";
//    String s = "0000";
//    String s = "02001";
//    String s = "0279245587303";
    String s = "010010";
    List<String> res = restoreIpAddresses(s);
    for (String ip : res)
      System.out.println(ip);
  }
}
