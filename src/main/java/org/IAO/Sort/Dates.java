package org.IAO.Sort;

import java.util.Date;

public class Dates implements Comparable<Dates>{

    private final int month,day,year;

    public Dates(int m, int d, int y) {
        this.month = m;
        this.day = d;
        this.year = y;
    }

    @Override
    public int compareTo(Dates that) {

        if (this.year < that.year) return -1;
        if (this.year > that.year) return 1;
        if (this.month < that.month) return -1;
        if (this.month > that.month) return 1;
        if (this.day < that.day) return -1;
        if (this.day > that.day) return 1;
        return 0;
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean isSorted(Comparable[] a){
        for (int i = 0;i < a.length;i++){
            if(less(a[i],a[i-1])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Dates d1 = new Dates(1,2,2023);

        Dates d2 = new Dates(2,2,2023);

        System.out.println(less(d1,d2));
    }
}
