package darkRealm;

import java.util.ArrayList;
import java.util.List;

public class  PowerSetSubStringsWithoutDups{

  public static List<String> generatePowerSet_WithoutDups(String s) {
    List<String> res = new ArrayList<>();
    boolean[] used = new boolean[s.length()];
    backtrack(res, new ArrayList<>(), -1, s, used);
    return res;
  }

  private static void backtrack(List<String> res, List<Character> temp, int pos, String s, boolean[] used) {
    if (temp.size() > s.length()) return;
    // adding the current part to res
    String sub = "";
    for(char c : temp)
      sub += c;
    res.add(sub);

    for (int i = 0; i < s.length(); i++) {
      if (i == pos || used[i]) continue;
      temp.add(s.charAt(i));
      used[i] = true;
      backtrack(res, temp, i + 1, s, used);
      temp.remove(temp.size() - 1);
      used[i] = false;
    }
  }

  public static void main(String[] args) {
    String s = "abc";
    List<String> res = generatePowerSet_WithoutDups(s);
    for (String l : res)
      System.out.println(l);
  }
}