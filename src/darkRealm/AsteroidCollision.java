package darkRealm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class AsteroidCollision {

//  735. Asteroid Collision
//  We are given an array asteroids of integers representing asteroids in a row.
//
//  For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
//
//  Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
//
//  Example 1:
//  Input:
//  asteroids = [5, 10, -5]
//  Output: [5, 10]
//  Explanation:
//  The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
//  Example 2:
//  Input:
//  asteroids = [8, -8]
//  Output: []
//  Explanation:
//  The 8 and -8 collide exploding each other.
//  Example 3:
//  Input:
//  asteroids = [10, 2, -5]
//  Output: [10]
//  Explanation:
//  The 2 and -5 collide resulting in -5.  The 10 and -5 collide resulting in 10.
//  Example 4:
//  Input:
//  asteroids = [-2, -1, 1, 2]
//  Output: [-2, -1, 1, 2]
//  Explanation:
//  The -2 and -1 are moving left, while the 1 and 2 are moving right.
//  Asteroids moving the same direction never meet, so no asteroids will meet each other.
//      Note:
//
//  The length of asteroids will be at most 10000.
//  Each asteroid will be a non-zero integer in the range [-1000, 1000]..


  public static int[] asteroidCollision(int[] astr) {
    if (astr == null || astr.length < 2) return astr;
    Stack<Integer> stack = new Stack<>();
    int curr, cab;
    
    // collisions occur only for a +ve followed by a -ve
    for (int i = 0; i < astr.length; i++) {
      curr = astr[i];
      // if positive or 0 push & move
      if (curr > -1) {
        stack.push(curr);
        continue;
      }

      cab = Math.abs(curr);
      // if there is a positive on stack which is weaker than the -ve pop it
      while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < cab)
        stack.pop();

      // there are no elements in stack or has a -ve on top then push
      if (stack.isEmpty() || stack.peek() < 0)
        stack.push(curr);
      
      // if there is an equal +ve on the stack pop that one too
      else if (stack.peek() == cab)
        stack.pop();
      
    }

    int[] res = new int[stack.size()];
    int i = res.length - 1;
    while (!stack.isEmpty()) {
      res[i--] = stack.pop();
    }

    return res;
  }
  
  
  public static int[] asteroidCollisionOLD(int[] astr) {
    if(astr == null || astr.length < 1) return astr;

    // This solutions uses extra space in terms of stack + set, i think we can avoid this & do without any extra space
    // by just using a list. But I am keeping that for future improvements :P

    Stack<Integer[]> left = new Stack<>();
    Stack<Integer[]> right = new Stack<>();

    Set<Integer> set = new HashSet();
    for(int i = 0; i < astr.length; i++){

      // Left going asteroid
      if(astr[i] < 0){
        int a = Math.abs(astr[i]);
        while(right.size() > 0 && a != 0){
          Integer [] r = right.peek();
          int ra = r[0];
          int ri = r[1];

          if(ra == 0) break; // seems like 0 asteroid is indestructible

          if(a > ra){
            right.pop();
            set.add(ri);
          }
          else if(a < ra){
            a = 0;
            set.add(i);
          }
          else{
            a = 0;
            right.pop();
            set.add(ri);
            set.add(i);
          }
        }

        // left still surviving
        if(a != 0)
          left.push(new Integer[] {astr[i], i});
      }

      // right going asteroid
      else
        right.push(new Integer[] {astr[i], i});
    }

    int [] res = new int[astr.length - set.size()];
    int j = 0;
    for(int i = 0; i < astr.length; i++){
      if(set.contains(i)) continue;
      res[j++] = astr[i];
    }
    return res;
  }

  public static void main(String[] args) {
    int [] asteroids = new int[] {0 ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0, 1000, 2, 3, 7,-99, 0, 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0 ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0, 1000, 2, 3, 7,-99, 0, 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0 ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0, 1000, 2, 3, 7,-99, 0, 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0 ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0, -1000, 2, 3, 7,-99, 0, 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0 ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0, 1000, 2, 3, 7,-99, 0, 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0 ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0, 1000, 2, 3, 7,-99, 0, 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0 ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0, 1000, 2, 3, 7,-99, 0, 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0 ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0, 1000, 2, 3, 7,-99, 0, 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0 ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0, 1000, 2, 3, 7,-99, 0, 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

    int [] res = asteroidCollision(asteroids);
    System.out.println(Arrays.toString(res));
  }
}
