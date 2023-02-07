package com.company.Generics.GenericSwapMethod;

import java.util.List;

public class Box<E> {
    private List<E> boxes;

    Box(List<E> boxes) {
        this.boxes = boxes;
    }

    public List<E> getBoxes() {
        return this.boxes;
    }
}
