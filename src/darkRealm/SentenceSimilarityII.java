package darkRealm;

import java.util.HashMap;
import java.util.Map;

public class SentenceSimilarityII {


//  737. Sentence Similarity II
//  Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs
//  pairs, determine if two sentences are similar.
//
//  For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] are similar,
//  if the similar word pairs are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].
//
//  Note that the similarity relation is transitive. For example, if "great" and "good" are similar, and "fine"
//  and "good" are similar, then "great" and "fine" are similar.
//
//  Similarity is also symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.
//
//  Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"],
//  pairs = [] are similar, even though there are no specified similar word pairs.
//
//  Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 = ["great"]
//  can never be similar to words2 = ["doubleplus","good"].
//
//  Note:
//
//  The length of words1 and words2 will not exceed 1000.
//  The length of pairs will not exceed 2000.
//  The length of each pairs[i] will be 2.
//  The length of each words[i] and pairs[i][j] will be in the range [1, 20].


  public static boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
    if (words1 == null || words2 == null || words1.length != words2.length) return false;

    Map<String, String> map = new HashMap<>();

    for (String[] p : pairs) {
      String f = p[0];
      String t = p[1];
      String rootF = "";
      String rootT = "";
      if (!map.containsKey(f))
        map.put(f, t);
      else {
        rootF = root(f, map);
        rootT = map.containsKey(t) ? root(t, map) : "";
        if (!rootF.equals(rootT))
          map.put(rootF, t);
      }
      if (!map.containsKey(t))
        map.put(t, t);
    }

    for (int i = 0; i < words1.length; i++) {
      boolean same = words1[i].equals(words2[i]);
      boolean sameRoot = map.containsKey(words1[i]) && map.containsKey(words2[i]) ?
          root(words1[i], map).equals(root(words2[i], map)) : false;
      if (same || sameRoot)
        continue;
      else return false;
    }
    return true;
  }

  private static String root(String k, Map<String, String> map) {
    while (!k.equals(map.get(k))) {
      k = map.get(k);
    }
    return k;
  }

  public static void main(String[] args) {

    String[] words1 = new String[]{"this", "summer", "thomas", "get", "really", "very", "rich", "and", "have", "any",
        "actually", "wonderful", "and", "good", "truck", "every", "morning", "he", "drives", "an", "extraordinary",
        "truck", "around", "the", "nice", "city", "to", "eat", "some", "extremely", "extraordinary", "food", "as",
        "his", "meal", "but", "he", "only", "entertain", "an", "few", "well", "fruits", "as", "single", "lunch", "he",
        "wants", "to", "eat", "single", "single", "and", "really", "healthy", "life"};

    String[] words2 = new String[]{"this", "summer", "thomas", "get", "very", "extremely", "rich", "and", "possess",
        "the", "actually", "great", "and", "wonderful", "vehicle", "every", "morning", "he", "drives", "unique",
        "extraordinary", "automobile", "around", "unique", "fine", "city", "to", "drink", "single", "extremely",
        "nice", "meal", "as", "his", "super", "but", "he", "only", "entertain", "a", "few", "extraordinary", "food",
        "as", "some", "brunch", "he", "wants", "to", "take", "any", "some", "and", "really", "healthy", "life"};

    String[][] pairs = new String[][]
        {
            {"good", "nice"}, {"good", "excellent"}, {"good", "well"}, {"good", "great"}, {"fine", "nice"},
            {"fine", "excellent"}, {"fine", "well"}, {"fine", "great"}, {"wonderful", "nice"},
            {"wonderful", "excellent"}, {"wonderful", "well"}, {"wonderful", "great"}, {"extraordinary", "nice"},
            {"extraordinary", "excellent"}, {"extraordinary", "well"}, {"extraordinary", "great"}, {"one", "a"},
            {"one", "an"}, {"one", "unique"}, {"one", "any"}, {"single", "a"}, {"single", "an"}, {"single", "unique"},
            {"single", "any"}, {"the", "a"}, {"the", "an"}, {"the", "unique"}, {"the", "any"}, {"some", "a"},
            {"some", "an"}, {"some", "unique"}, {"some", "any"}, {"car", "vehicle"}, {"car", "automobile"},
            {"car", "truck"}, {"auto", "vehicle"}, {"auto", "automobile"}, {"auto", "truck"}, {"wagon", "vehicle"},
            {"wagon", "automobile"}, {"wagon", "truck"}, {"have", "take"}, {"have", "drink"}, {"eat", "take"},
            {"eat", "drink"}, {"entertain", "take"}, {"entertain", "drink"}, {"meal", "lunch"}, {"meal", "dinner"},
            {"meal", "breakfast"}, {"meal", "fruits"}, {"super", "lunch"}, {"super", "dinner"}, {"super", "breakfast"},
            {"super", "fruits"}, {"food", "lunch"}, {"food", "dinner"}, {"food", "breakfast"}, {"food", "fruits"},
            {"brunch", "lunch"}, {"brunch", "dinner"}, {"brunch", "breakfast"}, {"brunch", "fruits"}, {"own", "have"},
            {"own", "possess"}, {"keep", "have"}, {"keep", "possess"}, {"very", "super"}, {"very", "actually"},
            {"really", "super"}, {"really", "actually"}, {"extremely", "super"}, {"extremely", "actually"}};


    boolean res = areSentencesSimilarTwo(words1, words2, pairs);
    System.out.println(res);
  }
}
