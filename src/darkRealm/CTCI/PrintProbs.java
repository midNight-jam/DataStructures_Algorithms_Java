package darkRealm.CTCI;

/**
 * Created by Jayam on 2/5/2017.
 */
public class PrintProbs {
  /* left aligned Triangle
   a
   a b
   a b c
   a b c d
   a b c d e*/
  public static void trangle1() {
    for (int i = 0; i < 5; i++) {
      char c = 'a';

      for (int j = 0; j <= i; j++) {
        System.out.print(" " + c);
        c++;
      }
      System.out.println();
    }
  }

  /* Right aligned Triangle
        *
       **
      ***
     ****
    *****
  */
  public static void trangle2() {
    for (int i = 1; i <= 5; i++) {
      char c = '*';
      char s = ' ';
      for (int j = 5; j > i; j--) {
        System.out.print(s);
      }
      for (int k = 0; k < i; k++) {
        System.out.print(c);
      }
      System.out.println("");
    }
  }

  /* Centered Triangle
   *
  ***
 *****
   */

  public static void trangle3() {
    int space = 5;
    int star = 1;
    for (int i = 1; i <= 3; i++) {
      for (int j = 1; j < space; j++) {
        System.out.print(" ");
      }
      for (int k = 1; k <= star; k++) {
        System.out.print("*");
      }
      System.out.println();
      space--;
      star = star + 2;
    }
  }

  /*
           1
          121
         12321
        1234321
       123454321
        1234321
         12321
          121
           1
  */

  public static void triangle4() {
    int i, j, k, l, space = 10;
    for (i = 1; i <= 5; i++) {
      //First print the upper half triangle.
      for (j = 1; j <= space; j++) {
        System.out.print(" ");
      }
      for (k = 1; k <= i; k++) {
        System.out.print(k);
      }
      for (l = i - 1; l >= 1; l--) {
        System.out.print(l);
      }
      space--;
      System.out.println();
    }
//    //Now Print the lower half triangle.

    space = 10;
    for (i = 4; i >= 1; i--) {
      for (j = space-3; j >= 1; j--) {
        System.out.print(" ");
      }
      for (k = 1; k <= i; k++) {
        System.out.print(k);
      }
      for (l = i - 1; l >= 1; l--) {
        System.out.print(l);
      }
      space++;
      System.out.println();
    }
  }
}