/**
 * DynamicNode.java
 * Juan Ariza 
 * 2/20/2019
 * Creates a DynamicNode to be used within a custom linked list.
 * Code provided by the instructor
 */



package Test2;

public class DynamicNode {

  private Object info;
  private DynamicNode next;

  public DynamicNode(Object x, DynamicNode n) {
    info = x;
    next = n;
  }

  public Object getInfo() {
    return info;
  }

  public DynamicNode getNext() {
    return next;
  }

  public void setInfo(Object x) {
    info = x;
  }

  public void setNext(DynamicNode n) {
    next = n;
  }

  public String toString() {
    return info.toString();
  }

}
