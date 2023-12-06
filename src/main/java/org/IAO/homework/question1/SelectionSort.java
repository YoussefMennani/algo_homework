package org.IAO.homework.question1;

import org.IAO.Sort.Selection;
import org.IAO.inout.StdIn;
import org.IAO.inout.StdOut;

import java.util.Comparator;

public class SelectionSort {

    public static void sort(Comparable[] a){
        int n = a.length;

        for (int i = 0;i<n;i++){
            int min = i;
            for(int j=i+1;j<n;j++){
                if(less(a[j],a[min]) ) min = j;
            }
            exch(a,i,min);

        }
        assert isSorted(a);
    }

    public static void sort(Object[] a,Comparator comparator){
        int n = a.length;
        for (int i =0;i<n;i++){
            int min = i;
            for(int j=i+1;j<n;j++){
                if(less(comparator,a[j],a[min])) min = j;
            }
            exch(a,i,min);
        }
        assert isSorted(comparator,a);
    }

    public static boolean less(Comparable a ,Comparable b){
        return a.compareTo(b) < 0;
    }

    public static boolean less(Comparator comparator,Object a, Object b){
        return comparator.compare(a,b) < 0;
    }


    public static void exch(Object[] a, int i,int j){
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static boolean isSorted(Comparable[] a){
        for(int i=1;i<a.length;i++)
            if (less(a[i],a[i-1])) return false;

        return true;
    }

    public static boolean isSorted(Comparator comparator,Object[] a){
        for (int i =1;i<a.length;i++)
            if(less(comparator,a[i],a[i-1])) return false;

        return true;
    }

    public static void show(Comparable[] a){
        for (int i =0; i<a.length;i++){
            StdOut.println(a[i]);
        }
    }

    public static void show(Object[] a){
        for (int i =0; i<a.length;i++){
            StdOut.println(a[i].toString());
        }
    }


    public static void main(String[] args) {
        String[] a = {"a","b","w","x","j","f","c"};
        SelectionSort.sort(a);
        show(a);

        Person[] people = {
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35)
        };

        sort(people,Comparator.comparing(Person::getAge));
        show(people);


    }


}
