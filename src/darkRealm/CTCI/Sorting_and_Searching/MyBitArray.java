package darkRealm.CTCI.Sorting_and_Searching;

/**
 * Created by Jayam on 1/23/2017.
 */
public class MyBitArray {
  byte[] byteArr;
  int capacity;

  public MyBitArray(int cap) {
    capacity = cap;
    byteArr = new byte[(int) Math.ceil(capacity / 8)];
  }

  public void set(int pos) {
    pos = pos - 1;
    int arrPos = (int) Math.floor(pos / 8);
    int index = (pos % 8);
    int iBit = 1 << index;
    byteArr[arrPos] = (byte) (byteArr[arrPos] | iBit);
  }

  public boolean get(int pos) {
    pos = pos - 1;
    int arrPos = (int) Math.floor(pos / 8);
    int index = (pos % 8);
    byte bth = byteArr[arrPos];
    int i = ((bth >>> index) & 1);
    return i == 1 ? true : false;
  }
}