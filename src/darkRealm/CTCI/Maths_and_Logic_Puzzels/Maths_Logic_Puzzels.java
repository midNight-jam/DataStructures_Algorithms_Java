package darkRealm.CTCI.Maths_and_Logic_Puzzels;

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
    System.out.println("Egg Break Floor : " + egg2 + " Attempts : " + eggAttemptCount);
    return egg2 > floors ? -1 : egg2;
  }

  static int eggAttemptCount = 0;

  private static boolean drop(int breakFloor, int eggFloor) {
    eggAttemptCount++;
    return eggFloor >= breakFloor ? true : false;
  }

  /* [Prob 6.10]
  *   Q) Poison : given 1000 bottles and 10 strpis to test the poison tell in minimum time which bottle is poisoned
  *       a test will take 7 days to complete, thus try to gove the minimum days result
  *   A) This is a very intelligent algo out of the box, even if we divide the 1000 bottles in groups it will take us more
  *   than 7 days to get the poisoned bottle. The algo says that use the bottle number as id. WE will use this id
  *   to get the binary representation of the bottle. And spread this binary represetation actodd the strips we have.
  *   SO after 7 days the only those strips will be negative which have bits set 1 for the poisend bottle id. Rest all
  *   will be +ve, why this works beacuse once a strip is negative it stays like that. in this way we are ORing the bits
  *   thus in the end we will get the result by converting the bits back to the bottle id.
  * */
  public static int findPoisonedBottle(int totalBottles, int randomPoisnedBottle) {
    int poisonedBottle = 0;
    int[] strips = new int[10];
    for (int i = 1; i <= totalBottles; i++) {
      addDropsFromBottleToStrips(i, strips);
    }
    // testStripsDelay Of 7 days
    int bottleNo = testAfter7Days(strips);
    return bottleNo;
  }

  private static int testAfter7Days(int []strips) {
    int res = 0;
    int powerOfTwo = 1;
    for (int i = strips.length - 1; i > -1; i--) {
      if (strips[i] == 1) {
        res += powerOfTwo;
      }
      powerOfTwo = powerOfTwo * 2;
    }
    return res;
  }

  private static void addDropsFromBottleToStrips(int bottleNo, int[] strips) {
    int count = 0;
    while (bottleNo != 0) {
      strips[count] = bottleNo & 1;
      count++;
      bottleNo = bottleNo >> 1;
    }
  }
}