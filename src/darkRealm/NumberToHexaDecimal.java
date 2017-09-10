package darkRealm;

public class NumberToHexaDecimal {

//  Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is
//  used.
//  Note:
//  All letters in hexadecimal (a-f) must be in lowercase.
//  The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero
//  character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
//  The given number is guaranteed to fit within the range of a 32-bit signed integer.
//  You must not use any method provided by the library which converts/formats the number to hex directly.
//  Example 1:
//  Input:
//      26
//  Output:
//      "1a"
//  Example 2:
//  Input:
//      -1
//  Output:
//      "ffffffff"

  public static String numberToHexaDecimal(int n) {
    char[] map = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    String res = "";
    while (n != 0) {
      res = map[(n & 15)] + res;
      n = n >>> 4;
    }
    return res;
  }

  public static void main(String[] args) {
//    int n = 26;
    int n = -1;
    String hex = numberToHexaDecimal(n);
    System.out.println("N : " + n);
    System.out.println("H : " + hex);
  }
}