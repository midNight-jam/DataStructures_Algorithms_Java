package darkRealm;

public class ExcelSheetColumnTitle {

//  168. Excel Sheet Column Title
//  Given a positive integer, return its corresponding column title as appear in an Excel sheet.
//  For example:
//      1 -> A
//    2 -> B
//    3 -> C
//    ...
//        26 -> Z
//    27 -> AA
//    28 -> AB
  public static String convertToTitle(int n) {
    if (n < 1) return "";
    int d;
    char c;
    StringBuilder res = new StringBuilder();
    while (n > 0) {
      d = ((n - 1) % 26);
      c = (char) ('A' + d);
      res.append(c);
      n = (n - 1) / 26;
    }
    return res.reverse().toString();
  }

  public static void main(String[] args) {
    int n = 52;
    String s = convertToTitle(n);
    System.out.println("N : " + n + "\nS : " + s);
  }
}
