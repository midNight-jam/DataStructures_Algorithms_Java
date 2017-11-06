package darkRealm;

import java.util.Arrays;

public class UTF_8Validation {

//  #393. UTF-8 Validation
//  A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:
//  For 1-byte character, the first bit is a 0, followed by its unicode code.
//  For n-bytes character, the first n-bits are all one's, the n+1 bit is 0, followed by n-1 bytes with most significant 2 bits being 10.
//  This is how the UTF-8 encoding would work:
//    Char. number range  |        UTF-8 octet sequence
//      (hexadecimal)    |              (binary)
//   --------------------+---------------------------------------------
//   0000 0000-0000 007F | 0xxxxxxx
//   0000 0080-0000 07FF | 110xxxxx 10xxxxxx
//   0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
//   0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
//  Given an array of integers representing the data, return whether it is a valid utf-8 encoding.
//      Note:
//  The input is an array of integers. Only the least significant 8 bits of each integer is used to store the data. This means each integer represents only 1 byte of data.
//
//      Example 1:
//
//  data = [197, 130, 1], which represents the octet sequence: 11000101 10000010 00000001.
//
//  Return true.
//  It is a valid utf-8 encoding for a 2-bytes character followed by a 1-byte character.
//  Example 2:
//
//  data = [235, 140, 4], which represented the octet sequence: 11101011 10001100 00000100.
//
//  Return false.
//  The first 3 bits are all one's and the 4th bit is 0 means it is a 3-bytes character.
//  The next byte is a continuation byte which starts with 10 and that's correct.
//  But the second continuation byte does not start with 10, so it is invalid.


  public static boolean validUtf8(int[] data) {
    if (data == null || data.length < 1) return false;
    // Intuition here is :: as per the question if after shifting the number it matches the given pattern of starting bits
    // we keep the count for it, which is one less then the number of 1's left after shifting, and when we get the number
    // that starts with patter 10XXXXXXX we reduce the count. If the nos are valid the count at end will be 0
    // for Pattern  110XXXXX -- why shift 5 time & use 6 --- because after shifting 5 times the number shoud match 110
    // which is 6
    // for Pattern  1110XXXX -- why shift 4 time & use 14 --- because after shifting 4 times the number shoud match 1110
    // which is 14
    // for Pattern  11110XXX -- why shift 3 time & use 30 --- because after shifting 3 times the number shoud match 11110
    // which is 30
    // for Pattern  0XXXXXXX -- why shift 7 time & use 0 --- because after shifting 7 times the number shoud match 0
    // which is 0
    int oneCount = 0;
    for (int n : data) {
      if (oneCount == 0) {
        if (n >> 5 == 6) oneCount = 1;// (2 - 1)
        else if (n >> 4 == 14) oneCount = 2; // (3 - 1)
        else if (n >> 3 == 30) oneCount = 3; // (4 -1)
        else if (n >> 7 != 0) return false; // (not starting with 0)
      } else {
        if (n >> 6 != 2) return false;
        oneCount--;
      }
    }
    return oneCount == 0;
  }

  public static void main(String[] args) {
//    int[] data = new int[]{197, 130, 1};
    int[] data = new int[]{235, 140, 4};
    boolean res = validUtf8(data);
    System.out.println(Arrays.toString(data));
    System.out.println("V : " + res);
  }
}
