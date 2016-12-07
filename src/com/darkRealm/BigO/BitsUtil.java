package com.darkRealm.BigO;

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
}