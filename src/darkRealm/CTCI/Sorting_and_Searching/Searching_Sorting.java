package darkRealm.CTCI.Sorting_and_Searching;

import darkRealm.CTCI.Trees_and_Graphs.RankTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;

/**
 * Created by Jayam on 1/11/2017.
 */
public class Searching_Sorting {

  /*  [Prob 10.1]
  *   Q) Sorted Merge : we are given two sorted arrays A & B, where A has a large enough buffer at the end to hold B.
  *     Write a method to merge B into A sorted Order.
  *   A) Will compare both the arrays from behind rather than front, with taking pointers Ra, Rb for reading from a & b.
  *       And take another pointer Wa for writing the elements in A from behind.
  * */
  public static int[] sortedMerge(int[] arr, int[] brr) {
    // arr is longer & has buffer to accomodate brr in it.
    int wA = arr.length - 1;
    int rA, rB;
    rA = arr.length - brr.length - 1; // as should has space at behind, thus we are reading the first element from end
    rB = brr.length - 1;
    while (rB >= 0) {
      if (rA >= 0 && arr[rA] > brr[rB]) {
        arr[wA] = arr[rA];
        rA--;
      } else {
        arr[wA] = brr[rB];
        rB--;
      }
      wA--;
    }
    return arr;
  }


  //not very effective still goes to O(N)
  public static int searchRotatedArrayOLD(int[] arr, int k) {
    int rotated = findRotatedIndexOLD(arr, 0, arr.length);
    System.out.println("Rotated at : " + rotated);
    System.out.println(" " + Arrays.toString(arr));

    int res = BinarySearchUtil.binarySearchRecursive(arr, k, 0, rotated - 1);
    if (res == Integer.MIN_VALUE) {
      res = BinarySearchUtil.binarySearchRecursive(arr, k, rotated, arr.length);
    }
    System.out.println("res  : " + arr[res]);
    System.out.println("index: " + res);
    System.out.println(" " + Arrays.toString(arr));
    return res;
  }

  private static int findRotatedIndexOLD(int[] arr, int low, int high) {
    int rotated = 0;
    if (low <= high) {
      int mid = (low + high) / 2;
      if (low == high) {
        return 0;
      }
      if (mid != 0 && arr[mid] < arr[mid - 1]) {
        return mid;
      }

      rotated = findRotatedIndexOLD(arr, low, mid - 1);
      if (rotated != 0) {
        return rotated;
      }
      rotated = findRotatedIndexOLD(arr, mid + 1, high);
    }
    return rotated;
  }


  public static int searchRotatedArray(int[] arr, int k) {
    return findRotatedIndex(arr, 0, arr.length - 1, k);
  }

  /* [Prob 10.3]
  Q) Search in a rotated array - Given a sorted array of n integers that has been rotated an unknown munber of times
   write a code to find the element in the array. Array was originally sorted in increasing order
   A) Woudl utilize binary search. First will calculate the mid & check if the mid is bigger tahn low, if yes that means
   left half is sorted. Now does the element exists in this sorted half, check it by comparing to low & mid does it falls
   in the range. Similarly check if the right half is sroted & check in that range. IF
*/
  public static int findRotatedIndex(int[] arr, int low, int high, int k) {
    int mid = (low + high) / 2;

    if (arr[mid] == k) {
      return mid;
    }

    if (high < low) {
      return -1;
    }
    if (arr[low] < arr[mid]) {  // left half is sorted
      if (arr[low] < k && k < arr[mid]) { // and element is within the range
        return findRotatedIndex(arr, low, mid - 1, k);
      }

    }

    if (arr[mid] < arr[high]) { // right half is sorted
      if (arr[mid] < k && k < arr[high]) {  // and element is within the range
        return findRotatedIndex(arr, mid + 1, high, k);
      }
    }
    int res = findRotatedIndex(arr, low, mid - 1, k);
    if (res == -1) {
      res = findRotatedIndex(arr, mid + 1, high, k);
    }
    return res;
  }

  /*[Prob 10.2]
   Q) Group Anagrmas : a method to sort an array of strings so that all the anagrams are next to each other
   A) we create a hashmap of sorted string as key and arraylist of string as value. we sort each word & see if it can be
   placed agains an existing key else we create that key & initailize with that word in array list against tht key.
  * */

  public static void groupAnagrams(String[] arr) {
    HashMap<String, ArrayList<String>> result = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      char[] w = arr[i].toCharArray();
      Arrays.sort(w);
      String word = new String(w);
      if (result.containsKey(word)) {
        result.get(word).add(arr[i]);
      } else {
        ArrayList<String> list = new ArrayList<>();
        list.add(arr[i]);
        result.put(word, list);
      }
    }

    for (String w :
        result.keySet()) {
      ArrayList<String> list = result.get(w);
      for (int i = 0; i < list.size(); i++) {
        System.out.print(" " + list.get(i));
      }
    }
  }

  /* [Prob 10.4]
  *   Q) Sorted Search,No Size : given a DS Listy that lacks the size Method , but has a elementAt(i) meth which return -1
  *   if index is out of range. Now, given a Listy which contains sorted +ve integers find the index at which a given x occurs
  *   A) will take a trav index i & will ask to get the elementAt(i), if the returned element is smaller than than the x vlaue
  *   then we will binary serach in the found range else will 2le i and fetch again at i. If -ve means we have corseed bounds
  *   then we fire again binary serach in this range to get the element. This technique is called as Exponential Backoff
  * */

  public static int sortedSearchNoSize(Listy listy, int k) {
    int i = 1;
    int low, high, mid, end;
    low = 0;
    high = 1;
    int element = 0;
    while (listy.elementAt(high) > 0) {
      mid = (low + high) / 2;
      if (listy.elementAt(mid) == k) {  // if we have found the element itself
        return mid;
      }

      if (k < listy.elementAt(high)) {  // if we have found the upperbound on the range
        break;
      }
      low = high;
      high = 2 * high; // move ahead by 2le size
    }

    if (k < listy.elementAt(high)) {
      // binary search for element in low-high range
      return BinarySearchUtil.binarySearchRecursive(listy.arr, k, low, high);
    }
    int beg = low;
    if (listy.elementAt(high) < 0) {
      // we have to serach for the end
      while (true) {
        mid = (low + high) / 2;
        if (listy.elementAt(mid) > 0) {
          low = mid;
        }
        if (listy.elementAt(mid) < 0) {
          high = mid;
        }
        if (listy.elementAt(mid + 1) < 0) {
          end = mid;
          break;
        }
      }
      return BinarySearchUtil.binarySearchRecursive(listy.arr, k, beg, end);
    }
    return -1;
  }

  static class Listy {
    int[] arr;
    int size;

    public Listy(int s) {
      arr = new int[s];
      size = s;
    }

    public int elementAt(int i) {
      if (i < size) {
        return arr[i];
      }
      return -1;
    }
  }

  public static void testSortedSearchNoSize() {
    Listy listy = new Listy(6);
    listy.arr = new int[]{11, 22, 33, 44, 55, 66};
    sortedSearchNoSize(listy, 55);
  }

  /*  [Prob 10.11]
  * Q) Peaks And Valleys : In an arraoy of integers , a peak is ana element which is greater than or equal to the adjacent
  * integers & a valley is an element which is less than or equal to the adjacent intgers. Now, sort the array into
  * alternating sequence of peaks & valleys
  * Input : [ 5,3,1,2,3]
  * Output : [ 5,1,3,2,3]
  *
  * A) Will take a group of 3 elements to fit a valley in between
  * thus the portion of 3 elements will be arranged as Max, Min, Other. in this way we ensure that valley is in between &
  * the peak is at left always making it possible to maintain the valley in between as the other would get swapped & handled
  * in next iteration.
  * */

  public static void peaksValleys(int[] arr) {
    int i = 1;
    for (; i < arr.length - 1; i += 2) {
      swapToMaxMinOther(arr, i - 1, i + 1);
    }
    if (i == arr.length - 1 && arr[i] > arr[i - 1]) {
      int temp = arr[i - 1];
      arr[i - 1] = arr[i];
      arr[i] = temp;
    }
    System.out.println("Peaks & valleys : " + Arrays.toString(arr));
  }

  private static void swapToMaxMinOther(int[] arr, int low, int high) {
    int min = Math.min(arr[low], arr[low + 1]);
    min = Math.min(min, arr[high]);
    int max = Math.max(arr[low], arr[low + 1]);
    max = Math.max(max, arr[high]);
    ArrayList<Integer> three = new ArrayList<>();
    three.add(arr[low]);
    three.add(arr[low + 1]);
    three.add(arr[high]);
    three.remove(new Integer(min));
    three.remove(new Integer(max));
    int other = three.get(0);
    arr[low] = max;
    arr[low + 1] = min;
    arr[high] = other;
  }

  /*[Prob 10.9]
  *   Q) Sorted Matrix Search : Given a M*N matrix in which each row & each column is sorted in ascending order, write
  *   a method to find an element
  *   A) The idea is very similar to binary search but rather than on one dimension like array we do it for 2 dimesion matrix
  *     First take low as top left corner, & high as bottom right corner. now take mid which will be any element in between
  *     the matrix. Compare this mid with k if k is greater than move in the upper half, if k is smaller than move in the
  *     lower half. We stop at a point where we have narowed down to 2 consecutive rows among which the element K shoud be
  *     present. However, we dont do a binary serach on whole rows, rather we benefit from fact that its sorted matrix
  *     and in first row we srach from low index to end. And in second row we search from start to high index
  * */
  public static int sortedMatrixSearch(int[][] mat, int k) {
    int lowX, lowY, highX, highY, midX, midY;
    lowX = lowY = 0;
    highX = mat.length;
    highY = mat[0].length;
    while (true) {  // till we have not found two rows within which our element should be
      midX = (lowX + highX) / 2;
      midY = (lowY + highY) / 2;

      if (mat[midX][midY] == k) {
        return mat[midX][midY]; // Lucky Case!!
      }
      if (Math.abs(lowX - highX) == 1) {
        break;  // the closest rows
      }

      if (k < mat[midX][midY]) {
        highX = midX;
        highY = midY;
      }
      if (k > mat[midX][midY]) {
        lowX = midX;
        lowY = midY;
      }
    }

    int resX = lowX;
    //binary search on lowX row, between LowY till end for searching K
    int resY = BinarySearchUtil.binarySearchRecursive(mat[lowX], k, lowY, mat[lowX].length - 1);
    //binary search on highX row, between start till highY for searching K
    if (resY == Integer.MIN_VALUE) {
      resX = highX;
      resY = BinarySearchUtil.binarySearchRecursive(mat[highX], k, 0, highY);
    }
    return resY == Integer.MIN_VALUE ? Integer.MIN_VALUE : mat[resX][resY];
  }

  /*  [Prob 10.5]
  *   Q) Sparse Search : Given a sorted array of strings that is interparsed with empty strings, write a method to find the
  *   location of a given string
  *   A) will use binary search as usual, but if we find an empty string at the middle then we fire iteration in both
  *   directions left & right in order to get the closest non emtty string and assign this index as mid to carry on binary search
  * */
  public static String sparseSearch(String[] arr, String k) {
    int low = 0;
    int high = arr.length - 1;
    int mid;
    while (low <= high) {

      mid = (low + high) / 2;

      if (arr[mid].isEmpty()) {
        int left = mid - 1;
        int right = mid + 1;
        while (left >= low && right <= high) {

          if (!arr[left].isEmpty()) {
            mid = left;
            break;
          }
          if (!arr[right].isEmpty()) {
            mid = right;
            break;
          }

          left--;
          right++;
        }
      }

      if (arr[mid].equals(k)) {
        System.out.println("found at " + mid);
        return arr[mid];
      }
      if (arr[mid].compareToIgnoreCase(k) < 0) {
        low = mid + 1;
      }
      if (arr[mid].compareToIgnoreCase(k) > 0) {
        high = mid - 1;
      }

    }
    return "";
  }

  /*  [Prob 10.10]
  *   Q) Rank Form Stream :  We are reading a stream of integers. We want to able to get the rank of a number X.
   *   Rank == Number of values
   *   A) We will use BST but with some additional info at each node. this additional info is the no of left childs & the
   *   no of right childs from that node. So we we search for an element from root, if we go right then we have skipped all
   *   the left childs of that node & that node itself, thus we will increase the rank by leftChilds + 1. If we go left
   *   we dont need to add anythign to rank and if we find the data then we add the no of left childs of that node to the rank.
   *   I implemented a DS RantTree for this purpose, hwever if we just have to rank a number from its smaller elements
   *   then we dont need to store rightchilds on each node. just by storing lefthcilds we would be able to get the rank.
  * */
  public static int rankFromStream(int[] arr, int k) {
    RankTree rtree = new RankTree();
    for (int i = 0; i < arr.length; i++) {
      rtree.insert(arr[i]);
    }
    return rtree.getRank(k);
  }


  /*  [Prob 10.8]
  *   Q) Find duplicates : we have an array with all the numbers from 1 to N, where N is atmost 32000. The array may have
  *   duplicate enteries & you do not what N is. With only 4 KB of memory avaialable, print all the duplicates in the array.
  *   A) CHECK BELOW 2 SOLUTIONS
  *   as we have the memeory of 4KB that is equal to 32000 thus we can have a bit array of same size and mark the ith bit
  *   as 1  & if the ith numbers comes again we will know & thus prtin it
  * */
  public static void findDuplicates(int[] arr, int memorySize) {
    BitSet memSizeBits = new BitSet(memorySize);
    for (int i = 0; i < arr.length; i++) {
      if (memSizeBits.get(arr[i])) {
        System.out.println("Dup " + arr[i]);
      } else {
        memSizeBits.set(arr[i]);
      }
    }
  }
  /*[Prob 10.8]*/
  public static void findDuplicatesMyBitsArray(int[] arr, int memorySize) {
    MyBitArray myBitArray = new MyBitArray(memorySize);
    for (int i = 0; i < arr.length; i++) {
      if (myBitArray.get(arr[i])) {
        System.out.println("Dup " + arr[i]);
      } else {
        myBitArray.set(arr[i]);
      }
    }
  }
}