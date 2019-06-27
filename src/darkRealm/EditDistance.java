package darkRealm;

public class EditDistance {

//  #72. Edit Distance
//  Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
//  You have the following 3 operations permitted on a word:
//  a) Insert a character
//  b) Delete a character
//  c) Replace a character
  
  
  public static int minDistance(String word1, String word2) {
     if(word1 == null || word2 == null) return  0;

    int l1 = word1.length();
    int l2 = word2.length();
    char [] arr = word1.toCharArray();
    char [] brr = word2.toCharArray();
    int [][] dp = new int[l1 + 1][l2 + 1]; // + 1 beaucse in matrix first row+col will be for empty string

    // "" because first row & col are empty string, & the edits required to make an empty string a new string is equal
    // to the length of the string
    for(int i = 0; i <= l1; i++)
      dp[i][0] = i;

    for(int j = 0; j <= l2; j++)
      dp[0][j] = j;

    for(int i = 1; i <= l1; i++){
      for(int j = 1; j <= l2; j++){
        if(arr[i-1] == brr[j-1]){ // if same char then dont update the distance, take from prev
          dp[i][j] = dp[i-1][j-1];
          continue;
        }
        // we delete c1 from word2, thus dist from above + 1
        int deleteFromW1 = dp[i][j-1] + 1;
        // we insert c2 in word1, thus dist from left + 1
        int insertIntoW1 =  dp[i-1][j] + 1;
        // we replace the char
        int replace = dp[i-1][j-1] + 1;
        int move = Math.min(Math.min(deleteFromW1, insertIntoW1), replace);
        dp[i][j] = move;
      }
    }

    return dp[l1][l2];
  }

  public static int minDistanceDETAILED(String w1, String w2) {
    if (w1 == null || w2 == null) return 0;
    int l1 = w1.length(), l2 = w2.length();
    int[][] dp = new int[l1 + 1][l2 + 1];
    char c1, c2;
    int insertDist, deleteDist, replaceDist;
    // Intuition is we use DP on any char x from w1 and xhar y from w2, there are 3 possible operations, either we delete
    // or we insert or we replace that char and use the min dist required to decide which opertaion to do
    // because for w1 to become w2 it will need these modifications, for ex a -> abcde, 4 inserts so addd values for first row
    for (int i = 0; i <= l1; i++)
      dp[i][0] = i;
    // because for w2 to become w1 it will need these modifications, for ex abcde -> a, 4 deletes so addd values for first col
    for (int j = 0; j <= l2; j++)
      dp[0][j] = j;

    for (int i = 0; i < l1; i++) {
      c1 = w1.charAt(i);
      for (int j = 0; j < l2; j++) {
        c2 = w2.charAt(j);
        // if same char, take dist from diagonal, that is no change in distance
        if (c1 == c2)
          // we are pushing the dist ahead instead of taking dist from behind for edge cases(empty/same string)
          // means instead of updating value at i,j by using value from i-1, j-1,
          // we do opposite, update value of i + 1, j+ 1 sing value from i, j
          dp[i + 1][j + 1] = dp[i][j];
          // else chars are diff, take min dist among 3 possiblities : insert, delete, replace
        else {
          // we replace c1 with c2, thus dist from diagonal + 1
          replaceDist = dp[i][j] + 1;
          // we insert c2 in word1, thus dist from left + 1
          insertDist = dp[i][j + 1] + 1;
          // we delete c1 from word2, thus dist from above + 1
          deleteDist = dp[i + 1][j] + 1;
          // use min dist among 3 possible operations and push result ahead
          dp[i + 1][j + 1] = Math.min(Math.min(insertDist, deleteDist), replaceDist);
        }
      }
    }
    return dp[l1][l2];
  }
  
  

  public static void main(String[] args) {
//    String w1 = "cable";
//    String w2 = "cattle";

//    String w1 = "called";
//    String w2 = "install";

//    String w1 = "a";
//    String w2 = "b";

//    String w1 = "";
//    String w2 = "a";

    String w1 = "a";
    String w2 = "a";


    int ops = minDistance(w1, w2);
    System.out.println("w1 : " + w1);
    System.out.println("w2 : " + w2);
    System.out.println("o  : " + ops);
  }
}
