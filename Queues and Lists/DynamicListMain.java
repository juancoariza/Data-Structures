/**
 * DynamicListMain.java Juan Ariza 2/20/2019 Main class and tester for DynamicList and DynamicNode
 * classes
 */


package Test2;

public class DynamicListMain {

  public static void main(String args[]) {
    DynamicList newList1 = new DynamicList();
    newList1.insertFirst(7);
    newList1.insertFirst(2);
    newList1.insertFirst(1);
    System.out.println("List 1:");
    newList1.print();

    DynamicList newList2 = new DynamicList();
    newList2.insertFirst(5);
    newList2.insertFirst(4);
    System.out.println("List 2:");
    newList2.print();

    DynamicList newList3 = new DynamicList();
    newList3.insertFirst('f');
    newList3.insertFirst('d');
    newList3.insertFirst('s');
    newList3.insertFirst('a');
    newList3.insertFirst('q');

    // KNOWN BUG: appended lists do not parse correctly through the deleteMind() method
    System.out.println("Appending List 2 to List 1...");
    newList1.appendList(newList2);

    newList2.reverse(newList2);

    System.out.println("Deleting mid of list 1...");
    newList1.deleteMid();

    newList3.print();
    newList3.swap(1, 3);

    /*
    System.out.println("Deleting mid of list 3...");
    newList3.deleteMid();
    */

    // empty list demonstration
    DynamicList emptyList = new DynamicList();
    System.out.println("Empty list:");
    emptyList.print();

    System.out.println("Displaying 3rd element...");
    newList3.displayNth(3);

    System.out.println("Reversing empty list...");
    emptyList.reverse(emptyList);


  }

}
