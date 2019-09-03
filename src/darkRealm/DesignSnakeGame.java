package darkRealm;

import java.util.*;

public class DesignSnakeGame {
  /**
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

  LinkedList<int[]> body; // ***using LinkedList is Key to this problem***
  int m;
  int n;
  int[][] food;
  int fi;
  Set<String> currSnake;

  /**
   * Initialize your data structure here.
   *
   * @param width  - screen width
   * @param height - screen height
   * @param food   - A list of food positions
   *               E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
   */
  public DesignSnakeGame(int width, int height, int[][] f) {
    food = f;
    m = height;
    n = width;
    fi = 0;
    body = new LinkedList<>();
    body.add(0, new int[]{0, 0});
    currSnake = new HashSet<>();
    currSnake.add("0,0");
  }

  /**
   * Moves the snake.
   *
   * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
   * @return The game's score after the move. Return -1 if game over.
   * Game over when snake crosses the screen boundary or bites its body.
   */
  public int move(String d) {
    int[] curPos = body.get(0);
    int[] newPos = newPos(curPos, d);
    boolean out = outOfGrid(newPos[0], newPos[1]);
    if (out) return -1;

    // delete the tail (oldest part) from body
    int[] tail = body.remove(body.size() - 1);
    currSnake.remove(tail[0] + "," + tail[1]);

    // if colliding with the snake return -1
    if (currSnake.contains(newPos[0] + "," + newPos[1])) return -1;


    // if reaches a food grow back the tail
    if (fi < food.length && food[fi][0] == newPos[0] && food[fi][1] == newPos[1]) {
      body.add(tail);
      currSnake.add(tail[0] + "," + tail[1]);
      fi++;
    }

    // move the head of snake to new position
    body.add(0, newPos);
    currSnake.add(newPos[0] + "," + newPos[1]);

    return fi;
  }

  int[] newPos(int[] curPos, String d) {
    int r = curPos[0];
    int c = curPos[1];

    if (d.equals("U"))
      r = r - 1;
    else if (d.equals("R"))
      c = c + 1;
    else if (d.equals("D"))
      r = r + 1;
    else
      c = c - 1;

    return new int[]{r, c};
  }

  private boolean outOfGrid(int r, int c) {
    return (r < 0 || r >= m || c < 0 || c >= n);
  }

  public static void main(String[] args) {

    int[][] food = new int[][]{{1, 2}, {0, 1}};
    int width = 3;
    int height = 2;
    DesignSnakeGame snakeGame = new DesignSnakeGame(width, height, food);
    System.out.println(snakeGame.move("R"));
    System.out.println(snakeGame.move("D"));
    System.out.println(snakeGame.move("R"));
    System.out.println(snakeGame.move("U"));
    System.out.println(snakeGame.move("L"));
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
