package com.darkRealm;

import com.darkRealm.Moderate.Moderate;

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
}