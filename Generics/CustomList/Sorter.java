package com.company.Generics.CustomList;

public class Sorter {

    public static<T extends Comparable<T>> void sort(Custom<T> list) {
        for (int i = 0; i < list.size(); i++) {
            T currElement = list.get(i);

            for (int g = i; g < list.size(); g++) {
                if (currElement.compareTo(list.get(g)) > 0) {
                    list.swap(i, g);
                }
            }
        }
    }
}
