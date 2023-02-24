package com.company.Generics.GenericCountMethod;

public class Box<E extends Comparable<E>> implements Comparable<Box<E>> {

    private E data;

    Box(E data) {
        this.data = data;
    }

    public E getBoxes() {
        return this.data;
    }

    @Override
    public int compareTo(Box<E> o) {
        return this.data.compareTo(o.data);
    }
}
