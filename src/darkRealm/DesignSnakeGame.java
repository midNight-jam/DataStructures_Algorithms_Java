package darkRealm;

import java.util.*;

public class DesignSnakeGame {
  /**
   * TODO this is incomplete I am stuck at a test case, dont use this guy as of now
   * 353. Design Snake Game
   * Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are
   * not familiar with the game.
   * <p>
   * The snake is initially positioned at the top left corner (0,0) with length = 1 unit.
   * <p>
   * You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's
   * score both increase by 1.
   * <p>
   * Each food appears one by one on the screen. For example, the second food will not appear until the first food was
   * eaten by the snake.
   * <p>
   * When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.
   * <p>
   * Example:
   * <p>
   * Given width = 3, height = 2, and food = [[1,2],[0,1]].
   * <p>
   * Snake snake = new Snake(width, height, food);
   * <p>
   * Initially the snake appears at position (0,0) and the food at (1,2).
   * <p>
   * |S| | |
   * | | |F|
   * <p>
   * snake.move("R"); -> Returns 0
   * <p>
   * | |S| |
   * | | |F|
   * <p>
   * snake.move("D"); -> Returns 0
   * <p>
   * | | | |
   * | |S|F|
   * <p>
   * snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )
   * <p>
   * | |F| |
   * | |S|S|
   * <p>
   * snake.move("U"); -> Returns 1
   * <p>
   * | |F|S|
   * | | |S|
   * <p>
   * snake.move("L"); -> Returns 2 (Snake eats the second food)
   * <p>
   * | |S|S|
   * | | |S|
   * <p>
   * snake.move("U"); -> Returns -1 (Game over because snake collides with border)
   */

  Queue<int[]> que;
  int[][] food;
  int[] headPos;
  Set<String> set;
  int foodIndex;
  int row;
  int col;

  public DesignSnakeGame(int width, int height, int[][] _food) {
    que = new LinkedList<>();
    row = height;
    col = width;
    food = _food;
    set = new HashSet<>();
    headPos = new int[]{0, 0};
    set.add(Arrays.toString(headPos));
    que.add(headPos);
  }

  public int move(String dir) {
    if (dir == null || "ULDR".indexOf(dir) < 0)
      return -1;

    int[] newHead = newPos(headPos, dir);
    if (inWall(newHead) || inSelf(newHead))
      return -1;

    que.offer(newHead);
    set.add(Arrays.toString(newHead));
    headPos = newHead;

    if (isFood(newHead)) {
      foodIndex++;
    } else { // if not food reduce the length
      int[] oldTail = que.poll();
      set.remove(Arrays.toString(oldTail));
    }

    return foodIndex;
  }

  private boolean isFood(int[] newHead) {
    return (foodIndex < food.length && newHead[0] == food[foodIndex][0] && newHead[1] == food[foodIndex][1]);
  }

  private boolean inSelf(int[] newHead) {
    String np = Arrays.toString(newHead);
    return set.contains(np);
  }

  private boolean inWall(int[] newHead) {
    return (newHead[0] < 0 || newHead[0] >= row || newHead[1] < 0 || newHead[1] >= col);
  }

  private int[] newPos(int[] _head, String d) {
    int[] head = new int[2];
    head[0] = _head[0];
    head[1] = _head[1];

    if (d.equals("U"))
      head[0] = head[0] - 1;
    else if (d.equals("R"))
      head[1] = head[1] + 1;
    else if (d.equals("D"))
      head[0] = head[0] + 1;
    else if (d.equals("L"))
      head[1] = head[1] - 1;
    return head;
  }

  public static void main(String[] args) {
    int[][] food = new int[][]{{1, 2}, {0, 1}, {0, 0}};
    int width = 3;
    int height = 2;
    DesignSnakeGame snakeGame = new DesignSnakeGame(width, height, food);
    System.out.println(snakeGame.move("R"));
    System.out.println(snakeGame.move("D"));
    System.out.println(snakeGame.move("R"));
    System.out.println(snakeGame.move("U"));
    System.out.println(snakeGame.move("L"));
    System.out.println(snakeGame.move("L"));
    System.out.println(snakeGame.move("D"));
    System.out.println(snakeGame.move("R"));
    System.out.println(snakeGame.move("U"));

//    int[][] food = new int[][]{{1, 2}, {0, 1}, {0, 0}};
//    int width = 3;
//    int height = 2;
//    DesignSnakeGame snakeGame = new DesignSnakeGame(width, height, food);
//    System.out.println(snakeGame.move("R"));
//    System.out.println(snakeGame.move("D"));
//    System.out.println(snakeGame.move("R"));
//    System.out.println(snakeGame.move("U"));
//    System.out.println(snakeGame.move("L"));
//    System.out.println(snakeGame.move("L"));
//    System.out.println(snakeGame.move("D"));
//    System.out.println(snakeGame.move("R"));
//    System.out.println(snakeGame.move("U"));

    /*
    * ["SnakeGame","move","move","move","move","move","move", "move"]
[[3,2,[[1,2],[0,1],[0,0]]],["R"],["D"],["R"],["U"],["L"],["L"],["D"]]
    * */
  }
}
