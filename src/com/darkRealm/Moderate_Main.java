package com.darkRealm;

import com.darkRealm.Moderate.Moderate;

import java.util.Arrays;

/**
 * Created by Jayam on 1/23/2017.
 */
public class Moderate_Main {

  public static void testNumberSwapper() {
    Moderate.numberSwapper(7, 3);
  }

  public static void testWordFrequency() {
    String[] book = new String[]{"this", "is", "some", "book", "this"};
    int count = Moderate.wordFrequency(book, "this");
    System.out.println("book count : " + count);
  }

  public static void testTicTacWin() {
    char game[][] = new char[][]{
        {'X', 'O', 'O', 'X'},
        {'O', 'X', 'O', 'X'},
        {'X', 'O', 'O', 'X'},
        {'X', 'O', 'X', 'X'}
    };

    boolean res = Moderate.ticTacWin(game, 4);
    System.out.println(" Win " + res);
  }

  public static void testFactorialZeroes() {
    int n = 25;
    int noZeros = Moderate.factorialZeros(n);
    System.out.println(" n : " + n + "   trailing zeroes : " + noZeros);

    noZeros = Moderate.factorialZerosLeaner(n);
    System.out.println(" n : " + n + "   trailing zeroes : " + noZeros);
  }

  public static void testSmallestDifference() {
//    int [] arr = new int[]{3,1,15,11,4,8};
//    int [] brr = new int[]{23,127,235,19,2};
    int[] arr = new int[]{3, 1, 15, 11, 2};
    int[] brr = new int[]{23, 127, 235, 19, 8};
    int[] res = Moderate.smallestDifference(arr, brr);
    System.out.println("MinDIff : " + Arrays.toString(res));
  }

  public static void testNumberMax() {
//    int res = Moderate.numberMax(2, 4);
//    int res = Moderate.numberMax(3, 1);
//    int res = Moderate.numberMax(0, 0);
    int res = Moderate.numberMax(Integer.MIN_VALUE, -2);
    int xor = 0 ^ 1;
    System.out.println(" Max : " + res);
  }

  public static void testEnglishInt() {
    int n = -123456789;
//    String res = Moderate.englishInt(12);
    String res = Moderate.englishInt(n);
    System.out.println("NO : " + n + "   english : " + res);
  }

  public static void testSubstract() {
    int a = -2;
    int b = -2;
    int res = Moderate.substractNumbers(a, b);
    System.out.println("a : " + a + " b " + b + " Substract  a-b = " + res);
  }

  public static void testMulitply() {
    int a = -9;
    int b = 10;
    int res = Moderate.multiplyNumbers(a, b);
    System.out.println("a : " + a + " b " + b + " Product a*b = " + res);
  }

  public static void testDivide() {
    int a = -7;
    int b = -3;
    int res = Moderate.divideNumbers(a, b);
    System.out.println("a : " + a + " b " + b + " Divide a/b = " + res);
  }

  public static void testPondSizes() {
    int[][] world = new int[][]{
        {0, 2, 1, 0},
        {0, 1, 0, 1},
        {1, 1, 0, 1},
        {0, 1, 0, 1}
    };
    int waterValue = 0;
    Integer[] res = Moderate.pondSizes(world, waterValue);
    System.out.println("Pond Sizes : " + Arrays.toString(res));
  }

  public static void testLSCS() {
    int[] arr = new int[]{2, -8, 3, -2, 4, -10};
//    int[] arr = new int[]{2, -3, 4, -1, -2, 1, 5, -3};
//    int[] arr = new int[]{1, 3, -5, 4, 6, -1, 2, -7, 13, -3};
//    int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
//    int[] arr = new int[]{1, 2, -3, -4, 2, 7, -2, 3};
//    int[] arr = new int[]{ -2, -3, -4, -2, -7, -2, -3,-11 };

    int maxSum = Moderate.largestSumContiguousSubArray(arr);
    System.out.println("Max Sum : " + maxSum + "   Array : " + Arrays.toString(arr));
  }

  public static void testPatternMatching() {
//    String val = "catgocatgo";
//    String pattern = "abab";
    String val = "catgocatgocat";
    String pattern = "ababa";
    boolean res = Moderate.patternMatch(val, pattern);
    System.out.println("Val {" + val + "} is pattern of type [" + pattern + "] res - " + res);
  }

  public static void testOldKeyboard() {
//    int n = 8733;
//    int n = 228;
    int n = 364;
    String[] res = Moderate.OldCellPhoneKeyBoardT9(n);
    System.out.println("N : " + n + "   Sugg : " + Arrays.toString(res));
  }

  public static void testMaxPopulationYear() {
    int[] births = new int[]{1908, 1919, 1912, 1930, 1905, 1903};
    int[] deaths = new int[]{1909, 1922, 1920, 1945, 1910, 1912};
//    int[] births = new int[]{2000, 2000};
//    int[] deaths = new int[]{2000, 2000};
//    int maxPopYear = Moderate.getMaxPopulationYear(births, deaths);
    int maxPopYear = Moderate.getMaxPopulationYearLeaner(births, deaths);
    System.out.println(" max Pop year " + maxPopYear);
  }

  public static void testSumSwap() {
//    int[] arr = new int[]{4, 1, 2, 1, 1, 2};
//    int[] brr = new int[]{3, 6, 3, 3};

//    int[] arr = new int[]{6, 3, 2, 2, 1};
//    int[] brr = new int[]{3, 1, 8, 2, 4};

    int[] brr = new int[]{1, 2, 3, 4, 5};
    int[] arr = new int[]{1, 3, 4, 10, 11};

    int[] res = Moderate.getSumSwapPair(arr, brr);
    System.out.println(Arrays.toString(res));
  }
}