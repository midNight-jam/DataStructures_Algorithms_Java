package darkRealm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight {

//  #406. Queue Reconstruction by Height
//  Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
//      Note:
//  The number of people is less than 1,100.
//  Example
//  Input:
//      [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//  Output:
//      [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]


  public static int[][] reconstructQueue(int[][] ppl) {
    if(ppl == null || ppl.length < 1 || ppl[0].length < 1) return ppl;
    int[][] res = new int[ppl.length][2];

    // Intuition is to sort people based on height in descending
    // and if their hieght matches then on their position in ascending
    // Why sort based on height in descending, because we utilize the linked list DS ability to push elements further
    // if there is an element already on that index.
    // Linkedlist works for as inserting the people in the correct position

    Arrays.sort(ppl, new Comparator<int[]>(){
      public int compare(int [] o1, int [] o2){
        int h1 = o1[0], h2 = o2[0];
        int p1 = o1[1], p2 = o2[1];

        if(h1 > h2) return -1;
        else if(h1 < h2) return 1;

        if(p1 < p2) return -1;
        else if(p1 > p2) return 1;

        return 0;
      }
    });

    LinkedList<int[]> ll = new LinkedList<>();

    for(int [] hp : ppl){
      int pos = hp[1];
      ll.add(pos, hp);
    }

    for(int i = 0; i < res.length; i++){
      res[i] = ll.get(i);
    }

    return res ;
  }

  public static void main(String[] args) {
//    int[][] people = new int[][]{
//        {5, 0}, {7, 0}, {5, 2}, {6, 1}, {4, 4}, {7, 1}
//    };

    int[][] people = new int[][]{
        {8, 2},
        {4, 2},
        {4, 5},
        {2, 0},
        {7, 2},
        {1, 4},
        {9, 1},
        {3, 1},
        {9, 0},
        {1, 0}
    };
    int[][] res = reconstructQueue(people);
    for (int[] p : res)
      System.out.println(Arrays.toString(p));
  }
}