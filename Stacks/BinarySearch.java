package Test1;

// binarySeach: non-recursive
public class BinarySearch {

        public int binarySearch(int[] a, int x) {
            int low = 0;
            int high = a.length - 1;

            while (low <= high) {
                int mid = (low + high) / 2;

                if (a[mid] == x) {
                    return mid; //found
                } else if (a[mid] < x) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

                return -1; //not found
            }
            return low;
            // http://www.cs.utsa.edu/~wagner/CS3343/recursion/binsearch.html
        }
}