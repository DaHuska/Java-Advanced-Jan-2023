package com.company.Generics.CustomList;

import java.util.ArrayList;
import java.util.List;

public class Custom<E extends Comparable<E>> implements Comparable<E>{
    private List<E> list;
    private int elementIndex;

    Custom() {
        list = new ArrayList<>();
        elementIndex = 0;
    }

    public void add(E text) {
        this.list.add(text);
    }

    public void swap(int firstIndex, int secondIndex) {
        E firstElement = this.list.get(firstIndex);
        E secondElement = this.list.get(secondIndex);

        this.list.set(firstIndex, secondElement);
        this.list.set(secondIndex, firstElement);
    }

    public E getMax() {
        // default value for the biggest element
        E biggestElement = list.get(0);

        for (E element : this.list) {
            if (element.compareTo(biggestElement) > 0) {
                biggestElement = element;
            }
        }

        return biggestElement;
    }

    public E getMin() {
        // default value for smallest element
        E smallestElement = list.get(0);

        for (E element : this.list) {
            if (element.compareTo(smallestElement) < 0) {
                smallestElement = element;
            }
        }

        return smallestElement;
    }

    @Override
    public int compareTo(E object) {
        return this.list.get(this.elementIndex).compareTo(object);
    }

    public List<E> getList() {
        return this.list;
    }

    public void setElementIndex(int index) {
        this.elementIndex = index;
    }

    public boolean contains(E element) {
        return this.list.contains(element);
    }

    public void remove(int index) {
        E element = getElement(index);

        this.list.remove(element);
    }

    private E getElement(int index) {
        return this.list.get(index);
    }

    public void printList() {
        for (E element : this.list) {
            System.out.println(element);
        }
    }
}
