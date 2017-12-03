package darkRealm;

public class SuperWashingMachines {

  /*  #517 Super Washing Machines   TIme : O(n)
  *   You have n super washing machines on a line. Initially, each washing machine has some dresses or is empty.
  *   For each move, you could choose any m (1 ≤ m ≤ n) washing machines, and pass one dress of each washing machine
  *   to one of its adjacent washing machines at the same time .
  *   Given an integer array representing the number of dresses in each washing machine from left to right on the line,
  *   you should find the minimum number of moves to make all the washing machines have the same number of dresses.
  *   If it is not possible to do it, return -1.
  *   Example1
  *   Input: [1,0,5]
  *   Output: 3
  *   Explanation:
  *   1st move:    1     0 <-- 5    =>    1     1     4
  *   2nd move:    1 <-- 1 <-- 4    =>    2     1     3
  *   3rd move:    2     1 <-- 3    =>    2     2     2
  * */
  public static int findMoves(int[] machines) {
    if (machines == null || machines.length == 0) return 0;
    int total = 0;
    for (int i = 0; i < machines.length; i++)
      total += machines[i];
    if (total % machines.length != 0) return -1;
    int bal = total / machines.length;
    int[] buckets = new int[machines.length];
    int maxDue = Integer.MIN_VALUE;
    for (int i = 0; i < machines.length; i++) {
      buckets[i] = machines[i] - bal;
      maxDue = Math.max(buckets[i], maxDue);
    }

    int maxShift = Integer.MIN_VALUE;

    for (int i = 1; i < machines.length; i++) {
      buckets[i] += buckets[i - 1];
      buckets[i - 1] = 0; // redundant not required
      maxShift = Math.max(Math.abs(buckets[i]), maxShift);
    }
    return Math.max(maxDue, maxShift);
  }

  public static void main(String[] args) {
    int[] arr = new int[]{1, 0, 5};
    int res = findMoves(arr);
    System.out.println(arr);
    System.out.println(res);
  }
}
