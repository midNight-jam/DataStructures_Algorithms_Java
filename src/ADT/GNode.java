package ADT;

/**
 * Created by Jayam on 12/28/2016.
 */
public class GNode {
  public String name;
  public GNode[] childs;
  public Status status;
  private int childsCount;
  public int incomingEdges;

  public GNode(int childs) {
    this.childs = new GNode[childs];
    status = Status.NotProcessed;
  }

  public void addChild(GNode child) {
    childs[childsCount] = child;
    childsCount++;
    child.incomingEdges++;
  }

  public enum Status {
    NotProcessed,
    UnderProcessing,
    Processed
  }

  public void reset() {
    status = Status.NotProcessed;
  }
}