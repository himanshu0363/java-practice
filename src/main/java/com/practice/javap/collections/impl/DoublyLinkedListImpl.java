package com.practice.javap.collections.impl;

public class DoublyLinkedListImpl<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;

    public DoublyLinkedListImpl() {
        size = 0;
        first = null;
        last = null;
    }

    public void add(E e) {
        Node<E> newNode = new Node<>(e);
        if (last == null) {
            first = newNode;
            last = first;
        } else {
            newNode.prev = last;
            newNode.next = last.next;
            last.next = newNode;
            last=newNode;
        }
        size++;
    }

    public E remove(int index) {
        E removed;
        if (index == 0) {
            removed = first.data;
        } else if (index == size - 1) {
            removed = last.data;
        } else {
            int choice = (size - 1) / index;
            if (choice >= 2) {
                Node<E> current = first;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                }
                removed = current.next.data;
                current.next.next.prev = current;
                current.next = current.next.next;
            } else {
                Node<E> current = last;
                for (int i = size-1; i > index + 1; i--) {
                    current = current.prev;
                }
                removed = current.prev.data;
                current.prev.prev.next = current;
                current.prev = current.prev.prev;
            }
        }
        size--;
        return removed;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        DoublyLinkedListImpl.Node<E> current = first;
        for (int i = 0; i < size; i++) {
            stringBuilder.append(current.data);
            current = current.next;
            if (i != (size - 1)) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static class Node<E> {
        public E data;
        Node<E> prev;
        Node<E> next;

        public Node(E data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
}

