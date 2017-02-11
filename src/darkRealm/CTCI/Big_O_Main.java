package darkRealm.CTCI;

import darkRealm.CTCI.BigO.*;

/**
 * Created by Jayam on 10/2/2016.
 */
public class Big_O_Main {


    private static void arrayList(){
        MyArrayList arrayList = new MyArrayList(2);
        arrayList.add(11);
        arrayList.add(22);
        arrayList.add(33);
    }

    private static void doBitwise() {
//        BitsUtil.doBitwiseAnd(1, 3);
//        BitsUtil.doBitwiseOr(1, 4);
//        System.out.println("is even & 1 " + BitsUtil.isEven(31));
//        System.out.println("is even shift  " + BitsUtil.isEven_withShift(32));
//        int[] arr = new int[]{5, 3, 7, 9, 3, 3, 1, 2, 9, 4, 5, 7, 4, 1, 2, 3, 3, 2, 2};
//        int res = ArrayUtil.findNoWhichIsOddTimesInRepeatingNos(arr);
//        System.out.println(" Odd no is : " + res);
//        System.out.println(" -2 : " + (~2));
//        System.out.println(" array sum odd or even " + ArrayUtil.checkArraySumOddEven(new int[]{7, 4, 3, 1, 4}));
//        BitsUtil.parityCheck(7);
//        BitsUtil.getBitsString(9);
//        System.out.println(" Left most bit for 9 " + BitsUtil.getLeftMost_1_Bit(9));
//        System.out.println(" Right most bit for 9 " + BitsUtil.getRightMost_1_Bit(9));
//        System.out.println(" Bits count in 10 "+ BitsUtil.getBitsCount(10));
//        System.out.println(" Is a power of 2 "+ BitsUtil.isPowerOfTwo(0));
//        BitsUtil.parityCheck(5);
//        System.out.println(" kth Bit is set ? "+BitsUtil.isKthBitSet(9,4));
//        System.out.println(" kth Bit is set ? "+BitsUtil.isKthBitSet(4,3));
//        System.out.println(" kth Bit is set ? "+BitsUtil.isKthBitSet(5,0));
//        System.out.println(" no shofting negative direction ? " + (5 << -1));
//        System.out.println(" Is multiple of 3  " + BitsUtil.isMultipleOf3(9));
        BitsUtil.printPowerSet(new int[]{1, 2, 3});
    }

    private static void arrayWindowMax() {
        int[] arr = new int[]{5, 3, 1, 6, 7, 9, 8, 2};
        String result = ArrayUtil.maxInWindow(new int[]{7, 6, 3, 4, 5}, 3);
        System.out.println(result);
    }

    public static void math() {
        long r = MathUtil.greatestCommonDivisorIT(12, 3);
        System.out.println("gdcIT " + r);
        r = MathUtil.greatestCommonDivisorRC(12, 7);
        System.out.println("gdcRC " + r);
    }

    public static void array() {
        int[] arr = new int[]{11, 22, 33, 44, 55, 66, 77};
        ArrayUtil.rotateBySome(arr, 1);
        for (int i :
                arr) {
            System.out.print("  " + i);

        }

        System.out.println("");

        int[] brr = new int[]{0, 1, 2, 0, 3};
        ArrayUtil.moveZeroes(brr);

        for (int i :
                brr) {
            System.out.print("  " + i);

        }
    }

    public static void arrayNextBigger() {
        ArrayUtil arrayUtil = new ArrayUtil();
        int[] result;
        result = arrayUtil.nextBigger_usingPair(new int[]{5, 6, 3, 2, 7, 12});

        for (int i = 0; i < result.length; i++) {
            System.out.print(" " + result[i]);
        }
        result = arrayUtil.nextBigger_usingPair(new int[]{1, 10, 11, 3, 9, 2, 1});

        System.out.println();

        for (int i = 0; i < result.length; i++) {
            System.out.print(" " + result[i]);
        }

        result = arrayUtil.nextBigger_usingPair(new int[]{13, 7, 6, 12});

        System.out.println();

        for (int i = 0; i < result.length; i++) {
            System.out.print(" " + result[i]);
        }
    }

    public static void arrayIntersection() {
//        int[] arr = new int[]{2, 1, 3, 7, 8, 4, 6, 9, 5, 10};
//        int[] brr = new int[]{11, 2, 33, 4, 55, 6, 77, 88, 9, 10};
//        int[] arr = new int[]{4,7,9,7,6,7};
//        int[] brr = new int[]{5,0,0,6,1,6,2,2,4};
        int[] arr = new int[]{1};
        int[] brr = new int[]{1, 1};

        long start, end;
        start = System.currentTimeMillis();
        int[] interSection = ArrayUtil.intersection(arr, brr);
        end = System.currentTimeMillis();
        for (int i = 0; i < interSection.length; i++) {
            System.out.print(" " + interSection[i]);
        }
        System.out.println("\ntime(ms) - " + (end - start));
    }

    public static void stringUtil() {
        StringUtil.permutation("abcd");
        System.out.print(MathUtil.nThFibonaciNumber(18));
    }

    public static void mergeSort() {
        int[] arr2 = new int[]{7, 2, 3, 1, 58, 43, 51, 84, 63, 16, 8, 9, 79, 2, 10, 13, 54, 86, 4};
        long start, end;
        start = System.nanoTime();
        arr2 = MergeSort.mergeSort(arr2);
        end = System.nanoTime();
//        System.out.println(start + " - start");
//        System.out.println(end + " - end");
        for (int i :
                arr2) {
            System.out.println(i);
        }
        System.out.println("time(ns) - " + (end - start));

    }

    public static void quickSort() {
        int[] arr2 = new int[]{7, 2, 3, 1, 58, 43, 51, 84, 63, 16, 8, 9, 79, 2, 10, 13, 54, 86, 4};
        long start, end;
        start = System.nanoTime();
        arr2 = QuickSort.doQuickSort(arr2);
        end = System.nanoTime();
        for (int i :
                arr2) {
            System.out.println(i);
        }
        System.out.println("time(ns) - " + (end - start));

    }

    private static void printArray(int[] arr) {
        for (int i :
                arr) {
            System.out.println(" " + i);
        }
    }

    private static void maxDistinctSubString() {
//        String s =StringUtil.maxDistinctSubString("Abcded");
//       String s =StringUtil.maxDistinctSubString("Cdekdfc");
//       String s =StringUtil.maxDistinctSubString("abbab");
//        String s =StringUtil.maxDistinctSubString("Abababab");
//        String s =StringUtil.maxDistinctSubString("Abcdedcd");
//        String s =StringUtil.maxDistinctSubString("Abcdedefgckf");
//        String s =StringUtil.maxDistinctSubString("Aaaaa");
//        String s =StringUtil.maxDistinctSubString("Aiklmcdefdg");
        String s = StringUtil.maxDistinctSubString("Abcdedc");


        System.out.println(" String : " + s);
    }

    private static void allPermutations() {
        String s = "cacadb";
        StringUtil.printAllFoundPermutations("ccac", s);
    }

    private static void primeNTH() {
        long start = System.currentTimeMillis();
        int res = MathUtil.nthPrimeNumber(5);
        System.out.println(" 100000th prime is : " + res);
        System.out.println(" time ms : " + (System.currentTimeMillis() - start));
    }

    private static void pairsWithSumK() {
        int[] arr = new int[]{4, 2, 1, 5, 3, 0, 8, 7, 6};
        ArrayUtil.printPairsWithSumK(arr, 0);
    }

    private static void arrayUtil(){
        int[] arr = new int[]{1,2,3,4,7};
        int[] brr = new int[]{0,5,6,9};
        int res = ArrayUtil.getKthSmallestInUnionOfTwoArrays(arr,brr,2);
        System.out.println("k samllest in unoin "+res);
    }
}
