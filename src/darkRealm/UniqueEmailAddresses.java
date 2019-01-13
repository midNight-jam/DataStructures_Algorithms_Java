package darkRealm;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jayam on 1/12/2019.
 */
public class UniqueEmailAddresses {

//  #929 Unique Email Addresses
//
// Every email consists of a local name and a domain name, separated by the @ sign.
//  For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
//  Besides lowercase letters, these emails may contain '.'s or '+'s.
//  If you add periods ('.') between some characters in the local name part of an email address, mail sent there will
//  be forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com" and
//  "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)
//  If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows
//  certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule
//  does not apply for domain names.)
//  It is possible to use both of these rules at the same time.
//  Given a list of emails, we send one email to each address in the list.
//  How many different addresses actually receive mails?
//
//  Example 1:
//  Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
//  Output: 2
//  Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails
//
//  Note:
//
//      1 <= emails[i].length <= 100
//      1 <= emails.length <= 100
//  Each emails[i] contains exactly one '@' character.

  public static int numUniqueEmails(String[] emails) {
    int res = 0;
    if(emails == null || emails.length < 1 || emails.length < 1)
      return res;

    // set for keeping the unique emails
    Set<String> set = new HashSet();

    // index of +plus & @at char
    int pi, ai;

    // buffer to create localname by removing '.'
    StringBuffer sbr = new StringBuffer();

    //domain name
    String domainName;
    String localName;
    String email;

    for(String s : emails){
      pi = s.indexOf('+');
      ai = s.indexOf('@');
      domainName = s.substring(ai);
      localName = s.substring(0, ai);

      // if there is a plus, ignore everything beyond it.
      if(pi > -1){
        localName = s.substring(0, pi);
      }

      sbr.setLength(0); // clear the contents of the buffer

      for(char c : localName.toCharArray()){
        if(c == '.') continue;
        sbr.append(c);
      }
      localName = sbr.toString();


      email = localName + "@" + domainName;
      if(!set.contains(email))
        set.add(email);
    }
    return set.size();
  }

  public static void main(String[] args) {
//    String [] emails = new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
    String [] emails = new String[]{".@.","@+","+@."};
    int res = numUniqueEmails(emails);
    System.out.println("Res : " + res);
  }
}
