package darkRealm;

public class IntegerToEnglishWords {

//  #273. Integer to English Words
//  Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
//  For example,
//    123 -> "One Hundred Twenty Three"
//    12345 -> "Twelve Thousand Three Hundred Forty Five"
//    1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

  static String[] lt20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
      "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
  static String[] tens = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
  static String[] hundreds = new String[]{"", "Thousand", "Million", "Billion"};

  public static String numberToWords(int num) {
    if (num == 0) return "Zero";
    num = Math.abs(num);
    String res = "";
    int i = 0;
    while (num > 0) {
      int last3 = num % 1000;
      if (last3 != 0)
        res = helper(last3) + hundreds[i] + " " + res;

      num = num / 1000;
      i++;

    }
    return res.trim();
  }

  public static String helper(int n) {
    if (n == 0) return "";
    else if (n < 20) return lt20[n] + " ";
    else if (n < 100) return tens[n / 10] + " " + helper(n % 10);
    else return lt20[n / 100] + " Hundred " + helper(n % 100);
  }

  public static void main(String[] args) {
//    int num = -1856912345;
    int num = 1000000;
    String res = numberToWords(num);
    System.out.println("N : " + num);
    System.out.println("S : " + res);
  }
}