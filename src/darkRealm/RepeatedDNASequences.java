package darkRealm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences {

//  187. Repeated DNA Sequences
//  All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
//  When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
//
//  Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
//
//  Example:
//
//  Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//
//  Output: ["AAAAACCCCC", "CCCCCAAAAA"]

  public static List<String> findRepeatedDnaSequences(String s) {
    List<String> res = new ArrayList<>();
    if (s == null || s.length() < 10) return res;
    StringBuilder sbr = new StringBuilder();
    int tail = 0;
    while (sbr.length() < 10)
      sbr.append(s.charAt(tail++));
    Map<String, Integer> map = new HashMap<>();
    map.put(sbr.toString(), 1);
    int N = s.length();
    while (tail < N) {
      sbr.append(s.charAt(tail));
      sbr.deleteCharAt(0);
      tail++;
      String k = sbr.toString();
      if (!map.containsKey(k))
        map.put(k, 1);
      else
        map.put(k, map.get(k) + 1);
    }

    for (String k : map.keySet())
      if (map.get(k) > 1)
        res.add(k);

    return res;
  }

  public static void main(String[] args) {
    String dna = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
    List<String> res = findRepeatedDnaSequences(dna);
    System.out.println(dna);
    for (String s : res)
      System.out.println(s);
  }
}
