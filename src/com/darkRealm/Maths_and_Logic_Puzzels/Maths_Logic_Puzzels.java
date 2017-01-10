package com.darkRealm.Maths_and_Logic_Puzzels;

import java.util.Random;

/**
 * Created by Jayam on 1/9/2017.
 */
public class Maths_Logic_Puzzels {
  /*[Prob 6.8]
  *   Q) The Egg Drop Problem
  *   A) have to balance out  the attempts from 2 eggs
  *   Thus instead of incrementing the floors by 10 every time we increment by 10, 9 , 8 ..  so on and if the egg drops
  *   from there we will increment by 1 the second egg.
  * */
  public static int EggDropProblem() {
    int floors = 100;
    eggAttemptCount = 0;
    Random random = new Random();
//    int breakingFloor = random.nextInt(floors + 1);
    int breakingFloor = 94;
    int interval = 14;
    int previousFloor = 0;
    int egg1, egg2;
    egg1 = interval;
    boolean eggBreaks = false;
    while (egg1 < floors) {
      eggBreaks = drop(breakingFloor, egg1);
      if (eggBreaks) {
        break;
      }
      interval--;
      previousFloor = egg1;
      egg1 += interval;
    }
    egg2 = previousFloor + 1;
    while (egg2 < egg1 && egg2 < floors) {
      eggBreaks = drop(breakingFloor, egg2);
      if (eggBreaks) {
        break;
      }
      egg2++;
    }
    System.out.println("Egg Break Floor : " + egg2+" Attempts : "+eggAttemptCount);
    return egg2 > floors ? -1 : egg2;
  }
  static int eggAttemptCount = 0;
  private static boolean drop(int breakFloor, int eggFloor) {
    eggAttemptCount++;
    return eggFloor >= breakFloor ? true : false;
  }
}