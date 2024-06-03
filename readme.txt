Programming Assignment 3: Autocomplete


/* *****************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that is equal to the search key.
 **************************************************************************** */
 This method finds the index of the key that is equal to the search key by utalizing
 Binary Search. We set pointers and pointer to -1 which is returned if no index is
 found, and then mid is found and comparison is carried outto the middle index,
 if the value is less then the pointer is set to mid - 1 to shift to a new subarray.
 In the other case if the key is greater than the middle value mid then we set the
 lo pointer to mid + 1 to and shift to a new sub array to search, if it is equal then
 set the pointer to the middle term and return.



/* *****************************************************************************
 *  Identify which sorting algorithm (if any) that your program uses in the
 *  Autocomplete constructor and instance methods. Choose from the following
 *  options:
 *
 *    none, selection sort, insertion sort, mergesort, quicksort, heapsort
 *
 *  If you are using an optimized implementation, such as Arrays.sort(),
 *  select the principal algorithm.
 **************************************************************************** */

Autocomplete() : Mergesort using Arrays.sort()

allMatches() : none / binary search

numberOfMatches() : none / binary search

/* *****************************************************************************
 *  How many compares (in the worst case) does each of the operations in the
 *  Autocomplete data type make, as a function of both the number of terms n
 *  and the number of matching terms m? Use Big Theta notation to simplify
 *  your answers.
 *
 *  Recall that with Big Theta notation, you should discard both the
 *  leading coefficients and lower-order terms, e.g., Theta(m^2 + m log n).
 **************************************************************************** */

Autocomplete():     Theta(nlog[n])

allMatches():       Theta(m^2 + mlog[n])

numberOfMatches():  Theta(log[n])




/* *****************************************************************************
 *  Known bugs / limitations.
 **************************************************************************** */
Handling duplicate terms and also dealing with large data sets may cause perforance
degredation due to limited comparator logic used in my searching

/* *****************************************************************************
 *  Describe any serious problems you encountered.
 **************************************************************************** */
Huge problems when trying to impliment the BinarySearchDeluxe client as the
lo and high pointers were overlapping and throwing -1 for most of the tests
We also did not create an immutable copy in Autocomplete in the begining so that
took us a while debugging only to realisze that that was the only issue



/* *****************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 **************************************************************************** */
none
