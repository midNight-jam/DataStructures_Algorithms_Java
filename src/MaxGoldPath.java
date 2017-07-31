import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jayam on 5/4/2017.
 */
public class MaxGoldPath {

  static int [][] matrxi = new int[][]{
      {0,1,1},
      {0,0,0},
      {0,1,1},
  };
  static int rows = matrxi.length;
  static int cols = matrxi[0].length;
  static int max_gold = 0;
  static Map<Integer, List<String>> map = new HashMap<>();

  private static class holder{
    int gold = 0;
    String path = "";
    holder(){}
    holder(int g, String p){
      gold = g;
      path = p;
    }
    public String toString(){
      return ""+gold+" : "+path;
    }
  }

  public static holder findGold(int x, int y){
    if(x >= rows || y >= cols)
      return new holder();
    if(matrxi[x][y] == -1)
      return new holder();
    holder right = findGold(x, y+ 1);
    holder  bottom = findGold(x +1 , y);
    int max = Math.max(right.gold, bottom.gold) + matrxi[x][y];
    String path ="";
    if(right.gold > bottom.gold)
      path = right.path;
    else
      path = bottom.path;

    String strp = "("+x+","+y+")";
    path += strp;
    if(map.containsKey(max))
      map.get(max).add(path);
    else{
      List<String> list = new ArrayList<>();
      list.add(path);
      map.put(max, list);
    }
   return new holder(max,path);
  }

  public static void main(String [] args){
    holder res = findGold(0,0);
    System.out.println(res.gold);
    System.out.println(res.path);
    for(int k  : map.keySet())
      System.out.println(k +" : "+ map.get(k));
  }
}
