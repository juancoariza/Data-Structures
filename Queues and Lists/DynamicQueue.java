package Test2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DynamicQueue {

  private DynamicNode front, rear;
  final int QUEUESIZE = 4; // QUEUESIZE is an artificial limiter for the queue, used in a priority queue
  int counter = 0;        // used to compare values in queue compared to the QUEUESIZE

  public DynamicQueue() {
    front = rear = null;
  }

  public boolean empty() {
    return (front == null);
  }

  // insert to list rear (insert last element)
  public void insert(Object x) {
    DynamicNode p = new DynamicNode(x, null);

    if (empty()) {
      front = rear = p;
    } else {
      rear.setNext(p);
    }

    rear = p;
  }

  // remove from the front of the list (delete first element)
  public Object remove() {
    if (empty()) {
      System.out.println("Queue underflow");
      System.exit(1);
    }
    DynamicNode p = front;
    Object temp = p.getInfo();
    front = p.getNext();

    if (front == null) {
      rear = null;
    }
    return temp;
  }

  // deletes specified element from queue
  public void delete(Object x) {
    DynamicNode p = front, q = rear, before = null, after = null;
    int counter = 0;

    if (empty()) {
      System.out.println("Empty queue. Cannot delete.");
      System.exit(1);

    }

    while (p != rear) {
      if (p.getNext().getInfo().equals(x)) {
        System.out.println("value found: " + p.getNext().getInfo());
        before = p;   // stores value before Element to delete
        after = p.getNext().getNext();
        before.setNext(after);
        print();
      }

      p = p.getNext();

    }
  }

  public void print() {
    if (front == null) {
      System.out.println("null");
    }
    DynamicNode p = front;
    while (p != null) {
      System.out.print(p.getInfo() + ((p.getNext() != null) ? "," : ""));
      p = p.getNext();
    }
    System.out.println();

  }

  public static void main(String args[]) {
    DynamicQueue queue = new DynamicQueue();
    DynamicQueue test = new DynamicQueue();

    //insert a, b, c, d
    queue.insert('a');
    queue.insert('b');
    queue.insert('c');
    queue.insert('d');

    //test values for delete() method
    test.insert('z');
    test.insert('x');
    test.insert('c');
    test.insert('v');

    //remove and print the elements in queue

    // import print method from DynamicList
    System.out.println("Returning the queue, then result after removal...");
    queue.print();
    queue.remove();
    queue.print();

    // alternatively, print the result of the remove() method
    System.out.println("Returning the removed element...");
    System.out.println(queue.remove());

    System.out.println("Returning the test queue...");
    test.print();
    test.delete('c');

  }
}
