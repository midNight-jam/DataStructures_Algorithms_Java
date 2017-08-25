package darkRealm;

public class JudgeRouteCircle {

//  Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.
//
//  The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.
//
//      Example 1:
//  Input: "UD"
//  Output: true
//  Example 2:
//  Input: "LL"
//  Output: false

  public static boolean judgeCircle(String moves) {
    if (null == moves || 0 == moves.length() || ((moves.length() & 1) != 0))
      return false;
    int vertical = 0, horizontal = 0;
    for (int i = 0; i < moves.length(); i++) {
      if ('U' == moves.charAt(i))
        vertical++;
      else if ('D' == moves.charAt(i))
        vertical--;
      else if ('R' == moves.charAt(i))
        horizontal++;
      else if ('L' == moves.charAt(i))
        horizontal--;
    }
    return 0 == vertical + horizontal;
  }

  public static void main(String[] args) {
//    String moves = "UD";
//    String moves = "LL";
//    String moves = "LLUDRRDULR";
//    String moves = "ULRLLUDRRD";
    String moves = "ULRLLUDRD";
    boolean res = judgeCircle(moves);
    System.out.println("Moves : " + moves + "\nRes : " + res);
  }
}
