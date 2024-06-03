import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Comparator;

public class Term implements Comparable<Term> {
    private String query; // query
    private long weight; // weight

    // Initializes a term with the given query string and weight.
    public Term(String query, long weight) {
        if (query == null || weight < 0)
            throw new IllegalArgumentException(
                    "query cannot be null and weight cannot tbe less than 0");
        this.query = query;
        this.weight = weight;

    }

    // Compares the two terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder() {
        return new ReverseWeightOrder();
    }

    // Private static nested class to compare terms by reverse weight order
    private static class ReverseWeightOrder implements Comparator<Term> {
        public int compare(Term v, Term w) {
            // do not need to use a comparator
            // return w.weight.compareTo(v.weight);
            return Long.compare(w.weight, v.weight);
        }
    }


    // Compares the two terms in lexicographic order,
    // but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r) {
        if (r < 0) throw new IllegalArgumentException("r cannot be negative");
        return new PrefixOrder(r);
    }

    // Private static nested class to compare terms by reverse prefix order
    private static class PrefixOrder implements Comparator<Term> {
        private final int r; // number of character

        // Takes r as an argument and saves it in an instance variable.
        PrefixOrder(int r) {
            this.r = r;
        }

        public int compare(Term v, Term w) {
            int min = Math.min(r, Math.min(w.query.length(), v.query.length()));
            for (int i = 0; i < min; i++) {
                if (v.query.charAt(i) != w.query.charAt(i)) {
                    if (v.query.charAt(i) < w.query.charAt(i)) return -1;
                    else
                        return 1;
                }
            }
            /*
            // creates substring based on the first r characters
            String a = v.query.substring(0, Math.min(r, v.query.length()));
            String b = w.query.substring(0, Math.min(r, w.query.length()));
            return a.compareTo(b);
             */
            if (v.query.length() < w.query.length() && r != min) return -1;
            if (w.query.length() < v.query.length() && r != min) return 1;
            return 0;
        }
    }

    // Compares the two terms in lexicographic order by query.
    public int compareTo(Term that) {
        return this.query.compareTo(that.query);
    }

    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString() {
        return (weight + "\t" + query);
    }

    // unit testing (required)
    public static void main(String[] args) {
        // Create an array of Terms
        Term[] terms = {
                new Term("shirt", 100),
                new Term("shoes", 200),
                new Term("pants", 50),
                new Term("socks", 150),
                new Term("hat", 125),
                new Term("sweater", 80),
                new Term("sweeter", 80) // term that tests first three character orderÁ
        };
        StdOut.println("Naturally sort the array with weight");
        Arrays.sort(terms);
        for (Term term : terms)
            StdOut.println(term);
        StdOut.println("\nSort the array by Reverse weight");
        StdRandom.shuffle(terms); // shuffle array
        Arrays.sort(terms, Term.byReverseWeightOrder());
        for (Term term : terms)
            StdOut.println(term);
        StdOut.println("\nSort using prefix order of 2 characters");
        StdRandom.shuffle(terms); // shuffle array
        Arrays.sort(terms, Term.byPrefixOrder(2));
        for (Term term : terms)
            StdOut.println(term);

    }
}
