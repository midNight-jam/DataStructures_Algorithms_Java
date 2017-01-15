package com.darkRealm.Arrays_and_Strings;

import com.darkRealm.BigO.QuickSort;
import com.darkRealm.LinkedLists.LinkedList;
import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Jayam on 10/2/2016
 */
public class Arrays_and_Strings {
/* Some solutions of Arrays Can be found in "ArraUtil Class"*/

  /* [Prob 1.1]
  the question mentioned not to use extra ds thats why we are not using HashMap,
     with using hash map it would be simpler, just keep pushing curent char in to hashmap, if not alreaday ther,
     if its present retun false. In below appraoch we have sorted string & then traversed it for finding duplicate
     hence excluing conversion :  S = string len,  total is O(SlogS) + O(S) === O(SlogS) */
  public static boolean IsUnique(String str) {
    int[] asciiArr = new int[str.length()];
    for (int i = 0; i < asciiArr.length; i++) {
      asciiArr[i] = (int) str.charAt(i);
    }
    QuickSort.doQuickSort(asciiArr);

    char[] charArr = new char[str.length()];
    for (int i = 0; i < asciiArr.length; i++) {
      charArr[i] = (char) asciiArr[i];
    }
    int i = 0;
    for (i = 0; i < charArr.length - 1; i++) {
      if (charArr[i] == charArr[i + 1]) {
        break;
      }
    }
    return i == str.length() - 1 ? true : false;
  }

  /* [Prob 1.2]
  * */
  public static boolean CheckPermutation(String str, String perm) {
    HashMap<Character, Integer> originalStrMap = new HashMap<>();
    for (int i = 0; i < str.length(); i++) {
      if (originalStrMap.containsKey(str.charAt(i))) {
        int count = originalStrMap.get(str.charAt(i));
        originalStrMap.put(str.charAt(i), count + 1);
      } else {
        originalStrMap.put(str.charAt(i), 1);
      }
    }
    HashMap<Character, Integer> permStrMap = new HashMap<>();

    for (int i = 0; i < perm.length(); i++) {
      // present in original map
      if (originalStrMap.containsKey(perm.charAt(i))) {
        // present in perm Map
        if (permStrMap.containsKey(perm.charAt(i))) {
          // increment value
          int permCount = permStrMap.get(perm.charAt(i));
          permStrMap.put(perm.charAt(i), permCount + 1);
          // if after increasing its more
          if (permStrMap.get(perm.charAt(i)) > originalStrMap.get(perm.charAt(i))) {
            return false;
          }
        }
        // have to add to perm map
        else {
          permStrMap.put(perm.charAt(i), 1);
        }
      } else {
        return false;
      }
    }

    // final traversal to se if any char appeared less

    for (int i = 0; i < str.length(); i++) {
      if (originalStrMap.get(str.charAt(i)) != permStrMap.get(str.charAt(i))) {
        return false;
      }
    }

    return true;
  }

  /*  [Prob 1.4]
 @Param str : a string which we have to prove if its a permutation  of a palindrome
  input : tactcoa
  output : True bcoz [ "tac o cat", "act o tca"]
   if the given string is EVEN len then all the elemets  ahve to appear only even times inorder to able to form
   a posiible palindrome,
   if the given string is ODD len , then all except one elemsnts have to appear even times & ONLY ONE element has to
   appear odd times.
  * */
  public static boolean palindromePermutation(String str) {
    // first create hasmap with count of char appearnce
    HashMap<Character, Integer> map = new HashMap<>();
    int len = str.length();
    char c;
    // preapre map
    for (int i = 0; i < len; i++) {
      c = str.charAt(i);
      if (map.containsKey(str.charAt(i))) {
        map.put(c, map.get(c) + 1);
      } else {
        map.put(c, 1);
      }
    }

    boolean even = isEven(len);
    int charCount;
    int oneOddCount = 0;
    for (int i = 0; i < len; i++) {
      if (even) {
        charCount = map.get(str.charAt(i));
        if (!isEven(charCount)) {
          return false;
        }
      } else {
        charCount = map.get(str.charAt(i));
        if (!isEven(charCount)) {
          oneOddCount++;
        } else if (isEven(charCount)) {
          continue;
        } else if (oneOddCount > 1) {
          return false;
        }
      }
    }
    return true;
  }

  private static boolean isEven(int i) {
    return (i & 1) == 1 ? false : true;
  }

  /* []Prob 1.6]
  @Param str :  a string which will be compressed
  input: aabbcccaaa
  output : a2b2c3a3
  * */
  public static String stringCompression(String str) {
    StringBuilder compressedString = new StringBuilder();
    int len = str.length();
    if (len > 0) {
      int count = 1;
      char c;
      int i = 1;
      for (; i < len; i++) {
        if (str.charAt(i) == str.charAt(i - 1)) {
          count++;
        } else {
          compressedString.append(str.charAt(i - 1) + "" + count);
          count = 1;
        }
      }
      compressedString.append(str.charAt(i - 1) + "" + count);
      System.out.println(compressedString);
    }
    return compressedString.toString();
  }

  /* [Problem]
  *   Q) given an array and a size K, print all the combinations of size K that can be created using that array
  *   A) We will recursiely call the method to remove the element from the ith index of list and append it to the partial
  *   result and recurse again, untill the partial result is of the length K. One important point to note in the below
  *   algo is that after removing an element from the index, we have to add it back so that we can generate more
  *   combinations, but because of Java's ArrayList inherent behaviour when we are adding the element back to the list.
  *   The element is added by default at the end. this creates some mess as the collection has lost its original sequence
   *   we will not be able to generate all the combinations. This we have to make a clone of the original list so that
   *   we can just reset the list to its previous sequence instead of manually inserting the removed element to its
   *   original postion. Thus, pay attention when you see clone in the below method
  * */

  public static void getSubArrayCombinations(Integer[] arr, int k) {
    if (k > arr.length) {
      return;
    }
    combinationNumber = 0;
    ArrayList<Integer> nos = new ArrayList<Integer>(Arrays.asList(arr));
    ArrayList<Integer> res = new ArrayList<Integer>();
    combine(nos, res, k);
  }

  static int combinationNumber = 0;

  private static void combine(ArrayList<Integer> nos, ArrayList<Integer> res, int k) {
    if (res.size() == k) {
      combinationNumber++;
      System.out.println(Arrays.toString(res.toArray()) + "  - " + combinationNumber);
      return;
    }
    ArrayList<Integer> numbers = (ArrayList<Integer>) nos.clone();
    for (int i = 0; i < numbers.size(); i++) {
      int trav = numbers.get(i);
      // making a clone else will have to simarly remove the elements from the results combinations, its easier to have
      // a discardable clone. Thus below Clone
      ArrayList<Integer> results = (ArrayList<Integer>) res.clone();
      results.add(trav);
      numbers.remove(i);  // removing at the index
      combine(numbers, results, k);
      numbers = (ArrayList<Integer>) nos.clone(); // resetting to original SEQUENCE for more combinaitons,
      // THIS PART IS REALLY ESSENTIAL, beacuse if we simply add the element back to the list, it is not maintaining the
      // ORIGINAL sequence of numbers, due to this our combinations are repeating inspite of runing for correct no
      // of times
    }
  }

  /* [Prob 4.12] Faster O(N)
 *   Q) find out the ways in which we can get the target sum from using any consequent sequence from the array
 *   A) This approach uses a technique described in CTCI. It is expalined via an array concept, have implemented that
 *   also in  the array & strings class. The logic is to have an array that keeps the running Sum till this point say RSx
 *   for xth element. And we are also given the target sum lets say Ts. According to the formula RSx = RSy -Ts (how is
 *   this derived not sure/ out of scope for now), we get RSy = RSx -Ts, we will require this RSy for the nest step.
 *   Now we have to create a hashmap MAP_RS that will store all the runninsums as keys and the number of times they appeared
 *   in the running sum array. Now comes the actual possible ways part
    *   For each y: get the RSy
    *   Look up the RSy in the MAP_RS
    *   if found then add the value of RSy from MAP_RS to the totalWays
 *     [COMPLEXITY - O(N)]
 * */
  public static int possibleSubArraysWithSumFaster(int[] arr, int targetSum) {
    int[] runningSum = new int[arr.length];
    int possibleSubArraysWithSum = 0;
    HashMap<Integer, Integer> mapRS = new HashMap<>();
    runningSum[0] = arr[0]; // initializing the runningSum first element with firt element of array
    mapRS.put(runningSum[0], 1); // initializing the mapRs with the running sum first element

    for (int i = 1; i < arr.length; i++) {
      runningSum[i] = arr[i] + runningSum[i - 1]; // the next running sum will be sum of last running sum & the element
      if (mapRS.containsKey(runningSum[i])) {
        mapRS.put(runningSum[i], mapRS.get(runningSum[i]) + 1); // if this runningSum is already present increment
      } else {
        mapRS.put(runningSum[i], 1);  // else just record its first occurence
      }
    }

    for (int i = 0; i < runningSum.length; i++) {
      int rsX = runningSum[i];
      int rsY = rsX - targetSum;
      if (mapRS.containsKey(rsY)) {
        possibleSubArraysWithSum += mapRS.get(rsY);
      }
    }
    return possibleSubArraysWithSum;
  }


  /* [Prob] Problem: you are given 2 words with equal number of characters. Find an algorithm to go from first word to
      second word, changing one character at each step, in such a way that each intermediate word exist in a given dictionary.
      Example:
      Words are pit, map. A possible solution:
      pit, pot, pet, met, mat, map
    A) will fire recusrion for every character on a postion from a-z & check if the new word is a valid word if yes will
      add it to the path & fire recursion for next character from a-z & so on. will store the result only if the tareget
      word is reached. Later will compare all the results that reached the target word & return the smallest path
      Complexiyt - 27^n where n is the longest path to the target word STAGERRING COMPLEXITY WILL KILL COMPUTER
  */
  public static String shortestPathBetweenWords(String source, String target) {
    HashSet<String> dictionary = new HashSet<>();
//    dictionary.add("mit");
//    dictionary.add("kit");
//    dictionary.add("jet");
//    dictionary.add("pet");
//    dictionary.add("lot");
//    dictionary.add("pot");
//    dictionary.add("pet");
//    dictionary.add("hot");
//    dictionary.add("met");
//    dictionary.add("map");
//    dictionary.add("pat");
//    dictionary.add("mat");
//    dictionary.add("cat");
//    findPathOfWords("pit", "map", dictionary, "pit", 0);
    dictionary.add("poon");
    dictionary.add("plee");
    dictionary.add("same");
    dictionary.add("poie");
    dictionary.add("plea");
    dictionary.add("plie");
    dictionary.add("poin");

    findPathOfWords("toon", "plea", dictionary, "toon", 0);

    return path;
  }

  static String path = "";

  private static void findPathOfWords(String source, String target, HashSet<String> dictionary, String Path, int charIndex) {
    if (source.equals(target)) {
      if (Path.length() > path.length()) {
        path = Path;
      }
      return;
    }

    for (int ci = 0; ci < target.length(); ci++) {
      String left = source.substring(0, ci);
      String right = source.substring(ci + 1);
      String newWord = "";
        for (int i = 97; i < 123; i++) {
        newWord = left + (char) i + right;
        if (dictionary.contains(newWord) && !Path.contains(newWord)) {
          Path += " - " + newWord;
          findPathOfWords(newWord, target, dictionary, Path, charIndex + 1);
        }
      }
    }
  }
}