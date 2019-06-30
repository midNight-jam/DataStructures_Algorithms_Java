package darkRealm;

public class FindTheCeleberity {
  
//  #277. Find the Celebrity
//  Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. The
//  definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
//
//  Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do
//    is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the
//  celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
//
//  You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function
//  int findCelebrity(n), your function should minimize the number of calls to knows.
//
//  Note: There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a
//  celebrity in the party. If there is no celebrity, return -1.

  public int findCelebrity(int n) {
    // Intuition is we find celebrity in 2 passes
    // In first pass we find the candiate who can be celebrity
    int candidate = 0;
    for(int i = 1; i < n; i++){
      if(knows(candidate, i))
        candidate = i; // keep the last know candidate
    }

    // In second pass for every person who is not candidate
    // We find if he knows our cancdidate, if not then our candidate is not celebrity
    // Or if our candidate knows the current person, in this case also our candidate cannot be celebrity
    // Thus as per problem there can be only one celeberity, if its not we return -1 else the candidata

    boolean knows = true;
    for(int i = 0; i < n; i++){
      if(i == candidate) continue;
      knows = knows(i, candidate) && !knows(candidate, i);
      if(!knows)
        return -1;
    }
    
    return candidate;
  }

  private static boolean knows(int i, int j){
    return true;
  }
  public static void main(String[] args) {
    int n = 5;

  }
}
