package darkRealm;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SnapShotArray {

//  1146. Snapshot Array
//  Implement a SnapshotArray that supports the following interface:
//
//  SnapshotArray(int length) initializes an array-like data structure with the given length.
//  Initially, each element equals 0.
//  void set(index, val) sets the element at the given index to be equal to val.
//  int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
//  int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id
//
//
//  Example 1:
//
//  Input: ["SnapshotArray","set","snap","set","get"]
//      [[3],[0,5],[],[0,6],[0,0]]
//  Output: [null,null,0,null,5]
//  Explanation:
//  SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
//  snapshotArr.set(0,5);  // Set array[0] = 5
//  snapshotArr.snap();  // Take a snapshot, return snap_id = 0
//  snapshotArr.set(0,6);
//  snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5
//
//
//  Constraints:
//
//  1 <= length <= 50000
//  At most 50000 calls will be made to set, snap, and get.
//  0 <= index < length
//  0 <= snap_id < (the total number of times we call snap())
//  0 <= val <= 10^9



  /*
   *  The idea is with given the history, the 2d array behaves a 3d structre in which 3d dimension is snapshot(history).
   *  As each element will have its own history we create the list/array of TreeMaps.
   *  Why treemaps, bcoz they hv a ability floorKey, floorKey() method is used to return the greatest key less
   *  than or equal to given key from the parameter. Which means if we hv a history of 10 iterations on a index & we want its
   *  val on 4th history, flooryKey when passed this snapId will return us 4, if we try to get 200th histiry floorKey
   *  will return us 10
   * */


  static class SnapshotArray {
    int snapId;
    List<TreeMap<Integer, Integer>> list;

    public SnapshotArray(int len) {
      snapId = 0;
      list = new ArrayList<>();
      for (int i = 0; i < len; i++) {
        list.add(new TreeMap<>());
        list.get(i).put(0, 0); // because for all indexes default value is 0 for snapId 0
      }
    }

    public void set(int index, int val) {
      list.get(index).put(snapId, val);
    }

    public int snap() {
      return snapId++;
    }

    public int get(int index, int snap_id) {
      TreeMap<Integer, Integer> map = list.get(index);
      return map.get(map.floorKey(snap_id));
    }
  }

  public static void main(String[] args) {
    SnapshotArray sarr = new SnapshotArray(3);
    sarr.set(0, 5);
    sarr.set(1, 33);
    int snapId = sarr.snap();
    System.out.println("snapId : " + snapId);
    sarr.set(0, 6);
    snapId = sarr.snap();
    System.out.println("snapId : " + snapId);
    for (int i = 0; i < 3; i++)
      System.out.print(sarr.get(0, i) + "  ");
    System.out.println();
    for (int i = 0; i < 3; i++)
      System.out.print(sarr.get(1, i) + "  ");
    System.out.println();
    sarr.set(0, 7);
    sarr.set(0, 8);
    snapId = sarr.snap();
    System.out.println("snapId : " + snapId);
    for (int i = 0; i < 13; i++)
      System.out.print(sarr.get(0, i) + "  ");
    System.out.println();
    for (int i = 0; i < 3; i++)
      System.out.print(sarr.get(1, i) + "  ");
    System.out.println();
  }
}
