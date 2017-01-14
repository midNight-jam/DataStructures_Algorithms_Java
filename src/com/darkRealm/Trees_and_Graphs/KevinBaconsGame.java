package com.darkRealm.Trees_and_Graphs;

import com.darkRealm.Stacks_and_queues.MyQueue;

import java.util.*;

/**
 * Created by Jayam on 1/13/2017.
 */
public class KevinBaconsGame {
  private HashMap<String, HashMap<String, Movie>> adjacencyMap;
  private HashMap<String, Actor> actors;

  public KevinBaconsGame() {
    adjacencyMap = new HashMap<>();
    actors = new HashMap<>();
  }

  public void addEdge(String actor1, String actor2, String movieName, int year) {
    if (actors.containsKey(actor1) && actors.containsKey(actor2)) {
      HashMap<String, Movie> vertex = adjacencyMap.get(actor1);
      Movie movie = new Movie();
      movie.name = movieName;
      movie.year = year;
      vertex.put(actor2, movie);
      vertex = adjacencyMap.get(actor2);
      vertex.put(actor1, movie);  // adding from both ends as its an undirected graph
    }
  }

  public void addActor(String actorName) {
    if (!actors.containsKey(actorName)) {
      Actor actor = new Actor();
      actor.actorName = actorName;
      actors.put(actorName, actor);
      adjacencyMap.put(actorName, new HashMap<>());
    }
  }

  public boolean areConnected(String actor1, String actor2) {
    return adjacencyMap.get(actor1).containsKey(actor2);
  }

  public HashMap<Integer, ArrayList<String>> discoverKevinBaconUniverse(String actor) {
    HashMap<Integer, ArrayList<String>> gameScoreBoard = new HashMap<>();
    MyQueue<AbstractMap.SimpleEntry<Integer, HashMap<String, Movie>>> queue = new MyQueue<>();

    HashMap<String, Movie> mapTrav = adjacencyMap.get("Kevin Bacon");
    Actor actorTrav = actors.get("Kevin Bacon");
    actorTrav.status = Status.UnderProcessing;

    int baconNoTrav = 0;
    AbstractMap.SimpleEntry entryTrav = new AbstractMap.SimpleEntry(baconNoTrav, "Kevin Bacon");
    queue.enqueue(entryTrav);
    String actorTravString = "";
    while (!queue.isEmpty()) {
      entryTrav = queue.deque();
      baconNoTrav = (int) entryTrav.getKey();
      actorTravString = (String) entryTrav.getValue();
      System.out.println("Bacon Number " + baconNoTrav + " Actor : " + actorTravString);


      actorTrav = actors.get(actorTravString);
      actorTrav.status = Status.Processed;

      //update in game board
      if (gameScoreBoard.containsKey(baconNoTrav)) {
        gameScoreBoard.get(baconNoTrav).add(actorTravString);
        gameScoreBoard.put(baconNoTrav, gameScoreBoard.get(baconNoTrav));
      } else {
        ArrayList<String> actorList = new ArrayList<>();
        actorList.add(actorTravString);
        gameScoreBoard.put(baconNoTrav, actorList);
      }

      // fetching the map for next vertices
      mapTrav = adjacencyMap.get(actorTravString);

      for (String key :
          mapTrav.keySet()) {
        actorTrav = actors.get(key);
        if (actorTrav.status == Status.NotProcessed) {
          entryTrav = new AbstractMap.SimpleEntry(baconNoTrav + 1, key);
          queue.enqueue(entryTrav);
          actorTrav.status = Status.UnderProcessing;
        }
      }
    }
    resetActorsStatus();
    return gameScoreBoard;
  }

  private void resetActorsStatus() {
    for (String key :
        actors.keySet()) {
      actors.get(key).status = Status.NotProcessed;
    }
  }

  public int getBaconNumber(String actorName) {
    int actorBaconNumber = Integer.MAX_VALUE;
    if (actors.containsKey(actorName)) {
      MyQueue<AbstractMap.SimpleEntry<Integer, HashMap<String, Movie>>> queue = new MyQueue<>();

      HashMap<String, Movie> mapTrav = adjacencyMap.get("Kevin Bacon");
      Actor actorTrav = actors.get("Kevin Bacon");
      actorTrav.status = Status.UnderProcessing;

      int baconNoTrav = 0;
      AbstractMap.SimpleEntry entryTrav = new AbstractMap.SimpleEntry(baconNoTrav, "Kevin Bacon");
      queue.enqueue(entryTrav);
      String actorTravString = "";
      while (!queue.isEmpty()) {
        entryTrav = queue.deque();
        baconNoTrav = (int) entryTrav.getKey();
        actorTravString = (String) entryTrav.getValue();
        actorTrav = actors.get(actorTravString);
        actorTrav.status = Status.Processed;
        if (actorTravString.equals(actorName)) {
          System.out.println("Found Actor " + actorTravString + " His Bacon Number " + baconNoTrav);
          actorBaconNumber = baconNoTrav;
          return actorBaconNumber;
        }
        // fetching the map for next vertices
        mapTrav = adjacencyMap.get(actorTravString);

        for (String key :
            mapTrav.keySet()) {
          actorTrav = actors.get(key);
          if (actorTrav.status == Status.NotProcessed) {
            entryTrav = new AbstractMap.SimpleEntry(baconNoTrav + 1, key);
            queue.enqueue(entryTrav);
            actorTrav.status = Status.UnderProcessing;
          }
        }
      }
    }
    resetActorsStatus();
    return actorBaconNumber;
  }

  // represents movie(name & year)
  private class Movie {
    String name;
    int year;
  }

  private class Actor {
    String actorName;
    Status status;
    Actor(){
      status = Status.NotProcessed;
    }

    @Override
    public String toString() {
      return " " + actorName + " ";
    }
  }

  private enum Status {
    NotProcessed,
    UnderProcessing,
    Processed
  }
}