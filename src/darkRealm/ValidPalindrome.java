package darkRealm;

public class ValidPalindrome {

    /*
    * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
    * For example,
    * "A man, a plan, a canal: Panama" is a palindrome.
    * "race a car" is not a palindrome.
    * */
    private static boolean isPalindrome(String str) {
        if (null == str) return false;
        str = str.toLowerCase();
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            while (!isDigitOrLetter(str.charAt(i)) && i < j) i++;
            while (!isDigitOrLetter(str.charAt(j)) && i < j) j--;
            if (str.charAt(j) != str.charAt(i)) return false;
        }
        return true;
    }

    private static boolean isDigitOrLetter(Character ic) {
        return (ic > 47 && ic < 58) || (ic > 64 && ic < 91) || (ic > 96 && ic < 122);
    }

    public static void main(String[] args) {
//        String str = "A man, a plan, a canal: Panama";
//        String str = "race a car";
//        String str = "";
        String str = null;
        boolean res = isPalindrome(str);
        System.out.println("Str : " + str + " \nRes : " + res);
    }
}
