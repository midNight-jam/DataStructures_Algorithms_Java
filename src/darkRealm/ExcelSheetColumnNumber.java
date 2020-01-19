package darkRealm;

public class ExcelSheetColumnNumber {

//  171. Excel Sheet Column Number
//  Given a column title as appear in an Excel sheet, return its corresponding column number.
//  For example:
//  A -> 1
//  B -> 2
//  C -> 3
//      ...
//  Z -> 26
//  AA -> 27
//  AB -> 28

  public static int titleToNumber(String s) {
    int res = 0;
    if (null == s) return res;
    s = s.toUpperCase();
    int pow26 = 1;
    for (int i = s.length() - 1; i > -1; i--) {
      res += pow26 * (s.charAt(i) - 64);
      pow26 *= 26;
    }
    return res;
  }

  public static void main(String[] args) {
    String s = "AAA";
    int res = titleToNumber(s);
    System.out.println("Str : " + s + "\nCol : " + res);
  }
}
