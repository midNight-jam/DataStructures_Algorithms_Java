package darkRealm.CTCI.Sorting_and_Searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Jayam on 3/4/2017.
 */
public class BucketSortUtil {
  public static void dobucketSort(int[] arr) {
    int sqLen = (int) Math.sqrt(arr.length);
    int max = arr[0];
    for (int i : arr)
      max = Math.max(max, i);

    List<Integer>[] buckets = new List[sqLen];
    for (int i = 0; i < buckets.length; i++)
      buckets[i] = new ArrayList<>();

    for (int i = 0; i < arr.length; i++) {
      int hash = i / (max * (sqLen - 1));
      buckets[hash].add(arr[i]);
    }
    for (List b : buckets)
      Collections.sort(b);

    int index = 0;
    for (int i = 0; i < buckets.length; i++)
      for (int j = 0; j < buckets[i].size(); j++)
        arr[index++] = buckets[i].get(j);

    System.out.println(Arrays.toString(arr));
  }
}