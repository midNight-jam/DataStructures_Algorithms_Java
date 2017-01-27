package darkRealm.CTCI.BigO;

import java.util.*;

/**
 * Created by Jayam on 8/24/2016.
 */
public class ArrayUtil {


  private static int[] _temp;
  private static HashMap<Integer, Integer> record = new HashMap<>();

  //Example3 Pg28 Unordered Pairs
  public static void printUnorderedPairs(int[] arr) {
//        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        System.out.print("(" + arr[i] + "," + arr[j] + ")");
      }
      System.out.println("");
    }
  }

  public static int[] reverseArray(int[] arr) {
//        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int temp, swapIndex;
    for (int i = 0; i < arr.length / 2; i++) {
      swapIndex = arr.length - 1 - i;
      temp = arr[i];
      arr[i] = arr[swapIndex];
      arr[swapIndex] = temp;
    }
    return arr;
  }

  public static int[] rotateBySome(int[] arr, int rotationSize) {
    int arraySize = arr.length;
    int windowSize = (int) MathUtil.greatestCommonDivisorRC(arr.length, rotationSize);
    int temp, a, b;     // a & b will be the index of two window in which we have to swap
    for (int i = 0; i < windowSize; i++) {
      temp = arr[i]; // hold the element of first window
      a = i;         //
      while (true) {
        b = a + rotationSize; // getting the index of next window to swap
        if (b >= arraySize) {
          b = b - arraySize;   // setting b to preivous if it has exceeded length
        }
        if (b == i) {
          break;  // why..? meaning b has reached the back to the first index,
          // here we can break bcoz we already have that index value stored in temp
        }
        arr[a] = arr[b];
        a = b; // moving ahead to next window
      }
      arr[a] = temp;
    }

    return arr;
  }

  public static int[] intersection(int[] arr, int[] brr) {
    int[] intersection = new int[0];

    arr = MergeSort.mergeSort(arr);
    int match, intersectionCount = 0;
    for (int i = 0; i < brr.length; i++) {
      match = BinarySearch.doBinarySearch(arr, brr[i]);
      if (match >= 0) {
//                intersection = append(intersection, arr[match]);
        record(arr[match]);
      }
    }
    ArrayList<Integer> temp = new ArrayList<Integer>(record.values());
    for (Integer I :
        temp) {
      append(intersection, I.intValue());
    }
    return intersection;
  }

  public static int[] append(int[] arr, int n) {
    int[] brr = new int[arr.length + 1];
    for (int i = 0; i < arr.length; i++) {
      brr[i] = arr[i];
    }
    brr[arr.length] = n;
    return brr;
  }

  private static void record(int n) {
    if (!record.containsKey(n)) {
      record.put(n, n);
    }
  }

  public static void moveZeroes(int[] arr) {
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 0) {
        arr[count] = arr[i];
        count++;
      }
    }
    for (int j = count; j < arr.length; j++) {
      arr[j] = 0;
    }
  }

  public static int[] nextBiggerSomehowClose(int[] arr) {
    int result[] = new int[arr.length];
    Stack<Integer> stack = new Stack<>();
    int ai, ri;
    ai = 1;
    ri = 0;
    stack.push(arr[0]);
    // snecbgst  == stackIsNotEmptyAndCurrentIsBiggerThanStackTop
    boolean snecbgst = false;

    while (ai < result.length) {
      snecbgst = !stack.isEmpty() && arr[ai] > stack.peek();

      while (snecbgst) {
        stack.pop();
        result[ri] = arr[ai];
        ri++;
        snecbgst
            = !stack.isEmpty() && arr[ai] > stack.peek();

      }
      if (!snecbgst) {
        stack.push(arr[ai]);
      }
      ai++;
    }
    return result;
  }

  public static int[] nextBigger(int[] arr) {
    int[] result = new int[arr.length + 1];
    if (arr.length > 0) {
      int[] stack = new int[arr.length + 1];
      int[] indexArr = new int[arr.length + 1];
      int temp, stackTop = 0;
      stack[stackTop] = 999;
      for (int i = 0; i < arr.length; i++) {
        ++stackTop;
        stack[stackTop] = arr[i];
        indexArr[stackTop] = i;
        while (stack[stackTop] > stack[stackTop - 1] && (stackTop > 1)) {
          temp = stack[stackTop];
          stackTop--;
          result[indexArr[stackTop]] = temp;
//                    result[stackTop] = temp;
          stack[stackTop] = temp;
        }

      }
    }
    return result;
  }

  public static int[] nextBigger_usingPair(int[] arr) {
    int result[] = new int[arr.length];
    Stack<PairUtil> stack = new Stack<>();
    int ai = 1;
    stack.push(new PairUtil(arr[0], 0));
    // snecbgst  == stackIsNotEmptyAndCurrentIsBiggerThanStackTop
    boolean snecbgst = false;

    while (ai < result.length) {
      snecbgst = !stack.isEmpty() && arr[ai] > stack.peek().data;

      while (snecbgst) {
        PairUtil p = stack.pop();
        result[p.index] = arr[ai];
        snecbgst
            = !stack.isEmpty() && arr[ai] > stack.peek().data;

      }
      if (!snecbgst) {
        stack.push(new PairUtil(arr[ai], ai));
      }
      ai++;
    }
    return result;
  }

  public static int[] maxInWindow_failed_first_attempt(int[] arr, int windowSize) {
    int tempMax = Integer.MIN_VALUE;
    int[] result = new int[(arr.length) / windowSize + 1];
    int ri = 0;
    for (int i = 0; i < arr.length; i++) {
      if (tempMax < arr[i]) {
        tempMax = arr[i];
      }
      if ((i + 1) % windowSize == 0) {
        //save max
        result[ri++] = tempMax;
        tempMax = Integer.MIN_VALUE;
      }
    }
    if (arr.length % windowSize != 0) {
      result[ri++] = tempMax;
    }
    return result;
  }

  public static String maxInWindow(int[] arr, int windowSize) {
    int tempMax = Integer.MIN_VALUE;
    Queue<Integer> window = new LinkedList<>();
    int i = 0;
    String result = "";
    // build  a que, add & remove from que, while adding check if new is bigger than old ques max
    for (; i < arr.length; i++) {
      if (i >= windowSize) {
        window.remove(arr[i - windowSize]);
        result += " " + tempMax;
      }
      window.add(arr[i]);
      if (tempMax < arr[i]) {
        tempMax = arr[i];
      }
    }
    result += " " + tempMax;    // becuase we came out but didnt set the max
    return result;
  }

  // the constraint here is , that apart from the no which is occuring any number of odd times,
  // all shall appear any no of even times
  public static int findNoWhichIsOddTimesInRepeatingNos(int[] arr) {
    int _XORTemp = 0;
    for (int i = 0; i < arr.length; i++) {
      _XORTemp = _XORTemp ^ arr[i];
    }
    return _XORTemp;
  }

  public static String checkArraySumOddEven(int[] arr) {
    int _XORTemp = 0;
    for (int i = 0; i < arr.length; i++) {
      _XORTemp = _XORTemp ^ arr[i];
    }
    return _XORTemp == 1 ? "ODD" : "Even";
  }

  public static String getPowerSet(int[] arr) {
    return BitsUtil.printPowerSet(arr);
  }

  public static String printPairsWithSumK(int[] arr, int k) {
    StringBuffer string = new StringBuffer();
    // first sorth the array, i will use mergesort
    arr = MergeSort.mergeSort(arr);
    // nown for each element in array, get the diff with k : diff = modulo (arr[i] - k);
    // & binary search for diff in the array, we have to search only till half,
    // because the "k" will be formed with samll+big & after ttraversing till mid ,
    // we would have found all small' & their bigs,
    int diff = 0;
    int result = -1;
    for (int i = 0; i < (arr.length / 2); i++) {
      diff = k - arr[i];
      result = BinarySearch.doBinarySearch(arr, diff);
      if (result > -1) {
        string.append(" [" + arr[i] + ", " + result + "] ");
      }

    }
    System.out.println("result : " + string);
    return string.toString();
  }

  public static int giveMedianForRandomlyExpandingArray(int arr) {
    // 3,7,5 1,13 2, 5 --> let these be input so median will be the middle number if odd length
    // of the sum of two mid elements, if numbers in even length
    // algo is to have two halfs, ie the left smaller half & right bigger half.
    // if the input is odd length then mid element is the median(dont know exactly what this means)
    // if the input is even then mid element is average of top of both halves.
    // these two halves are smaller half : maxHeap, bigger half  : min heap

    return -1;
  }

  // these tow methods do sercing in O(logK) to retruen the kth smallest element, faster than sequential search.

  public static int getKthSmallestInUnionOfTwoArrays(int[] arr, int[] brr, int k) {
    return getKthSmallestInTwoArrays(arr, 0, arr.length, brr, 0, brr.length, k);
  }

  private static int getKthSmallestInTwoArrays(int[] arr, int startA, int endA, int[] brr, int startB, int endB, int k) {
    int lenA = arr.length;
    int lenB = brr.length;

    if (k == lenA + lenB) {
      // because its the last element pick the greater one.
      return Math.max(arr[k - lenB - 1], brr[k - lenA - 1]);
    }

    if (lenA > 0 && lenB > 0 && k > 0 && k < lenA + lenB) {
      if (k == 1) {
        // because its the first element pick the samller one.
        return Math.min(arr[0], brr[0]);
      }
      // as one array is completly exhausted pick what is left
      if (k > lenB) {
        return arr[k - lenB];
      }
      if (k > lenA) {
        return brr[k - lenA];
      }

      // invaraint i+j=k-1;
      int i = (k - 1) / 2;
      int j = (k - 1) - i;

      int ai = startA + i;
      int bj = startB + j;
      //case 1 : brr[j-1]<=arr[i]<=brr[j] ::: b in middle
      if (brr[bj - 1] <= arr[ai] && arr[ai] <= brr[bj]) {
        return arr[startA + i];
      }

      //case 2 : brr[j-1]<=arr[i]<=brr[j] ::: a in middle
      if (arr[ai - 1] <= brr[bj] && brr[bj] <= arr[ai]) {
        return brr[startB + j];
      }

      if (arr[ai] < brr[bj]) // disacrd all smaller a[i]
      {
        return getKthSmallestInTwoArrays(arr, ai, endA, brr, startB, endB, k - i);
      } else    //discard all bigger b[j]
      {
        return getKthSmallestInTwoArrays(arr, startA, endA, brr, bj, endB, k - j);
      }
    }
    return -1;
  }

}