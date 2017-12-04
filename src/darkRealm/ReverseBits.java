package darkRealm;

import java.util.HashMap;
import java.util.Map;

public class ReverseBits {



/*
   #190. Reverse Bits
  Reverse bits of a given 32 bits unsigned integer.
  For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192
  (represented in binary as 00111001011110000010100101000000).
  Follow up:
  If this function is called many times, how would you optimize it?
  Related problem: Reverse Integer
*/




  final static Map<Byte, Integer> cache = new HashMap<>();

  public static int reverseBits(int n) {
    byte[] bytes = new byte[4];
    for (int i = 0; i < 4; i++)
      bytes[i] = (byte) ((n >>> 8 * i) & 0xFF);

    int res = 0;
    for (int i = 0; i < 4; i++) {
      res += reverseBytes(bytes[i]);
      if (i < 3)
        res = res << 8;
    }
    return res;
  }

  private static int reverseBytes(byte b) {
    if (cache.containsKey(b)) return cache.get(b);
    int val = 0;
    for (int i = 0; i < 8; i++) {
      val += ((b >>> i) & 1);
      if (i < 7) {
        val = val << 1;
      }
    }
    cache.put(b, val);
    return val;
  }


  public static void main(String[] args) {

  }
}
