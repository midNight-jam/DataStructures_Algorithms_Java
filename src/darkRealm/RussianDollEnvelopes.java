package darkRealm;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {

/*  #354. Russian Doll Envelopes
  You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit
  into another if and only if both the width and height of one envelope is greater than the width and height of the
  other envelope.
  What is the maximum number of envelopes can you Russian doll? (put one inside other)
  Example:
  Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll
  is 3 ([2,3] => [5,4] => [6,7]).*/

  public static int russianDollEnvelopes(int[][] envelopes) {
    Envelope[] arr = new Envelope[envelopes.length];
    for (int i = 0; i < envelopes.length; i++) {
      arr[i] = new Envelope(envelopes[i][0], envelopes[i][1]);
    }
    Arrays.sort(arr, new Comparator<Envelope>() {
      public int compare(Envelope e1, Envelope e2) {
        int res = e1.h - e2.h;
        return res != 0 ? res : e1.w - e2.w;
      }
    });
    int max = Integer.MIN_VALUE;
    int[] DP = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      DP[i] = 1;
      for (int j = 0; j <= i; j++) {
        if (arr[j].h < arr[i].h && arr[j].w < arr[i].w) {
          DP[i] = Math.max(DP[i], DP[j] + 1);
        }
      }
      max = Math.max(max, DP[i]);
    }
    return max;
  }

  private static class Envelope {
    int h, w;

    Envelope(int h, int w) {
      this.h = h;
      this.w = w;
    }
  }


  public static void main(String[] args) {
    int[][] nums = new int[][]{
        {5, 4}, {6, 4}, {6, 7}, {2, 3}
    };
    int res = russianDollEnvelopes(nums);
    System.out.println(res);
  }
}
