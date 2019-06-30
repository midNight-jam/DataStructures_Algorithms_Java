package darkRealm;

public class StrobogrammaticNumber {

  public static boolean isStrobogrammatic(String nums) {
    if(nums == null || nums.length() < 1) return false;
    char [] arr = nums.toCharArray();
    int left = 0 , right = arr.length - 1;
    String valids = "018";
    while(left <= right){
      if(arr[left] == arr[right] && valids.indexOf(arr[left]) > -1){
        left++;
        right--;
      }
      else if((arr[left] == '6' && arr[right] == '9') || (arr[left] == '9' && arr[right] == '6')){
        left++;
        right--;
      }
      else return false;
    }
    return true;
  }

  public static void main(String[] args) {
    String num = "61019";
    boolean res = isStrobogrammatic(num);
    System.out.println("N : " + num);
    System.out.println("B : " + res);
  }
}
