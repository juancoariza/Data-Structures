package Test2;

public class ArrayObjectQueue {

  private final int MAXQUEUE = 100;
  private Object[] items;
  private int front, rear;

  public ArrayObjectQueue() {
    items = new Object[MAXQUEUE];
    front = MAXQUEUE - 1;
    rear = MAXQUEUE - 1;
  }

  public boolean empty() {
    return (front == rear);
  }

  public Object remove() {
    if(empty()) {
      System.out.println("Queue Underflow. Cannot remove.");
      System.exit(1);
    }
    front = (front + 1) % MAXQUEUE;
    return items[front];
  }

  public void insert(Object x) {
    rear = (rear + 1) % MAXQUEUE;
    if (rear == front) {
      System.out.println("Queue Underflow");
      System.exit(1);
    }

    items[rear] = x;
  }
}
