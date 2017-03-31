package darkRealm;

/**
 * Created by Jayam on 3/31/2017.
 */
public class IntegerToRoman {

  public static String intToRoman(int n) {
    String [] M = new String[]{"","M","MM","MMM","MMMM"};
    String [] C = new String[]{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
    String [] X = new String[]{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    String [] I = new String[]{"","I","II","III","IV","V","VI","VII","VIII","IX"};

    return M[n/1000] + C[(n/1000)%100] + X[(n/100)%10] + I[n%10];
  }

  public static void main(String[] args) {
    int n = 123;
    System.out.println("N : "+n + "Roamn : "+intToRoman(n));
  }
}
