import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;

public class Autocomplete {
    private Term[] term; // array that tracks the terms

    // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {
        if (terms == null)
            throw new IllegalArgumentException("the array cannot be null!");
        term = new Term[terms.length];
        for (int i = 0; i < terms.length; i++) {
            if (terms[i] == null)
                throw new IllegalArgumentException("the term cannot be null");
            term[i] = terms[i];
        }
        Arrays.sort(term);
    }

    // Returns all terms that start with the given prefix,
    // in descending order of weight.
    public Term[] allMatches(String prefix) {
        if (prefix == null) throw new IllegalArgumentException("argument cannot"
                                                                       + " be null");
        Comparator<Term> prefixComparator = Term.byPrefixOrder(prefix.length());
        // now, we will create a dummy term (weight 0) to conduct a binary search with
        Term prefixTerm = new Term(prefix, 0);
        int firstMatch = BinarySearchDeluxe.firstIndexOf(term, prefixTerm,
                                                         prefixComparator);
        int lastMatch = BinarySearchDeluxe.lastIndexOf(term, prefixTerm,
                                                       prefixComparator);
        if (lastMatch == -1) {
            return new Term[0]; // No matches found
        }
        int numMatches = lastMatch - firstMatch + 1;
        Term[] copy = new Term[numMatches];
        for (int i = 0; i < numMatches; i++) {
            copy[i] = term[firstMatch + i];
        }
        Arrays.sort(copy, Term.byReverseWeightOrder());
        return copy;
    }

    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
        if (prefix == null) throw new IllegalArgumentException("argument cannot "
                                                                       + "be null");
        // Again we will create a dummy term (weight 0) to conduct a binary search with
        Term prefixTerm = new Term(prefix, 0);
        Comparator<Term> prefixComparator = Term.byPrefixOrder(prefix.length());
        int firstLocation = BinarySearchDeluxe.firstIndexOf(term, prefixTerm,
                                                            prefixComparator);
        int lastLocation = BinarySearchDeluxe.lastIndexOf(term, prefixTerm,
                                                          prefixComparator);
        if (firstLocation == -1) {
            return (0);
        }
        // calculating the total number of matches
        int numMatches = lastLocation - firstLocation + 1;
        return numMatches;
    }

    // unit testing (required)
    public static void main(String[] args) {

        // read in the terms from a file
        String filename = args[0];
        In in = new In(filename);
        int n = in.readInt();
        Term[] terms = new Term[n];
        for (int i = 0; i < n; i++) {
            long weight = in.readLong();           // read the next weight
            in.readChar();                         // scan past the tab
            String query = in.readLine();          // read the next query
            terms[i] = new Term(query, weight);    // construct the term
        }

        // read in queries from standard input and print the top k matching terms
        int k = Integer.parseInt(args[1]);
        Autocomplete autocomplete = new Autocomplete(terms);
        while (StdIn.hasNextLine()) {
            String prefix = StdIn.readLine();
            Term[] results = autocomplete.allMatches(prefix);
            StdOut.printf("%d matches\n", autocomplete.numberOfMatches(prefix));
            for (int i = 0; i < Math.min(k, results.length); i++)
                StdOut.println(results[i]);
        }
    }

}
