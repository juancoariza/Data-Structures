package Test1;

public class Factorial_recursion {

    static int fact(int n) {

        if (n == 0 || n == 1) {
            return 1;   // 1! and 0! both are equal to 1
        }

        else {
            return n * fact(n - 1);
        }
    }

    public static void main (String args[]) {
      System.out.println(fact(7));
    }

}