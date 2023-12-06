package org.IAO.homework.question1;

import java.util.Arrays;
import java.util.Comparator;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }



    public static void sort(Object[] a, Comparator comparator) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(comparator, a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }




    private static boolean less(Comparator comparator, Object v, Object w) {
        return comparator.compare(v, w) < 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private static void exch(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        // Create an array of Person objects
        Person[] people = {
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35)
        };

        // Sort the array of Person objects by age using a custom Comparator
        //sort(people, (person1, person2) -> Integer.compare(person1.getAge(), person2.getAge()));
        sort(people, Comparator.comparingInt(Person::getAge));

        // Print the sorted array
        for (Person person : people) {
            System.out.println(person.getName() + " - " + person.getAge() + " years old");
        }
    }

}
