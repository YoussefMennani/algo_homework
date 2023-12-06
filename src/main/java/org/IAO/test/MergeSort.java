package org.IAO.test;

import java.util.Arrays;

public class MergeSort {

    public static void merge(Comparable[] a,Comparable[] aux,int lo,int mid, int hi){
        for (int k =lo;k<=hi;k++)
            aux[k] = a[k];

        int i = lo,j = mid+1;
        for (int k=lo;k<=hi;k++){
            if(i>mid) a[k] = aux[j++];
            else if(j>hi) a[k] = aux[i++];
            else if(less(a[i],a[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }

    public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        if(hi<=lo) return;
        int mid = lo + (hi-lo)/2;
        sort(a,aux,lo,mid);
        sort(a,aux,mid+1,hi);
        merge(a,aux,lo,mid,hi);
    }
    public static void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(a,aux,0,a.length - 1);
    }

    public static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }



    public static void main(String[] args) {
        Integer[] arrayToSort = {4, 2, 7, 1, 9, 5,2,5,2,8,1,10,3};

        sort(arrayToSort);
        System.out.println(Arrays.toString(arrayToSort));
    }
}
