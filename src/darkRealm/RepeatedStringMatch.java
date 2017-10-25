package darkRealm;


public class RepeatedStringMatch {

//  #686. Repeated String Match
//  Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it.
//  If no such solution, return -1.
//  For example, with A = "abcd" and B = "cdabcdab".
//  Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of
//  A repeated two times ("abcdabcd").
//  Note:
//  The length of A and B will be between 1 and 10000.


  public static int repeatedStringMatch(String a, String b) {
    if (a == null || a.length() == 0 || b == null || b.length() == 0) return -1;
    StringBuilder sb = new StringBuilder();
    int count = 0;
    while(sb.length() < b.length()) {
      sb.append(a);
      count++;
    }

    if(sb.toString().contains(b)) return count;
    sb.append(a);count++;
    if(sb.indexOf(b) > -1 ) return count;
    return -1;
  }

  public static void main(String[] args) {
    String a = "abcd";
    String b = "cdabcdab";
    int res = repeatedStringMatch(a, b);
    System.out.println("A : " + a);
    System.out.println("B : " + b);
    System.out.println("R : " + res);
  }
}