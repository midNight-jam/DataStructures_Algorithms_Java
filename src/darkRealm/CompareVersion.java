package darkRealm;

public class CompareVersion {

//  #165. Compare Version Numbers
//  Compare two version numbers version1 and version2.
//  If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
//  You may assume that the version strings are non-empty and contain only digits and the . character.
//  The . character does not represent a decimal point and is used to separate number sequences.
//  For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of
//  the second first-level revision.
//  Here is an example of version numbers ordering:
//      0.1 < 1.1 < 1.2 < 13.37

  public static int compareVersion(String v1, String v2) {
    String[] ver1 = v1.split("\\.");
    String[] ver2 = v2.split("\\.");
    int i = 0, j = 0;
    while (i < ver1.length || j < ver2.length) {
      int vi = i < ver1.length ? Integer.parseInt(ver1[i]) : 0; // if it has exceeded take 0
      int vj = j < ver2.length ? Integer.parseInt(ver2[j]) : 0; // if it has exceeded take 0
      if (vi > vj) return 1;
      else if (vi < vj) return -1;
      i++;
      j++;
    }
    return 0;
  }

  public static void main(String[] args) {
//    String v1 = "1.1";
//    String v2 = "1.20";
    String v1 = "1.1.1";
    String v2 = "1.1";
    int res = compareVersion(v1, v2);
    System.out.println("v1 : " + v1);
    System.out.println("v2 : " + v2);
    System.out.println("r  : " + res);
  }
}
