package me.waleeed.csc212.Queue;

import me.waleeed.csc212.Node;

public class LinkedQueue<T> implements Queue<T> {
    private Node<T> head, tail;
    private int size;

    public LinkedQueue() {
        head = tail = null;
        size = 0;
    }

    @Override
    public T serve() {
        T data = head.data;
        head = head.next;
        size--;
        if(size == 0)
            tail = null;
        return data;
    }

    @Override
    public void enqueue(T e) {
        if(tail == null) {
            head = tail = new Node<>(e);
        } else {
            tail.next = new Node<>(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public boolean full() {
        return false; // LinkedQueue
    }

    // Slide Exercise
    public T enquiry() {
        return head.data;
    }
}
