package com.darkRealm;

import java.io.IOException;

/*
* Uncomment a function to run, each is a method for solved problem.
* Testing ignored files settings*/
public class Main {

  public static void main(String[] args) {
    try {
      DarkLogger.setup();
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Some thing went wrong while settting up logs");
    }
    // write your code here, testing after new git
//    doArray_and_Strings_Main();
    doStack_and_Queue();
  }

  private static void doArray_and_Strings_Main() {
//        Arrays_and_Strings_Main.doIsUnique();
//        Arrays_and_Strings_Main.doCheckPerm();
//        Arrays_and_Strings_Main.doCheckPermPalindrome();
    Arrays_and_Strings_Main.doCompresssion();
  }

  private static void doStack_and_Queue() {
//    Stack_and_Queues_Main.testMyStack();
//    Stack_and_Queues_Main.testMinStack();
    Stack_and_Queues_Main.testSortStack();
  }
}