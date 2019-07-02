package darkRealm;

public class NumberOfMatchingSubsequences {

//  792. Number of Matching Subsequences
//  Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.
//
//  Example :
//  Input:
//  S = "abcde"
//  words = ["a", "bb", "acd", "ace"]
//  Output: 3
//  Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".
//  Note:
//
//  All words in words and S will only consists of lowercase letters.
//  The length of S will be in the range of [1, 50000].
//  The length of words will be in the range of [1, 5000].
//  The length of words[i] will be in the range of [1, 50].

  public static int numMatchingSubseq(String S, String[] words) {
    char [] arr = S.toCharArray();
    int res = 0;
    for(String s : words){
      char [] brr = s.toCharArray();
      int ai = 0, bi = 0;
      while(ai < arr.length && bi < brr.length){
        if(arr[ai] == brr[bi])
          bi++;
        ai++;
      }
      if(bi == brr.length)
        res++;
    }
    return res;
  }

  public static void main(String[] args) {

  }
}
