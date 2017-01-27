package darkRealm.LeetCode;

import darkRealm.CTCI.LinkedLists.LinkedList;
import darkRealm.CTCI.LinkedLists.Node;

/**
 * Created by Jayam on 1/27/2017.
 */
public class LeetCodeMain {
  public static void run() {
//    testAddTwoNumbers();
    testlongestSubstring();
  }

  public static void testAddTwoNumbers() {
    LinkedList l1 = new LinkedList();
    LinkedList l2 = new LinkedList();
    l1.add(2);
    l1.add(4);
    l1.add(3);

    l2.add(5);
    l2.add(6);
    l2.add(4);

//    LinkedList res = LC_Prob_1_50.AddTwoNumbers(l1, l2);
    Node trav = LC_Prob_1_50.AddTwoNumbers(l1, l2);
//    Node trav = res.head;
    while (trav != null) {
      System.out.println(" d : " + trav.data);
      trav = trav.next;
    }
  }

  public static void testlongestSubstring() {
//    String str = "abcabcbb";
//    String str = "bbbbb";
    String str = "pwwkew";

    int res = LC_Prob_1_50.lengthOfLongestSubstring(str);
    System.out.println(" Str : " + str + "  Longest substring : " + res);
  }
}