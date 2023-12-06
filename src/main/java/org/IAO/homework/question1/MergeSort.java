package org.IAO.homework.question1;

public class MergeSort {

    public static void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(a,aux,0,a.length - 1);
    }

    public static void sort(Comparable[] a, Comparable[] aux,int lo,int hi){
        if (hi<=lo) return;
        int mid = lo+(hi-lo)/2;
        sort(a,aux,lo,mid);
        sort(a,aux,mid+1,hi);
        merge(a,aux,lo,mid,hi);
    }

    public static void merge(Comparable[] a, Comparable[] aux, int lo,int mid,int hi){

        for (int k =lo;k<=hi;k++){
            aux[k] = a[k];
        }

        int i = lo;
        int j = mid+1;

        for (int k =lo;k<=hi;k++){
            if(i>mid) a[k]=aux[j++];
            else if(j>hi) a[k]=aux[i++];
            else if(less(a[i],a[j])) a[k] = aux[i++];
            else a[k] = a[j++];
        }

    }

    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) <0;
    }

    public static void show(Object[] tab){
        for (Object val: tab) {
            System.out.println(val);
        }
    }

    public static void main(String[] args) {
        Integer[] test = {1,3,5,3,6,2,5,7,14};

        sort(test);
        show(test);
    }
}
