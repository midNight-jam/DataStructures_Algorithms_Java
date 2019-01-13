package darkRealm;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jayam on 1/12/2019.
 */
public class UniqueEmailAddresses {

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
