package org.IAO.test;

import java.util.Arrays;

public class ShellSort{

    public static void sort(Comparable[] a){
        int h=1;
        int n = a.length;
        while (h<n/3) h=3*h+1;

        while (h>=1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    public static void exch(Comparable[] a,int i,int j){
        Comparable e = a[i];
        a[i] = a[j];
        a[j] = e;
    }

    public static void main(String[] args){
        Integer[] a = {5,1,2,2,6,2,7,22,12,56};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
