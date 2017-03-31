package darkRealm;

/**
 * Created by Jayam on 3/31/2017.
 */
public class RomanToInt {

  public static int romanToInt(String str) {
    int[] nums = new int[str.length()];
    for (int i = 0; i < str.length(); i++) {
      switch (str.charAt(i)) {
        case 'M':
          nums[i] = 1000;
          break;
        case 'D':
          nums[i] = 500;
          break;
        case 'C':
          nums[i] = 100;
          break;
        case 'L':
          nums[i] = 50;
          break;
        case 'X':
          nums[i] = 10;
          break;
        case 'V':
          nums[i] = 5;
          break;
        case 'I':
          nums[i] = 1;
          break;
      }
    }

    int res = 0;
    for (int i = 0; i < str.length() - 1; i++)
      if (nums[i] < nums[i + 1])
        res = res - nums[i];
      else
        res = res + nums[i];


    res = res + nums[nums.length - 1]; // adding the last value
    return res;
  }

  public static void main(String[] args) {
//    String roman = "MMMDLXXXVI";
    String roman = "IXVI";
    int res = romanToInt(roman);
    System.out.println("Roman :" + roman + " Int : " + res);
  }
}
