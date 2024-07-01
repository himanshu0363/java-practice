package com.practice.javap.collections.impl;

import java.util.Arrays;

public class ArrayListImpl<E> {
    private final static int initialCapacity = 10;
    private Object[] actualArray;
    private int size;

    public ArrayListImpl() {
        this.actualArray = new Object[initialCapacity];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public ArrayListImpl(int size) {
        this.actualArray = new Object[size];
        this.size = 0;
    }

    public void add(E e) {
        if (actualArray.length == size) {
            actualArray = Arrays.copyOf(actualArray, this.size * 2);

        }
        actualArray[size++] = e;
    }

    public void remove() {
        actualArray[--size] = null;
    }

    public E get(int index) {
        E element;


        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        element = (E) actualArray[index];


        return element;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(actualArray[i]);
            if (i != (size - 1)) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
