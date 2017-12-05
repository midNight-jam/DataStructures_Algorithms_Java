package darkRealm;

public class StringToInteger {

  /*  #8  String to Integer
  * Implement stringToInteger to convert a string to an integer.
  * */
  public static int stringToInteger(String str) {
    if (str == null || str.length() == 0) return 0;
    int sign = 1;
    int index = 0;
    int result = 0;
    while (str.charAt(index) == ' ' && index < str.length())
      index++;
    if (str.charAt(index) == '+' || str.charAt(index) == '-') {
      sign = str.charAt(index)=='-'?-1 : 1;
      index++;
    }

    int digit = 0;
    while (index < str.length()){
      digit = str.charAt(index) - '0';
      if(digit < 0 || digit > 9) break;

      if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < digit ))
        return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
      result = result * 10 + digit;
      index++;
    }
    return result * sign;
  }

  public static void main(String[] args) {
//    String str = "+123";
//    String str = "+1";
//    String str = "  -0012a42";
//    String str = Integer.MAX_VALUE+"";
//    String str = "1534236469";
//    String str = "-2147483648";
//    String str = "-2147483649";
//    String str = "2147483648";
//    String str = "    +11191657170";
//    String str = "";
//    String str = "-2147483647";
    String str = "      -11919730356x";


    int res = stringToInteger(str);
    System.out.println(" Str : " + str + "   res : " + (res));
  }
}
