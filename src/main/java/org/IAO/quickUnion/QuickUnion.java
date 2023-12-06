package org.IAO.quickUnion;

public class QuickUnion {
    private int[] parent;

    // Constructor: Initialize the array to represent disjoint sets
    public QuickUnion(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    // Find the root of the set to which element i belongs
    private int findRoot(int i) {
        while (i != parent[i]) {
            i = parent[i];
        }
        return i;
    }

    // Connect the sets containing elements p and q by setting the root of one as the root of the other
    public void union(int p, int q) {
        int rootP = findRoot(p);
        int rootQ = findRoot(q);
        parent[rootP] = rootQ;
    }

    // Check if elements p and q belong to the same set
    public boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    public static void main(String[] args) {
        // Example usage:
        // Create a QuickUnion instance with 10 elements (0 to 9)
        QuickUnion qu = new QuickUnion(10);

        // Connect elements 1 and 2
        qu.union(1, 2);

        // Check if elements 1 and 2 are connected
        System.out.println(qu.connected(1, 2));  // Output: true

        // Check if elements 1 and 3 are connected
        System.out.println(qu.connected(1, 3));  // Output: false
    }
}
