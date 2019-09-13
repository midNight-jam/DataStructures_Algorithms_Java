package darkRealm;

public class ImplementRand10UsingRand7 {


//  470. Implement Rand10() Using Rand7()
//  Given a function rand7 which generates a uniform random integer in the range 1 to 7, write a function rand10 which
//  generates a uniform random integer in the range 1 to 10.
//
//  Do NOT use system's Math.random().
//  Example 1:
//
//  Input: 1
//  Output: [7]
//
//  Example 2:
//
//  Input: 2
//  Output: [8,4]
//  Example 3:
//
//  Input: 3
//  Output: [8,1,10]
//
//  Note:
//  rand7 is predefined.
//  Each testcase has one argument: n, the number of times that rand10 is called.
//
//  Follow up:
//  What is the expected value for the number of calls to rand7() function?
//  Could you minimize the number of calls to rand7()?

  private int rand7() {
    // body addded just for compilation purpose
    return 0;
  }


  /*
   * Generalizing this problem to generate any randM() using given randN() where M > N
   * #0 Go from N -> X  :: i.e Generate randX() from randN(), such that X >= M
   *                       for eg : from 7 -> 10 generate randX = rand49
   * #1 Go from X -> M' :: i.e Generate randM'() from randX(), such that M' is the largest multiple of M that is smaller than X
   *                           & from rand49 generate rand40 which is multiple of 10 but smaller than 49
   *#2 Go from M' -> M  :: i.e Genenrate randM() from randM/() this step just require mod operation (% m)
   *                         from rand40 % 10 will give us rand10
   *
   * Another example of generating rand11() from rand 3
   * #0 generate rand27() == rand3() -> rand9() & then rand9() -> rand 27, because 27 >= 11
   * #1 genenrate rand22, because rand 22 is mulitple of 11 & smaller then 27
   * #2 rand22() %11 gives us rand11
   *
   * To viuslazie imagine we are creating a matrix of 7x7 = 49 & then at any point starting from end (49), if we are at a
   * index that is <= 40 we know that all indexes below this are evenly distributed thus we can easily calculate by
   * doing i % 10 where i is any index <= 40
   * */

  public int rand10() {
    int index = 49;//Integer.MAX_VALUE;// doesnt matter any value bigger than 40
    int row, col;
    int mDash = 40; //because this is the closest smaller multiple of 10 that we can achive using rand7() 7 * 7 = 49
    // imagine a matrix of 7x7, all the values are filled from 1-49,
    // now we just have to stop at a point on which the index is <= 40, because at that point all indexes below&equal to 40
    // are evenly distributed for getting rand10, which would be index%10 + 1 (becuase the ask is to get range from 1-10)
    while (index >= mDash) {
      row = 7 * (rand7() - 1);
      col = rand7() - 1;
      index = row + col;
    }

    int res = (index % 10) + 1;

    return res;

  }

  public static void main(String[] args) {


  }
}
