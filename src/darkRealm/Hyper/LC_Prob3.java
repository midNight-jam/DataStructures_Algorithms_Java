package darkRealm.Hyper;

import ADT.TNode;

import java.util.*;

/**
 * Created by Jayam on 2/22/2017.
 */
public class LC_Prob3 {


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



  public static boolean isPalindrome(int x) {
    if (x < 0 || x != 0 && x % 10 == 0) return false;
    int rev = 0;
    while (x > rev) {
      rev = rev * 10 + x % 10;
      x /= 10;
    }
    return (x == rev || x == rev / 10);
  }

  public static boolean isHappy(int n) {
    Set<Integer> set = new HashSet<>();
    int r = 0;
    while (true) {
      set.add(n);
      r = 0;
      while (n > 0) {
        r += (n % 10) * (n % 10);
        n = n / 10;
      }
      if (r == 1)
        return true;
      else if (set.contains(r))
        return false;
      set.add(r);
      n = r;
    }
  }

  public static Map<Long, Integer> primeFactorization(long n) {
    Map<Long, Integer> primeFactors = new HashMap<>();
    for (long factor = 2; factor * factor <= n; factor++) {
      while (n % factor == 0) {
        System.out.print(factor + " ");
        n = n / factor;
        primeFactors.put(factor, primeFactors.getOrDefault(factor, 0) + 1);
      }
    }
    if (n > 1) {
      primeFactors.put(n, primeFactors.getOrDefault(n, 0) + 1);
      System.out.println(n);
    }
    return primeFactors;
  }

  public static int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length == 0) return new int[]{};
    int low = 0, high = nums.length - 1;
    int mid;
    int[] res = new int[2];
    while (low < high) {
      mid = low + (high - low) / 2;
      if (mid != 0 && nums[mid - 1] <= target) {
        res[0] = mid - 1;
      }
      if (mid != nums.length - 1 && nums[mid + 1] >= target) {
        res[1] = mid + 1;
      }
      if (target > nums[mid]) {
        low = mid;
        continue;
      }
      if (target < nums[mid]) {
        high = mid;
        continue;
      }
    }
    return res;
  }
}