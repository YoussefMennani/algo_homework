package org.IAO.quickFind;

public class QuickFindUF {
    private int[] id;    // id[i] = component identifier of i
    private int count;    // attribute that counts the number of components

    /**
     * Initializes an empty union-find data structure with
     * n elements, 0 through n-1.
     * Initially, each element is in its own set.
     *
     * @param n the number of elements
     */
    public QuickFindUF(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;
    }

    /**
     * Returns the number of sets.
     *
     * @return the number of sets (it is between 1 and n)
     */
    public int count() {
        return count;
    }

    /**
     * Returns the canonical element of the set containing element p.
     *
     * @param p an element
     * @return the canonical element of the set containing p
     * checks if p is valid
     */
    public int find(int p) {
        validate(p);
        return id[p];
    }

    // validates that p is a valid index
    private void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("Index " + p + " is not between 0 and " + (n-1));
        }
    }

    /**
     * Returns true if the two elements are in the same set.
     *
     * @param p one element
     * @param q the other element
     * @return true if p and q are in the same set; false otherwise
     * checks for the validity of arguments
     */
    public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return id[p] == id[q];
    }

    /**
     * Merges the set containing element p with the set
     * containing element q.
     *
     * @param p one element
     * @param q the other element
     * checks for the validity of arguments
     */
    public void union(int p, int q) {

        try{
            validate(p);
            validate(q);

            int pID = id[p];
            int qID = id[q];

            // If p and q are already in the same component, do nothing
            if (connected(pID,qID)) {
                return;
            }

            for (int i = 0; i < id.length; i++) {
                if (id[i] == pID) {
                    id[i] = qID;
                }
            }

            // Update the number of components
            count--;
        }catch (IllegalArgumentException e){
            System.err.println("Exception: " + e.getMessage());

        }

    }

    /**
     * Reads an integer n and a sequence of pairs of integers
     * between 0 and n-1 from standard input, where each integer
     * in the pair represents some element;
     * if the elements are in different sets, merge the two sets
     * and print the pair to standard output.
     */
    public static void main(String[] args) {
        int n = 10; // Example: Set the number of elements

        QuickFindUF uf = new QuickFindUF(n);

        // Example usage: Merge sets and print the pairs
        uf.union(100, 1);
        uf.union(2, 3);
        uf.union(4, 5);
        uf.union(6, 7);

        System.out.println("Number of sets: " + uf.count());

        // Check if elements are in the same set
        System.out.println("Are 0 and 1 connected? " + uf.connected(0, 1));
        System.out.println("Are 1 and 2 connected? " + uf.connected(1, 2));

        // Merge two sets
        uf.union(1, 2);
        System.out.println("Number of sets after merging: " + uf.count());
    }
}
