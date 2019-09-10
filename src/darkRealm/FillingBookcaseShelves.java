package darkRealm;

import java.util.HashMap;
import java.util.Map;

public class FillingBookcaseShelves {

//  1105. Filling Bookcase Shelves
//  We have a sequence of books: the i-th book has thickness books[i][0] and height books[i][1].
//  We want to place these books in order onto bookcase shelves that have total width shelf_width.
//
//  We choose some of the books to place on this shelf (such that the sum of their thickness is <= shelf_width),
//  then build another level of shelf of the bookcase so that the total height of the bookcase has increased by the
//  maximum height of the books we just put down.  We repeat this process until there are no more books to place.
//
//  Note again that at each step of the above process, the order of the books we place is the same order as the given
//  sequence of books.  For example, if we have an ordered list of 5 books, we might place the first and second book
//  onto the first shelf, the third book on the second shelf, and the fourth and fifth book on the last shelf.
//
//  Return the minimum possible height that the total bookshelf can be after placing shelves in this manner.
//
//      Example 1:
//
//
//  Input: books = [[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]], shelf_width = 4
//  Output: 6
//  Explanation:
//  The sum of the heights of the 3 shelves are 1 + 3 + 2 = 6.
//  Notice that book number 2 does not have to be on the first shelf.
//
//
//      Constraints:
//
//      1 <= books.length <= 1000
//      1 <= books[i][0] <= shelf_width <= 1000
//      1 <= books[i][1] <= 1000

  static Map<String, Integer> map;
  static int[][] books;
  static int W;

  static public int minHeightShelves(int[][] bks, int shelfwidth) {
    if (bks == null || bks.length < 1) return 0;
    books = bks;
    W = shelfwidth;
    map = new HashMap<>();
    return helper(0, W, 0);
  }

  // at each shelf ............. available width, currHeight
  static private int helper(int index, int widthAvail, int currHeight) {
    if (index >= books.length)
      return currHeight;

    // memoized recursion
    String k = index + "," + widthAvail;
    if (map.containsKey(k))
      return map.get(k);

    int res, sameShelf, newShelf;
    sameShelf = newShelf = res = Integer.MAX_VALUE;

    // if we can fit this book on the current shelf
    if (widthAvail - books[index][0] >= 0) {
      // height of the current Shelf will increase
      int newHeight = Math.max(currHeight, books[index][1]);
      sameShelf = helper(index + 1, widthAvail - books[index][0], newHeight);
    }

    // try this book also on a new Shelf... this book takes width, this books height will be the height of shelf
    newShelf = currHeight + helper(index + 1, W - books[index][0], books[index][1]);

    // take the min
    res = Math.min(sameShelf, newShelf);
    map.put(k, res);
    return res;
  }

  public static void main(String[] args) {
    int[][] books = new int[][]{
        {1, 1},
        {2, 3},
        {2, 3},
        {1, 1},
        {1, 1},
        {1, 1},
        {1, 2},
    };

    int w = 5;

    int res = minHeightShelves(books, w);
    System.out.println(res);
    System.out.println(res == 5 ? "Pass" : "Fail");
  }
}
