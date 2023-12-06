package org.IAO.homework.question1;

import org.IAO.inout.StdOut;

import java.util.Comparator;

public class InsertionSort {

    public static void sort(Comparable[] a){
        int n = a.length;
        for (int i=0;i<n;i++){
            for (int j =i;j>0;j--){
                if(less(a[j],a[j-1])) exch(a,j,j-1);
                else break;

            }
        }
    }

    public static void sort(Object[] a, Comparator comparator){

        int n = a.length;
        for (int i=0;i<n;i++){
            for(int j = i;j>0;j--){
                if (less(a[j],a[j-1],comparator)) exch(a,j,j-1);
                else break;
            }
        }
    }

    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    public static boolean less(Object v, Object w, Comparator comparator){
        return comparator.compare(v,w) < 0;
    }

    public static void exch(Object[] a, int i, int j){
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static boolean isSorted(Comparable[] a){
        int n = a.length;
        for (int i =1;i<n;i++){
            if(less(a[i],a[i-1])) return false;
        }
        return true;
    }


    public static void show(Comparable[] a){
        for (int i=0;i<a.length;i++){
            StdOut.println(" val : "+a[i]);
        }
    }

    public static void show(Object[] a){
        for (Object obj: a ) {
            StdOut.println(obj.toString());
        }
    }

    public static void main(String[] args) {
        Integer[] test = {1,3,5,3,6,2,5,7,14};

        sort(test);
        show(test);

        // Objects

        Person[] people = {
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35)
        };

        sort(people,Comparator.comparing(Person::getAge));
        show(people);
    }
}
