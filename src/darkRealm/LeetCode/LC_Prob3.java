package darkRealm.LeetCode;

import darkRealm.CTCI.Trees_and_Graphs.TNode;

import java.util.*;

/**
 * Created by Jayam on 2/22/2017.
 */
public class LC_Prob3 {
  /*  [Prob 517] Super Washing Machines
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

  public static int longestValidParanthesis(String str) {
    if (str == null || str.length() == 0) return 0;
    Stack<Integer> stack = new Stack<>();
    int left = -1;
    int max = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '(') stack.push(i);
      else {
        if (stack.isEmpty()) left = i;
        else {
          stack.pop();
          if (stack.isEmpty())
            max = Math.max(max, i - left);
          else
            max = Math.max(max, i - stack.peek());
        }
      }
    }
    return max;
  }
  /*  [Prob 239] Sliding Window Maximum
  * */

  public static int[] slidingWindowMaximum(int[] arr, int k) {
    if (arr == null || arr.length == 0) return new int[]{};
    int windows = arr.length - k + 1; // these many number of windows
    int[] res = new int[windows];
    // stores the indexes
    LinkedList<Integer> deque = new LinkedList<>();
    for (int i = 0; i < arr.length; i++) {
      // means current head will now move out of the window [ k = i - headIndex], then remove the head
      if (!deque.isEmpty() && deque.peek() == i - k)
        deque.poll();

      while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i])
        deque.removeLast(); // why removing last, because a new max has arrived & we cannot hold smaller elements now,
      // so remove all smaller

      deque.add(i);
      if (i + 1 >= k) // means window has expanded
        res[i + 1 - k] = arr[deque.peek()];

    }
    return res;
  }

  public static int kthLargestElement(int[] nums, int k) {
    if (k < 1 || nums == null) {
      return 0;
    }

    return getKth(nums.length - k + 1, nums, 0, nums.length - 1);
  }

  public static int getKth(int k, int[] nums, int start, int end) {

    int pivot = nums[end];

    int left = start;
    int right = end;

    while (true) {

      while (nums[left] < pivot && left < right) {
        left++;
      }

      while (nums[right] >= pivot && right > left) {
        right--;
      }

      if (left == right) {
        break;
      }

      swap(nums, left, right);
    }

    swap(nums, left, end);

    if (k == left + 1) {
      return pivot;
    } else if (k < left + 1) {
      return getKth(k, nums, start, left - 1);
    } else {
      return getKth(k, nums, left + 1, end);
    }
  }

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }


  /* [Prob 96]*/
  public static List<TNode> uniqueBinarySearchTrees(int n) {
    if (n < 1) return new ArrayList<>();
    return createTree(1, n);
  }

  private static List<TNode> createTree(int start, int end) {
    List<TNode> treeList = new ArrayList<>();
    if (start > end) {
      treeList.add(null);
      return treeList;
    }
    if (start == end) {
      List<TNode> list = new ArrayList<>();
      list.add(new TNode(start));
      return list;
    }
    for (int i = start; i <= end; i++) {
      List<TNode> left = createTree(start, i - 1);
      List<TNode> right = createTree(i + 1, end);
      // cartesian Product
      for (TNode lnode : left) {
        for (TNode rnode : right) {
          TNode node = new TNode(i);
          node.left = lnode;
          node.right = rnode;
          treeList.add(node);
        }
      }
    }
    return treeList;
  }

  /*[Prob 95]*/
  public static int uniqueBST(int n) {
    if (n < 1) return 0;
    int[] DP = new int[n + 1];
    DP[0] = DP[1] = 1;
    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        DP[i] += (DP[j - 1] * DP[i - j]); // cartesian product
      }
    }
    return DP[n];
  }

  /* [Prob 354]
  *
  * */
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

  /*[Prob 43] Multiply Strings
  * */
  public static String multiply(String n1, String n2) {
    int a = n1.length(), b = n2.length();
    int[] pos = new int[a + b];
    // p1 goes at part (i + j) p2 goes at (i + j + 1) p1 = sum/10 p2  = sum % 10
    for (int i = n1.length() - 1; i >= 0; i--) {
      for (int j = n2.length() - 1; j >= 0; j--) {
        int prod = (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
        int p1 = i + j;
        int p2 = i + j + 1;

        int sum = prod + pos[p2];
        pos[p1] += sum / 10;
        pos[p2] = sum % 10;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < pos.length; i++) {
      if (!(pos[i] == 0 && sb.length() == 0))// dont append extra zeros at head
        sb.append(pos[i]);
    }
    return sb.length() == 0 ? "0" : sb.toString();
  }

  public static int[] plusOne(int[] nums) {
    if (nums == null || nums.length == 0) return nums;
    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] < 9) {
        nums[i]++;
        return nums;
      } else nums[i] = 0;
    }
    int[] newNo = new int[nums.length + 1];
    newNo[0] = 1;
    return newNo;
  }

  public static String addBinary(String a, String b) {
    int na = 0, nb = 0;
    int i = a.length() - 1;
    int j = b.length() - 1;
    int sum = 0, carry = 0;
    StringBuilder sb = new StringBuilder();
    while (i >= 0 || j >= 0) {
      sum = carry;
      if (i >= 0) {
        sum += a.charAt(i) - '0';
        i--;
      }
      if (j >= 0) {
        sum += b.charAt(j) - '0';
        j--;
      }
      carry = sum / 2;
      sum = sum % 2;
      sb.append(sum);
    }
    if (carry == 1) sb.append('1');
    return sb.reverse().toString();
  }


  public static int addDigits(int num) {
    int sum = 0;
    while (num > 9) {
      sum = 0;
      while (num > 0) {
        sum += num % 10;
        num = num / 10;
      }
      num = sum;
    }
    return num;
  }

  /*  [Prob 520] Detect Capital*/
  public static boolean detectCapitals(String word) {
    if (word == null || word.length() == 0) return false;
    int upCount = 0;
    boolean firstUp = false;
    if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') firstUp = true;
    for (int i = 1; i < word.length(); i++) {
      if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') upCount++;
      if (!firstUp && upCount > 0) return false;
    }

    if (firstUp && word.length() == upCount + 1) return true;
    return upCount == 0 ? true : false;
  }

  /* [Prob 515] Find Largest Value in Each Tree Row*/
  public static List<Integer> largestValues(TNode node) {
    List<Integer> list = new ArrayList<>();
    if (node == null) return list;
    levelwise(node, 0, list);
    return list;
  }

  private static void levelwise(TNode node, int level, List<Integer> list) {
    if (node == null) return;
    if (list.size() < level + 1)
      list.add(Integer.MIN_VALUE);

    levelwise(node.left, level + 1, list);
    if (node.data > list.get(level))
      list.set(level, node.data);
    levelwise(node.right, level + 1, list);
  }

  public static void moveZeroes(int[] arr) {
    if (arr == null || arr.length == 0) return;
    int zi = 0;
    while (zi < arr.length && arr[zi] != 0) zi++;
    for (int i = zi + 1; i < arr.length; i++) {
      if (arr[i] != 0) {
        arr[zi] = arr[i];
        arr[i] = 0;
        zi++;
      }
    }
  }

  /*[Prob 29] Divide two integers*/
  public static int divide(int dividend, int divisor) {
    if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
    int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
    long dvd = Math.abs((long) dividend);
    long dvs = Math.abs((long) divisor);
    int res = 0;
    while (dvd >= dvs) {
      // calculate the number of shifts
      long temp = dvs;
      int mul = 1;
      while (dvd >= temp << 1) {
        temp = temp << 1;
        mul = mul << 1;
      }
      dvd = dvd - temp;
      res = res + mul;
    }
    return sign == -1 ? -res : res;
  }

  /* [Prob 190] Reverse bits
  * */
  public static int reverseBits(int n) {
    int rev = 0;
    for (int i = 0; i < 32; i++) {
      rev += n & 1; // getting the last bit
      n = n >>> 1; // doing unsigned shift
      if (i < 31) //  so that our shoft doesnt causes a sign bit
        rev = rev << 1;
    }
    return rev;
  }

  /* [Prob 190] Reverse bits Efficient optimized for mulitple calls
  * */
  static final Map<Byte, Integer> cache = new HashMap<>();

  public static int reverseBitsEfficient(int n) {
    byte[] bytes = new byte[4];
    for (int i = 0; i < 4; i++)
      bytes[i] = (byte) ((n >>> 8 * i) & 0xFF);

    int res = 0;
    for (int i = 0; i < 4; i++) {
      res += reverseBytes(bytes[i]);
      if (i < 3)
        res = res << 8;
    }
    return res;
  }

  private static int reverseBytes(byte b) {
    if (cache.containsKey(b)) return cache.get(b);
    int val = 0;
    for (int i = 0; i < 8; i++) {
      val += ((b >>> i) & 1);
      if (i < 7) {
        val = val << 1;
      }
    }
    cache.put(b, val);
    return val;
  }

  public static String numToBase(int num, int base) {
    if (num == 0) return "0";
    int i = 0;
    boolean sign = num < 0;
    num = Math.abs(num);
    StringBuilder sb = new StringBuilder();
    while (num > 0) {
      sb.append(getSymbol(num % base));
      num /= base;
    }
    if (sign) sb.append("-");
    return sb.reverse().toString();
  }

  private static char getSymbol(int n) {
    if (n >= 0 && n <= 9) return (char) (n + '0');
    else return (char) (n - 10 + 'A');
  }

  public static String smallestGoodBase(String n) {
    if (n == null || n.length() == 0) return "";
    int base = 3;
    int num = Integer.parseInt(n);
    while (true) {
      String changed = numToBase(num, base);
      int i = 0;
      for (; i < changed.length(); i++)
        if (changed.charAt(i) != '1') break;
      if (i == changed.length()) return base + "";
      base++;
    }
  }

  /*[Prob 167] Two Sum II - Input array is sorted*/
  public static int[] twoSum(int[] numbers, int target) {
    if (numbers == null || numbers.length < 1) return new int[]{};
    int left = 0, right = numbers.length - 1;
    while (numbers[left] + numbers[right] != target) {
      if (numbers[left] + numbers[right] < target)
        left++;
      else
        right--;
    }
    return new int[]{left + 1, right + 1};
  }

  public static List<String> textJustification(String[] words, int maxLen) {
    List<String> result = new ArrayList<>();
    if (words == null || words.length == 0) return result;
    int wi = 0, wlen = 0, lineLen = 0;
    StringBuilder sb;
    int prev = 0;
    while (wi < words.length) {
      lineLen = 0;
      while (lineLen < maxLen) {
        wlen = words[wi].length();
        lineLen = lineLen + wlen;
        if (lineLen + 1 < maxLen) {
          lineLen++;
        }
        wi++;
      }
      sb = new StringBuilder();
      for (int i = prev; i < wi - 1; i++) {
        sb.append(words[i]);
        if (sb.length() < maxLen) sb.append(" ");
      }
      while (sb.length() < maxLen) {
        sb.append(" ");
        lineLen++;
      }
      result.add(sb.toString());
      prev = wi - 1;
    }
    return result;
  }

  /*[Prob 532]  K-diff Pairs in an Array */
  public static int kDiffFindPairs(int[] arr, int k) {
    if (arr == null || arr.length == 0 || k < 0) return 0;

    Map<Integer, Integer> map = new HashMap<>();
    int pair = 0;
    for (int i : arr) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (k == 0) {
        //count how many elements in the array that appear more than twice.
        if (entry.getValue() >= 2) {
          pair++;
        }
      } else {
        if (map.containsKey(entry.getKey() + k)) {
          pair++;
        }
      }
    }

    return pair;
  }
  /*[Prob 531] Lonely Pixel I */
  public int findLonelyPixel(char[][] picture) {
    if (picture == null || picture.length == 0 || picture[0].length == 0) return 0;
    int[] rowsCount = new int[picture.length];
    int[] colsCount = new int[picture[0].length];
    for (int i = 0; i < picture.length; i++) {
      for (int j = 0; j < picture[0].length; j++) {
        if (picture[i][j] == 'B') {
          rowsCount[i]++;
          colsCount[j]++;
        }
      }
    }

    int lonelyB = 0;
    for (int i = 0; i < picture.length; i++) {
      for (int j = 0; j < picture[0].length; j++) {
        if (picture[i][j] == 'B' && rowsCount[i] == 1 && colsCount[j] == 1)
          lonelyB++;
      }
    }

    return lonelyB;
  }
}