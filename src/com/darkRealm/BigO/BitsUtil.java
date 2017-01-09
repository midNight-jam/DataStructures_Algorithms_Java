package com.darkRealm.BigO;

import java.util.ArrayList;

/**
 * Created by Jayam on 9/17/2016.
 */
public class BitsUtil {
  public static void doBitwiseAnd(int a, int b) {
    System.out.println("Bitwise and  ==  " + (a & b));
  }

  public static void doBitwiseOr(int a, int b) {
    System.out.println("Bitwise OR  ==  " + (a | b));
  }

  public static boolean isEven(int a) {
    return (a & 1) == 1 ? false : true;
  }
    /* this method is stupidity or mine, how can when ANDED with 0, any no will result it 1.
    The output will always be 0. Regardless of whether the no is odd or even,  because we have anded with 0.
     Thus I am renaming the above method, & keep this below method commented, to remind me why this method wont work
    public static boolean isEvenUsingAndWith_0(int a){
        return (a & 0 ) == 0 ? true :false;
    }
     */

  public static boolean isEven_withShift(int a) {
        /* a number say 5 [101] when left shifted once will become [010], this when left shifted to right once
        * will become [100], now this no is not equal to original no. WE can use this propert to check if a no is even
        * or not. For even lets say 6 [110] when left shifted once will become [011], this when left shifted to right once
        * will become [110], which is equal to the original no. thats how this method works */
    int temp = (a >> 1) << 1;
    return temp == a ? true : false;
  }

  public static void parityCheck(int n) {
    int b = 0;
    int s = 0;
    while (n != 0) {
      b = n & 1;
      s = s ^ b;
      n = n >> 1;
    }
    if (s == 1)
      System.out.println("Odd [1]bits ");
    else
      System.out.println("Even [1] bits ");
  }

  public static int getBitsCount(int n) {
    int count = 0;
    while (n != 0) {
      n = n >> 1;
      count++;
    }
    return count;
  }

  public static String getBitsString(int n) {
    int temp = n;
    int b;
    String bits = "";
    while (temp != 0) {
      b = temp & 1;
      temp = temp >> 1;
      bits = b + bits;
    }
    System.out.println(" n = " + n + " Bits are : " + bits);
    return bits;
  }

  public static int getLeftMost_1_Bit(int n) {
    int temp = n;
    int b = 0;
    while (temp != 0) {
      b++;
      temp = temp >> 1;
    }
    return b;
  }

  public static int getRightMost_1_Bit(int n) {
    int b = 1;
    int count = 0;
    for (; n != 0; n = n >> 1) {
      b = n & 1;
      count++;
      if (b == 1) break;
    }
    return count;
  }

  public static boolean isPowerOfTwo(int n) {
    if (n > 0) {
      int b = 0;
      while (n != 0) {
        b = n & 1;
        n = n >> 1;
        if (b == 1)
          break;
      }
      if (n == 0)
        return true;
    }
    return false;
  }

  public static boolean isKthBitSet(int n, int k) {
    n = n >> (k - 1);
    n = n & 1;
    return n == 1 ? true : false;
  }

  public static String binaryRepresentation(int n) {
    String binString = "";
    while (n != 0) {
      binString = (n & 1) + binString;
      n = n >> 1;
    }
    return binString;
  }

  public static String hexaDecimalRepresentation(int n) {
    String hexString = "";
    char[] hexChars = new char[]{'x', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    int index;
    while (n != 0) {
      index = n % 16;
      hexString = hexChars[index - 1] + hexString;
      n = n >> 4;
    }
    return hexString;
  }

  public static String changeBase(int n, int base) {
    if (base != 2 || base != 10 || base != 16) {
      return "";
    }
    String baseString = "";
    while (n != 0) {

    }
    return baseString;
  }

  /**
   * My logic was not optimal but still putting it. first initialize gerated set with empty set{}
   * then for each number in set multiply with each number in the generated set & add the result to the generated set
   * given set [1,2,3]
   * generate=d set on i = 0 : {}
   * now mulitply 1 with all elements of generated set * add again to generated set
   * so 1 *{} = {1} , now add this result to generated set, so it becomes {},{1}
   * same goes for 2 :  2 *{}, 2 *{1} gives {2} & {2,1} generated set : {},{1},{2},{1,2} & so on....
   * Complexity is O(N*2^N)
   */


  //this is the optimal logic present, which is to print the ith number when the ith bit is true.
  //lets say set is [1,2,3] so the size of power set would be 2^3 (size of given set)
  // for i =0 to power set size,  for each ith bit of i which is 1, add the ith number to the set
    /*
    * Set  = [a,b,c]
    power_set_size = pow(2, 3) = 8
    Run for binary counter = 000 to 111

    Value of Counter            Subset
    000                    -> Empty set
    001                    -> a
    011                    -> ab
   100                     -> c
   101                     -> ac
   110                     -> bc
   111                     -> abc
    *
    * */
  public static String printPowerSet(int[] arr) {
    int powerSetSize = (1 << arr.length);
    String powerSet = " [  ";
    String set = "";
    int bi = 0;
    int count = 0;
    int j = 0;
    for (int i = 0; i < powerSetSize; i++) {
      //get bits of i & print the ith element(s) from set
      set = "{ ";
      j = i;
      count = 0;
      while (j != 0) {
        bi = 1 & j;
        count++;
        if (bi == 1) {
          set += arr[count - 1] + " , ";
        }
        j = j >> 1;
      }
      set += " }";
      powerSet += "  " + set + " ,  ";
    }
    powerSet += " ] ";
    System.out.println(" Power set is : " + powerSet);
    return powerSet;
  }

  public static String printSuperSet(int[] arr) {
    StringBuffer string = new StringBuffer();
    int superSetZize = 1 << arr.length;
    int bitmask, j;
    int pos;
    for (int i = 0; i < superSetZize; i++) {
      bitmask = i;
      pos = arr.length - 1;
      string.append(" [ ");
      while (bitmask != 0) {
        if ((bitmask & 1) == 1) {
          string.append(arr[pos] + ", ");
        }
        bitmask >>= 1;
        pos--;
      }
      string.append(" ] ");
    }
    return string.toString();
  }

  /*
  * Get the 1's compliment of the given no
  * Input 50 - Output 13
  * Input 100 - 27
  * @params : i the integer to convert ot 1's compliment
  * @return : 1's compliment of the provided no
  *
  * */
  public int onesCompliment(int i) {
    int bitslen = (int) (Math.log(i) / Math.log(2)) + 1;
    System.out.println("bits - " + Integer.toBinaryString(i));
    System.out.println("negatebits - " + Integer.toBinaryString(~i));
    String bitString = Integer.toBinaryString(~i);

    int index = bitString.length() - bitslen;
    bitString = bitString.substring(index);

    System.out.println("chopped bitString  - " + bitString);
    System.out.println("bitslen - " + bitslen);

    int result = Integer.parseInt(bitString, 2);
    return result;
  }

  /* [Prob 5.1]
  *   Q) Insertion -  Given two 32 Bit nos, N & M, and two bit positions i, j. write a method to insert M into N such
  *   that M starts at bit j and ends at bit i. You can assume that bits j through i have enough space to fit all of M.
  *   Example - N  = 10000000000, M = 10011, i = 2, j = 6
  *   Output : 10001001100
  *   A) I will have to first clear the bits of range j to i. For that I will create a mask that has all 0's in that range
  *     and rest all 1's . Then I will AND N with that mask, this will clear the bits within range j to i. Then I will
  *     push M's bits in N. Below is the algo
  *     1 : To create mask will use two parts a & b. a has zeros in front, b has seros in rear, Anding them both will give
  *     a no which will have 1's in only that range.SO,
  *     a = -1 >>> (32 -j) //have to shift sign bit too via arithmetice shift
  *     OR we can also use negate of 0  to get all the bits 1
  *     [a = ~0] just remember
  *     a = -1 >>> (32 -j) //have to shift sign bit too via arithmetice shift
  *     OR
  *     a = (1 << (j+1)) - 1  // dont have to use arithmetic shift subtracting 1 will give same result
  *     b = -1 << i
  *     mask = a & b
  *     mask = ~ mask // turining 1's to 0's
  *     cleredN = mask & N
  *     output = clearedN | (m<<i)
  * */

  public static void insertionBits(int N, int M, int i, int j) {
    System.out.println("N - " + Integer.toBinaryString(N));
    System.out.println("M - " + Integer.toBinaryString(M));

    int a = (1 << (j + 1)) - 1; // clearing all the bits ahead of j
    System.out.println("a - " + Integer.toBinaryString(a));

    int b = -1 << i;  // clearing all the bits behind of i
    System.out.println("b - " + Integer.toBinaryString(b));

    int mask = ~(a & b); // anding gives no whose only those bits are set between j to i, we will negate it to create a mask
    System.out.println("Mask - " + Integer.toBinaryString(mask));

    int clearedN = mask & N;
    System.out.println("clearedN - " + Integer.toBinaryString(clearedN));

    int output = clearedN | (M << i);
    System.out.println("SandwichedBits - " + Integer.toBinaryString(output));
  }

  /* [Prob 5.2]
  *   Q) Binary To String : Given a real number between 0 and 1 ( eg 0.72) that is passed in as a double, print the
  *   binary representation. If the number cannot be represented accurately in binary with at most 32 characters,
   *   print "ERROR"
   *  A) There are two ways I found of doing this
   *  1 : the divide approach where we keep reducing our divisor by 2 & subtract it from fraction only if fraction is
   *      greater or equal to the divisor.
   *  2 : the multiply approach where we keep multiplying the fraction with 2 & diregard the part which is greater than 1
   *      and continuing this till we have exhausted the number
  * */
  public static String FractionToBinaryString(double fraction) {
    if (fraction > 1 || fraction < 0) {
      return "ERROR";
    }
    StringBuilder bitString = new StringBuilder();
    bitString.append("0.");
    // Iterative method by subtracting
//    double divisor = 1;
//    while (fraction != 0) {
//      divisor = divisor / 2;
//      if (fraction >= divisor) {
//        fraction = fraction - divisor;
//        bitString.append("1");
//      } else {
//        bitString.append("0");
//      }
//      if (bitString.length() > 34) {
//        System.out.println(bitString);
//        return "ERROR";
//      }
//    }
    while (fraction != 0) {
      fraction = fraction * 2;
      if (fraction >= 1) {
        fraction = fraction - 1;
        bitString.append("1");
      } else {
        bitString.append("0");
      }
      if (bitString.length() > 34) {
        System.out.println(bitString);
        return "ERROR";
      }
    }
    return new String(bitString);
  }

  /* [Prob]
  *  Q) Decrease a number by 1 without using any mathematical operation
  *  A) For subtraction we have the logic like
   *      Flip all the bits from left till first 1 is encountered & flip 1 also, inclusive
  * */
  public static int oneShort(int n) {
    // subtract
    int i = 1;
    int ithBitValue = 0;
    int flipValue = 0;
    while ((n & (1 << i - 1)) == 0) {
      ithBitValue = n & (1 << i - 1);
      flipValue = ithBitValue == 0 ? 1 : 0;
      n = updateIthBit(n, i, flipValue);  // flipping all the values till first 1 is encountered
      i++;
    }
    n = updateIthBit(n, i, 0); // flipping the first encountered 1 to zero
    return n;
  }

  /*Q) Increase a number by 1 without using any mathematical operation
  *  A) For Addition
   *      Flip all the bits till first 0 is encountered & flip that 0 also, inclusive
  */
  public static int oneBig(int n) {
    // add
    int i = 1;
    int ithBitValue = (n & (1 << i - 1));
    int flipValue = 0;
    while (ithBitValue != 0) {
      flipValue = ithBitValue == 0 ? 1 : 0;
      n = updateIthBit(n, i, flipValue);  // flipping all the values till first 1 is encountered
      i++;
      ithBitValue = n & (1 << i - 1);
    }
    n = updateIthBit(n, i, 1); // flipping the first encountered 1 to zero
    return n;
  }

  /* A utility method to update the ith Bit of a number to a given value (0 or 1)
  * @params : n the no to update bits of
  * @params : bitNo , the bit to be updated
  * @params : value , the new vlaue of the bit to be updated, 0 or 1
  * */
  public static int updateIthBit(int n, int bitNo, int value) {
    // error checking
    if (bitNo < 1 || value < 0 || value > 1) {
      return Integer.MIN_VALUE;
    }
    System.out.println("Before Updating : " + Integer.toBinaryString(n));
    // first we create a mask & clear the ith bit
    int mask = ~(1 << (bitNo - 1));
    int clearedN = n & mask;
    int updatedN = clearedN | (value << bitNo - 1);
    System.out.println("After Updating  : " + Integer.toBinaryString(updatedN));
    return updatedN;
  }

  /*  [Prob 5.3]
  *   Q) Flip Bit to Win : You have an integer anf you can flip exactly one bit from 0 to 1. Write a method to find the
  *   longesy sequence of 1's you could create
  *   A)  First we have to get the alternating sequence of the bits with their count for example
   *   N = 1743 : 11011001111 (bits) we will get the alternating bit count sequence as
   *            end[  2-1-2-2-4 ] start , from end we will always have count of 1 bits, becuase beyond that the no would
   *            have turned 0 in magnitude, tahts why those bits are not recorded, So after getting this alternating
   *            sequence of bit counts we will now try to merge the 0's that are surrounded by 1's
   *
   *   The algo for merging part is we read from end & read zeros which are sandwhiched
   *   if the zero count is == 1 means only one 0 was surrounde on both sides by 1's. thus we can form a contigiuos
   *   sequence by adding left & right & 1
   *
   *   if the zero count is > 1 means there were more than 1 o's lets say 2 0's at taht part, so we can form a bit
   *   sequnce by adding one to any left or right side as its not gong to be contiguous and take the max.
   *
  *   if the zero count is == 0 that means we have reached the end and we can take any part which is big  left or right
  *   without adding.
  * */
  public static int FlipBitToWin(int n) {
    String bitStr = Integer.toBinaryString(n);
    ArrayList<Integer> altSequence = getAlternatingSequence(n);
    int max = findLongestSequence(altSequence);
    return max;
  }

  // returns a sequence of no of continuos 1 or 0, will always have the last element as count of 1, beause after that the
  // no has turned 0 in magnitude. And the first element will always be the count of 0.
  private static ArrayList<Integer> getAlternatingSequence(int n) {
    int searchingFor = 0;
    int count = 0;
    ArrayList<Integer> sequences = new ArrayList<>();

    while (n != 0) {
      if ((n & 1) != searchingFor) {
        sequences.add(count);
        searchingFor = n & 1;
        count = 0;
      }
      count++;
      n = n >>> 1;  // arihtmetic shift , inclusive of sign Bit
    }
    sequences.add(count);
    return sequences;
  }

  private static int findLongestSequence(ArrayList<Integer> altSequence) {
    int max = 0;
    int zeroCount = 0;
    int leftCount = 0;
    int rightCount = 0;
    int sequenceLen = 0;
    for (int i = altSequence.size() - 2; i >= 0; i = i - 2) {
      leftCount = (i + 1) > altSequence.size() ? 0 : altSequence.get(i + 1); // getting the left part
      rightCount = (i - 1) >= 0 ? altSequence.get(i - 1) : 0; // getting the right part
      zeroCount = altSequence.get(i);
      // was only one 0, thus can connect both left & right parts to create a long consecutive 1 string
      if (zeroCount == 1) {
        sequenceLen = leftCount + 1 + rightCount;
        max = Math.max(max, sequenceLen);
      }
      if (zeroCount == 0) { // No Zeroes, take any side that is longer
        sequenceLen = Math.max(leftCount, rightCount);
        max = Math.max(max, sequenceLen);
      }
      if (zeroCount > 1) {
        sequenceLen = Math.max(leftCount + 1, rightCount + 1); // more than one zeros, add 1 to nay side & take longer one
        max = Math.max(max, sequenceLen);
      }
    }
    return max;
  }

  /* [Prob  5.6]
   *  Q) calculate the no of bits required to flip for a number A to become number B
   *  A) Either,we can compare both no bit by bit from left & record when the bots were diff.
   *  OR
   *    We can XOR them both, XORing will give us 1 bit where both the bits in the number differ
   *    & then coun how many bits in the XOR were 1
   *  */
  public static int coversionEstimate(int m, int n) {
    int travA, travB;
    int diffCount = 0;
//    below aaporcah works but its not very intelligent
//    while (m != 0) {
//      travA = m & 1;
//      travB = n & 1;
//      if (travA != travB) {
//        diffCount++;
//      }
//      m = m >>> 1;
//      n = n >>> 1;
//    }

    // here we can take XOR of botht the nos, this will give us all the bits as 1 where the bits dont match
    int xor = m ^ n;
    while (xor != 0) {
      if ((xor & 1) == 1) {
        diffCount++;
      }
      xor = xor >>> 1;
    }
    return diffCount;
  }

  /*  [Prob 5.4] NextBiggerPart
  *   Q) Next Number : GIven a positive number, print the next smalest and the next largest number that have the same
  *   number of 1 bits in their binary represemtation.
  *   A) Awesome algo by Legendary GAYLE
  *     We have to first find a right most non trailing 0, we will call it P
  *     For ex 13948 : 11011001111100 , the right most non trailing 0 is at 8th bit (7 if begins from 0) P = 7
  *     First we will flip the Pth bit from 0 to 1. in this way we have added an extra 1 to bit sequence , remember this!!
  *     Now we have to count the number of 0's (zeroCount) and number of 1's (oneCount) that are to right of the P and
  *     while doing so we will clear all the bits to the right of P.
  *     Now, after the right of P is completley cleared we are going to push back (oneCount-1) 1's to the right of P.
  *     Why (oneCount-1) beacuse we have already added an extra 1 while flipping the Pth bit, thus we have to compensate
  *     to maintain the equal no if 1's in bit sequence. thats why we will push one less 1.
  *     After pushing those 1's, and we are ready to return.
  * */
  public static int nextBiggerWithSame_1_Bits(int n) {
    //Get the rightmost non trailing 0
    int number = n;
    String bitStr = Integer.toBinaryString(number);
    String zitStr = Integer.toBinaryString(n);  // debug purpose

    // first skip the rightmost 0's and count the number of 0's
    int zeroCount = 0;
    while ((n & 1) == 0) {
      n = n >>> 1;
      zeroCount++;
    }
    zitStr = Integer.toBinaryString(n);

    // Now skip the rightmost 1's and count the number of 1's
    int oneCount = 0;
    while ((n & 1) == 1) {
      n = n >>> 1;
      oneCount++;
    }

    zitStr = Integer.toBinaryString(n);

    int p = oneCount + zeroCount;
    // now flip this p+1 th bit to 1
    int flip = 1 << p;
    String flipStr = Integer.toBinaryString(flip);// debug purpose

    number = number | flip;
    bitStr = Integer.toBinaryString(number);

    // now have to clear all the bits to the right of p;
    int mask = ~((1 << p) - 1); // all zeros after p all 1's from p onwards
    String maskStr = Integer.toBinaryString(mask); // debug purpose

    number = number & mask;  // clearing all the bits beyond p
    bitStr = Integer.toBinaryString(number);

    // now we have to add oneCOunt -1 1's to the right side of p, Why oneCount - 1 , beacuse we have already add one 1
    // at p, thus inorder to maintaint sam nos of 1 to right we will add a 1 less
    int addingOnesBack = (1 << oneCount - 1) - 1;
    String addingStr = Integer.toBinaryString(addingOnesBack); // debug purpose

    // now we can OR it with the n to add these 1's back
    number = number | addingOnesBack;
    bitStr = Integer.toBinaryString(number);

    // ready to return our nearest increased number with equal no of 1 bits
    return number;
  }

  /*  [Prob 5.4] NextSmallerPart
  *   Q) Next Number : GIven a positive number, print the next smalest and the next largest number that have the same
  *   number of 1 bits in their binary represemtation.
  *   A) The approach very similar to nextBiggerPart method above, with a slight change, here we will look for right most
  *   non trailing 1 instead of 0.
  *
  *     We have to first find a right most non trailing 1, we will call it P
  *     For ex 10115 : 10011110000011, the right most non trailing 1 is at 8th bit (7 if begins from 0) P = 7
  *     First we will flip the Pth bit from 1 to 0. in this way we have added an extra 0 to bit sequence , remember this!!
  *     Now we have to count the number of 0's (zeroCount) and number of 1's (oneCount) that are to right of the P and
  *     while doing so we will clear all the bits to the right of P.
  *     Now, after the right of P is completley cleared we are going to push back (oneCount+1) 1's to the right of P.
  *     Why (oneCount+1) beacuse we have removed a 1 while flipping the Pth bit, thus we have to compensate
  *     to maintain the equal no if 1's in bit sequence. thats why we will push one extra 1.
  *     After pushing those 1's, and we are ready to return.
  * */
  public static int nextSmallerWithSame_1_Bits(int n) {
    int number = n;
    String bitStr = Integer.toBinaryString(number);
    String zitStr = Integer.toBinaryString(number);

    int zeroCount = 0;
    int oneCount = 0;

    while ((n & 1) == 1) {
      n = n >>> 1;
      oneCount++;
    }
    zitStr = Integer.toBinaryString(n);

    while ((n & 1) == 0) {
      n = n >>> 1;
      zeroCount++;
    }
    zitStr = Integer.toBinaryString(n);

    int p = zeroCount + oneCount;
    // flipping the pth bit from 1 to 0
    int tempMAsk = 1 << p;
    tempMAsk = ~tempMAsk;
    String tempStr = Integer.toBinaryString(tempMAsk);

    number = number & tempMAsk;
    bitStr = Integer.toBinaryString(number);

    // now we will clear all the bits to the right of the P th bit.
    int mask = ~((1 << p) - 1);
    String maskStr = Integer.toBinaryString(mask);

    number = number & mask;
    bitStr = Integer.toBinaryString(number);

    // now we will push back the
    int addOnesBack = 1 << oneCount + 1;
    addOnesBack = (addOnesBack - 1);
    String addStr = Integer.toBinaryString(addOnesBack);
    addOnesBack = addOnesBack << zeroCount - 1;
    addStr = Integer.toBinaryString(addOnesBack);

    number = number | addOnesBack;
    bitStr = Integer.toBinaryString(number);
    return number;
  }

  /*  [Prob 5.7]
  *   Q) PairWise Swap: Write a program ti swap odd and even bits in an integer with as few instructions as possible
  *     EG:  bit 0 & bit 1 are swapped , bit 2 & bit 3 are swapped
  * A) will shift odd bits right and Even bits left and OR them both to have a bits swapped number
  *     To get the odd & even Bits will a mask
  *     0xaaaaaaaa  - mask will give all the odd bits
  *     0x55555555  - mask will give all the even bits
  */
  public static void swapPairOfBits(int number) {
    System.out.println(Integer.toBinaryString(number));
    int oddBits = number & 0xaaaaaaaa;
    int evenBits = number & 0x55555555;
    int oddBitsShiftedRight = oddBits >>> 1;
    int evenBitsShiftedLeft = evenBits << 1;
    int res = oddBitsShiftedRight | evenBitsShiftedLeft;
    System.out.println(Integer.toBinaryString(res));
  }
}
