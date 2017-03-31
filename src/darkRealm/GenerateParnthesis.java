package darkRealm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jayam on 3/31/2017.
 */
public class GenerateParnthesis {

  static char [] output;
  static List<String> results;

  private static void permutePara(int leftRem, int rightRem, int index) {
    if (leftRem == 0 && rightRem == 0){
      results.add(String.copyValueOf(output));
      return;
    }
    if (leftRem > 0) {
      output[index] = '(';
      permutePara(leftRem - 1, rightRem, index + 1);
    }
    if (rightRem > leftRem) {
      output[index] = ')';
      permutePara(leftRem, rightRem - 1, index + 1);
    }
  }

  public static List<String> generateParanthesis(int n) {
    if (n < 1) return new ArrayList<>();
    int leftRem, rightRem;
    leftRem = rightRem = n;
    int index = 0;
    permutePara(leftRem,rightRem,index);
    return results;
  }

  public static void main(String [] args){
    int n = 3;
    output = new char[n * 2];
    results = new ArrayList<>();

    List<String> permuations = generateParanthesis(n);
    System.out.println(permuations);
  }
}
