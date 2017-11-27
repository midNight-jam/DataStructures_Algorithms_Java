package darkRealm;

import java.util.*;

public class FindSegementSize {

//  GIven the array of chars find all the segments size, each segment is such that it contains char only from that segment
//  a', 'b', 'c', 'd', 'a', 'e', 'f', 'g', 'h', 'g', 'i', 'j'
//  here we have 3 segments
//  a', 'b', 'c', 'd', 'a' | 'e', 'f', 'g', 'h', 'g' | 'i', 'j'
//            5                       5                 2
  public static List<Integer> findSegments(List<Character> list) {
    List<Integer> res = new ArrayList<>();
    Map<Character, Integer> map = new HashMap<>();
    Set<Character> set = new HashSet<>();
    int left = 0;
    for (int i = 0; i < list.size(); i++)
      map.put(list.get(i), i);
    int index = 0;
    for (int i = 0; i < list.size(); i++) {
      char c = list.get(i);
      index = map.get(c);
      if (i == index) {
        set.remove(c);
      } else set.add(c);
      if (set.size() == 0) {
        res.add(i - left + 1);
        left = i + 1;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    List<Character> list = new ArrayList<>(Arrays.asList(new Character[]{'a', 'b', 'c', 'd', 'a', 'e', 'f', 'g', 'h', 'i', 'j', 'e'}));
    List<Integer> res = findSegments(list);
    System.out.println(res);
  }
}
