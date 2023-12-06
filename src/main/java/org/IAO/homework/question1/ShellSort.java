package org.IAO.homework.question1;

import org.IAO.inout.StdOut;

public class ShellSort {

    public static void sort(Comparable[] a){

        int h =1;
        int N = a.length;
        while (h<N/3) h= 3*h + 1;

        while (h>=1){

            for (int i =h;i<N;i++){
                for(int j =i;j>=h && less(a[j],a[j-h]);j-=h){
                    exch(a,j,j-h);
                }
            }
            h=h/3;
        }


    }
    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) <0;
    }

    public  static void exch(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void show(Comparable[] a){
        for (int i=0;i<a.length;i++){
            StdOut.println(" val : "+a[i]);
        }
    }

    public static void main(String[] args) {
        Integer[] test = {1,3,5,3,6,2,5,7,14};

        sort(test);
        show(test);
    }
}
