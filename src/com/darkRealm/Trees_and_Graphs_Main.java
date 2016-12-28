package com.darkRealm;

import com.darkRealm.Trees_and_Graphs.Trees_and_Graphs;

/**
 * Created by Jayam on 12/27/2016.
 */
public class Trees_and_Graphs_Main {

  public static void testBFSAndDFS() {
    Trees_and_Graphs.doBFSAndDFS();
  }

  public static void testIsRoutePresentBetweenNodes(){
    Trees_and_Graphs.isRoutePresentBetweenNodes();
  }

  public static void testMinimalHeightTree(){
    int [] arr= new int[]{2,5,7,10,19,20,25};
    Trees_and_Graphs.createMinimalHeightTree(arr);
  }
}
