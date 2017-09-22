package darkRealm;

public class ExcelSheetColumnTitle {

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
    StringBuffer sbr = new StringBuffer();
    while (n > 0) {
      n--;
      sbr.append((char) ('A' + (n % 26)));
      n = n / 26;
    }
    return sbr.reverse().toString();
  }

  public static void main(String[] args) {
    int n = 52;
    String s = convertToTitle(n);
    System.out.println("N : " + n + "\nS : " + s);
  }
}
