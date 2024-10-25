package me.waleeed.csc212.Queue;

import me.waleeed.csc212.Node;

public class ArrayQueue<T> implements Queue<T> {

    private int maxsize;
    private int size;
    private int head, tail;
    private T[] nodes;

    public ArrayQueue(int n) {
        maxsize = n;
        size = 0;
        head = tail = 0;
        nodes = (T[]) new Object[n];
    }

    @Override
    public T serve() {
        T data = nodes[head];
        head = (head + 1) % maxsize;
        size--;
        return data;
    }

    @Override
    public void enqueue(T e) {
        nodes[tail] = e;
        tail = (tail + 1) % maxsize;
        size++;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public boolean full() {
        return size == maxsize;
    }

    // Slide Exercise
    public T enquiry() {
        return nodes[head];
    }

    // Homework 2 Question
    public void print() {
        int tmp = head;
        for(int i = 0; i < size; i++) {
            System.out.println(nodes[tmp]);
            tmp = (tmp+1)%maxsize;
        }
    }
}
