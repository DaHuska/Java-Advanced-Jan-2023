package com.company.Generics.GenericBox;

public class Box<T> {
    private T data;

    Box(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.data.getClass().getName(), String.valueOf(this.data));
    }
}
