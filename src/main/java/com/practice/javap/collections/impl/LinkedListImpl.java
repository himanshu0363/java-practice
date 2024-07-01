package com.practice.javap.collections.impl;

import java.util.Collection;

public class LinkedListImpl<E> {
    private Node<E> head;
    private int size;
    public LinkedListImpl() {
        this.head = null;
        this.size = 0;
    }

//    public LinkedListImpl(Collection<E> c) {
//        this.size = size;
//    }

    public void add(E e) {
        Node<E> newNode = new Node<>(e);
        if (head == null) {
            head = newNode;
            size++;
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            size++;
        }
    }

    public E remove(int index) {
        E removed;
        if (index == 0) {
            removed = head.element;
            head = head.next;
            size--;
        } else {
            Node<E> current = head;
            for (int i = 0; i < index-1; i++) {
                current = current.next;
            }
            removed = current.next.element;
            current.next = current.next.next;
            size--;
        }
        return removed;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            stringBuilder.append(current.element);
            current = current.next;
            if (i != (size - 1)) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }



    public static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
            this.next = null;
        }
    }

}
