package com.darkRealm;

import com.darkRealm.Moderate.Moderate;

/**
 * Created by Jayam on 1/23/2017.
 */
public class Moderate_Main {

  public static void testNumberSwapper(){
    Moderate.numberSwapper(7,3);
  }

  public static void testWordFrequency(){
    String[] book =  new String[]{"this", "is","some","book", "this"};
    int count = Moderate.wordFrequency(book,"this");
    System.out.println("book count : "+count);
  }

}
