import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

public class BinarySearchDeluxe {

    // Returns the index of the first key in the sorted array a[]
    // that is equal to the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(
            Key[] a, Key key, Comparator<Key> comparator) {
        if (a == null || key == null || comparator == null)
            throw new IllegalArgumentException("null element detected");
        int lo = 0;
        int hi = a.length - 1;
        int pointer = -1; // initializes and tracks our first index
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            int compare = comparator.compare(a[mid], key);
            if (compare > 0)
                hi = mid - 1;
            else if (compare < 0)
                lo = mid + 1;

            else {
                pointer = mid;
                hi = mid - 1; // Move left to find the first index
            }


        }
        return pointer;
    }

    // Returns the index of the last key in the sorted array a[]
    // that is equal to the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        if (a == null || key == null || comparator == null)
            throw new IllegalArgumentException("null element detected");
        int lo = 0;
        int hi = a.length - 1;
        int pointer = -1; // initializes and tracks our first index,
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            int compare = comparator.compare(a[mid], key);
            if (compare < 0)
                lo = mid + 1;
            else if (compare > 0)
                hi = mid - 1;

            else {
                pointer = mid;
                lo = mid + 1; // move to the right to find the last index
            }
        }
        return pointer;
    }


    // unit testing (required)
    public static void main(String[] args) {
        // BinarySearchDeluxe BSD = new BinarySearchDeluxe();
        Term a = new Term("a", 1);
        Term b = new Term("b", 1);
        Term c = new Term("c", 1);
        Term d = new Term("c", 1);
        Term e = new Term("d", 1);
        Term f = new Term("e", 1);
        Term g = new Term("f", 1);
        Term h = new Term("g", 1);
        Term i = new Term("g", 1);
        Term j = new Term("g", 1);

        Term[] key = new Term[10];
        key[0] = a;
        key[1] = b;
        key[2] = c;
        key[3] = d;
        key[4] = e;
        key[5] = f;
        key[6] = g;
        key[7] = h;
        key[8] = i;
        key[9] = j;


        Term pointD = new Term("d", 1);
        Term pointG = new Term("g", 1);
        Term pointZ = new Term("z", 1);
        String print1 = "Print the index of the first key that matches input ";
        String print2 = "Print the index of the last key that matches input ";

        Comparator<Term> comparator = Term.byReverseWeightOrder();
        BinarySearchDeluxe.firstIndexOf(
                key, pointD, comparator);
        StdOut.println(print1 + "(expect 4) :" + "\n" +
                               BinarySearchDeluxe.firstIndexOf(
                                       key, pointD, comparator));
        StdOut.println(print1 + "(expect 7) :" + "\n" +
                               BinarySearchDeluxe.firstIndexOf(
                                       key, pointG, comparator));
        StdOut.println(print2 + "(expect 9) :" + "\n" +
                               BinarySearchDeluxe.lastIndexOf(
                                       key, pointG, comparator));
        StdOut.println(print1 + "(expect -1) :" + "\n" +
                               BinarySearchDeluxe.firstIndexOf(
                                       key, pointZ, comparator));
        StdOut.println(print2 + "(expect -1) :" + "\n" +
                               BinarySearchDeluxe.lastIndexOf(
                                       key, pointZ, comparator));

    }
}
