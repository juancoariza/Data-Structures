package Test1;/* The following class demonstrates the functionality of basic stack in Java
 * It includes the push, peek, and pop functionality
* */

public class JavaStack {
    // this stack is limited to 100 items of type Integer
    private final int STACKSIZE = 100;
    private int top;
    private int[] items;

    public void Stack(){
        items = new int[STACKSIZE];
        top = -1; // indicates the stack is empty
    }// end constructor

    public boolean empty(){
        if(top==-1)
            return true;
        else
            return false;
    }

    public void push(int x){
        if(top==STACKSIZE-1){
            System.out.println("Stack Overflow");
            System.exit(1);
        }
        items[++top] = x;    // can it be top++?
    } //end push

    public int pop(){
        if(empty()){
            System.out.println("Stack underflow");
            System.exit(1);
        }
        return items[top--];
    } // end pop

    public int peek(){
        if(empty()){
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        return items[top];
    }

    /* General Notes
        A stack is limited to one datatype. For storage of multiple data types, use objects or Generics
        If the size of the stack is known from the beginning, it is easier to use an ArrayList
     */

    public static void main(String args[]) {

        JavaStack stack = new JavaStack();  // creates object of Test1.JavaStack class
        stack.Stack();  // creates the stack of 100 integer spaces
        stack.push(21); // first item in is 21
        stack.push(12); // second item is 12
        System.out.println(stack.peek());   // a peek returns the top element, 12
        stack.pop();
        stack.pop();
        //stack.pop(); // returns stack underflow (empty)
        stack.peek();   // cannot peek into empty stack

    }
}
