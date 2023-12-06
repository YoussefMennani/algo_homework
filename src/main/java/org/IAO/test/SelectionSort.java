package org.IAO.test;

import java.util.Arrays;

public class SelectionSort {

    public static void sort(Comparable[] a){

        for (int i=0;i<a.length;i++){
            int min = i;

            for(int j = i+1;j<a.length;j++){
                if(less(a[j],a[min])) min = j;
            }
            exch(a,i,min);

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
        Integer[] a = {1,4,6,2,6,2,7,22,12,56};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
