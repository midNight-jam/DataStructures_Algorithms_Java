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