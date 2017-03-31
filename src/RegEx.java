import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jayam on 3/30/2017.
 */
public class RegEx {
  /*

  // Characer classes

  .  : Dot any char
  \d : a digit [0:9]
  \D : a non digit [^0-9]
  \s : a white space
  \S : a non white space [^\s]
  \w : a word character [a-zA-Z_0-9]
  \W : a non word character [^\w]

    // Quantifiers

   * : 0 or more times
   + : 1 or more times
   ? : 0 or 1 times only
  {n}:  exactly n times
 {n,}:  atleast n times
{n,m} : atleastn but no more than m times

  // Meta Characters

  \ : escape the next cahracter
  ^ : Match the begining of the line
  . : any cha rexcept new line
  $ : end of the line, before new line at end
  | : or
 () : Grouping
 [] : Custom Class

   */

  public static void main(String[] args) {
    List<String> input = new ArrayList<>();
    input.add("123-45-6789");
    input.add("9876-5-4321");
    input.add("987-65-4321 (attack)");
    input.add("987-65-4321 ");
    input.add("192-83-7465");

    // Matching | Validating
    for (String ssn : input)
      if (ssn.matches("^(\\d{3}-?\\d{2}-?\\d{4})$"))
        System.out.println(ssn);


    // Extracting  | Capturing
    String inputStr = "I have a cat, but I like my dog better.";

    Pattern pattern = Pattern.compile("(mouse|cat|dog)");
    Matcher matcher = pattern.matcher(inputStr);
    while (matcher.find())
      System.out.println("Found a : " + matcher.group());


    // Modifying | Substitution | Masking
    String userLog =
        "User clientId=23421. Some more text clientId=33432. This clientNum=100";

    Pattern p = Pattern.compile("(clientId=)(\\d+)");
    Matcher m = p.matcher(userLog);

    StringBuffer result = new StringBuffer();
    while (m.find()) {
      System.out.println("Masking: " + m.group(2));
      m.appendReplacement(result, m.group(1) + "***masked***");
    }
    m.appendTail(result);
    System.out.println(result);


  }
}
