/**
 * DynamicList.java Juan Ariza 2/20/2019 Creates a DynamicList to be used within a custom linked
 * list. Stores Dynamic Nodes and their information Code provided by the instructor, with assigned
 * methods completed
 */


package Test2;

public class DynamicList {

  private DynamicNode head;

  public DynamicList() {
    head = null;
  }

  public DynamicList(DynamicNode head) {
    this.head = head;
  }

  public DynamicNode getList() {
    return head;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public void insertFirst(Object x) {
    DynamicNode q = new DynamicNode(x, null);
    if (!isEmpty()) {
      q.setNext(head);
    }
    head = q;
  }

  public void print() {
    if (head == null) {
      System.out.println("null");
    }
    DynamicNode p = head;
    while (p != null) {
      System.out.print(p.getInfo() + ((p.getNext() != null) ? "->" : ""));
      p = p.getNext();
    }
    System.out.println();

  }

  /**
   * Appends all elements in the parameter list othrList to the end of this list. Returns true if
   * the list was changed, false otherwise. Please note that NO new list is created. Also, it is
   * wrong to (repeatedly) insert new nodes to the list. DO NOT USE insertFirst, insertAfter,
   * deleteFirst, and deleteAfter
   *
   * @param othrList - list to append
   * @return boolean  - appended list if true, exits otherwise
   */
  public boolean appendList(DynamicList othrList) {
    boolean canAppend = true;
    DynamicNode tmp = this.head;
    // for the method, "this" node refers to the list calling the method
    // i.e. if a line reads: list2.appendList(list3), this.head is list2's head node

    if (othrList.isEmpty()) {
      System.out.println("Appended list is empty. Returning original list...");
      print();
      canAppend = false;
    }

    /* The final node of a list is null, so to add onto said node, we can replace the null pointer
     * to the head of another list. In order to find the null pointer of the list, we must traverse
     * it.*/

    while (tmp != null) {
      // gets next node pointer
      tmp = tmp.getNext();

      if (tmp.getNext() == null) {
        // we traversed to the end of the node then appended, it throws a NullPointerException
        tmp.setNext(othrList.head);
        canAppend = true;
        break;
        // BUG: the loop has no natural breaking condition. Without the explicit break,
        // it creates infinite loop
      }
    }

    //returns appended list (this.list + othrList)
    print();
    return canAppend;
  }

  /**
   * Reverses the order of the nodes in a given list, and prints the result. The method does not
   * create a new list. DO NOT USE insertFirst, insertAfter, deleteFirst, and deleteAfter
   */
  public void reverse(DynamicList list) {
    /* how to reverse list: make last "arrow" the head, reverse flow of pointers
     * use tmp node to store pointers, keep track of two nodes at the time
     * special cases: end of list*/
    if (isEmpty()) {
      System.out.println("\nError: empty list. Cannot reverse.\n");
      System.exit(1);
    } else {

      System.out.println("\nReversing list...");
      System.out.println("Previous list: ");
      list.print();

      DynamicNode previous = null;  // keeps node previous to tmp.
      DynamicNode next;   // stores the nodes of the reversed list
      DynamicNode current = list.head; // head node of the incoming list. Stored to move node pointers

      while (current != null) {
        next = current.getNext(); // moves the head node to next element
        current.setNext(previous); // sets the current back to a previous position
        previous = current;   // resets previous to accept new node
        current = next;   // reversed node pointer moved to the front of the list (near the head)

        /* Illustrated this would look like:
         * intial list 6->7->8->9
         * previous = null, next = empty, current = head (6)
         * in the loop
         *  next = node(7)
         *  current = null
         *  previous = null
         *  then current = node(7)
         *
         *  next run:
         *  previous = null, next = node(7), current = node(7)
         *    next = node(8)
         *    current = null
         *    previous = null
         *    then current = node(8)
         *
         *    By temporarily "cutting out" the previous node's pointer and moving the next node
         *    closer to the head, we are essentially cycling though the loop until the null pointers
         *    are resolved
         */

      }
      list.head = previous;
      System.out.println("New list: ");
      list.print();
    }

  }

  /**
   * Deletes the middle node in the list IF it exists. If the list has an EVEN number of nodes,
   * there is NO middle node. Constraint: you cannot use a counter or a boolean. Given a list
   * a→b→c→d→e, c is deleted Given a list a→b→c→d, nothing is deleted.
   *
   * Returns: info in the middle node if it exists; null otherwise DO NOT USE insertFirst,
   * insertAfter, deleteFirst, and deleteAfter DO NOT USE additional datatype variables or loops.
   * One loop only.
   */
  public Object deleteMid() {

    /* If no additional loops can be used within the method, increase the node
     * variables that are updated in one loop.
     * One node travels each element directly, and the other node skips over nodes
     * Like in the appendList() method, "this" refers to the DynamicList calling said method
     */
    DynamicNode first = this.head;
    DynamicNode second = this.head;
    DynamicNode tmp = null;

    if (isEmpty()) {
      System.out.println("\nEmpty list. Cannot perform operation.");
      return 1;
    } else {
      /* Neither of the node loop values can pass null, so we must check if their next value could be null to find the end of the list.
       * Going past null returns a NullPointerException*/
      while (first.getNext() != null && first.getNext().getNext() != null) {
        first = first.getNext()
            .getNext();  // the first node traverses list two nodes at the time. This way it finds the end of loop faster
        tmp = second;            // used to save pointer of normal-speed loop traversal
        second = second.getNext();      // loops through list nodes

      }

      // links the pointer of node prior to middle, to that after middle. Similar in nature to a delete function, it does not
      // delete the nodes, but removes a node's link to the list.
      tmp.setNext(second.getNext());

      if (first.getNext() != null) {
        System.out.println("Even. Cannot produce result ");
        print();
      } else {
        System.out.println("The list after deleted middle is: ");
        print();
      }


    }

    // move two pointers at different speeds throughout the list, and check if
    // the next nodes are null (end of list).
    return this.head;
  }

  /*--------------------------------------------------------------*/

  public void insertAfter(DynamicNode p, Object x) {
    if (p == null) {
      System.out.println("void insertion");
      System.exit(1);
    }
    DynamicNode q = new DynamicNode(x, p.getNext());
    p.setNext(q);
  }

  public Object deleteFirst() {
    if (isEmpty()) {
      System.out.println("void deletion");
      System.exit(1);
    }
    Object temp = head.getInfo();
    if (head.getNext() == null) {
      head = null;
    } else {
      head = head.getNext();
    }
    return temp;
  }

  public Object deleteAfter(DynamicNode p) {
    if (p == null || p.getNext() == null) {
      System.out.println("void deletion");
      System.exit(1);
    }
    DynamicNode q = p.getNext();
    Object temp = q.getInfo();
    p.setNext(q.getNext());
    return temp;
  }


  public DynamicNode searchInsert(Object x) {

    if (this.isEmpty()) {
      System.out.println("empty list insert " + x);
      DynamicNode head = new DynamicNode(x, null);
      return head;
    }

    //matches first node
    if (head.getInfo().equals(x)) {
      System.out.println("found " + x);
      return head;
    }

    //look in the nodes following head
    //you do not want to pass the end of the list
    DynamicNode nd = head;
    while (nd.getNext() != null) {
      if (nd.getNext().getInfo().equals(x)) {
        System.out.println("found " + x);
        return nd;
      }
      nd = nd.getNext();
    }

    //not found – insert after nd (last node on the list)
    nd.setNext(new DynamicNode(x, null));
    nd = nd.getNext();
    System.out.println("insert " + x);
    return nd;
  }

  public void displayNth(int index) {
    DynamicNode current = head;
    int counter = 0;

    while (counter != index) {

      current = current.getNext();
      counter++;

    }

    System.out.println(current.getInfo());

  }

  public void swap(int m, int n) {
    int counterM = 0, counterN = 0; // used to traverse the list to find the indices
    DynamicNode P = head, Q = head, beforeP = null, beforeQ = null, tmp = null;
    // used to store node pointers for swapped elements

    while (counterM != m) {

      if (m - counterM == 1) {
        beforeP = P;
      }

      P = P.getNext();
      counterM++;

    }

    while (counterN != n) {

      if (n - counterN == 1) {
        beforeQ = Q;
      }
      Q = Q.getNext();
      counterN++;

    }

    /* the two elements to swap have a pointer reference from previous to self
     * and from self to next for a total of 4 pointers. */

    // stores Q's next pointer before the swap, to continue the connection to List
    tmp = Q.getNext();

    // swap operation
    beforeP.setNext(Q);
    Q.setNext(beforeQ);
    beforeQ.setNext(P);
    P.setNext(tmp);

    print();

  }


}



