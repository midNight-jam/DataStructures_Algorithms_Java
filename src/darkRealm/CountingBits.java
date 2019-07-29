package darkRealm;

public class CountingBits {

  /*  #338 Counting Bits
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's
 * in their binary representation and return them as an array.
 * Example:For num = 5 you should return [0,1,1,2,1,2].
 * Sol : There is a recurence relation of adding the previously counted 1 bits
 * res[i] = res[i / 2] + i % 2;
 * */
  public static int[] countingBits(int n) {
    if(num < 0) return new int[0];
    int [] dp = new int[num + 1];
    dp[0] = 0;
    for(int i = 1; i <= num; i++){
      // if even, go to a prev even number i.e. after removing the even part (num / 2)
      if((i & 1) == 0)
        dp[i] = dp[i/2];
      // if odd, go to a prev even number + an extra 1 bit for odd
      else
        dp[i] = dp[i/2] + 1;
    }
      
    System.out.println(Arrays.toString(dp));
    return dp;
  }

  public static void main(String[] args) {
    int n = 13;
    int [] res = countingBits(n);
    System.out.println(Arrays.toString(res));
  }
}
