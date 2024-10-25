package me.waleeed.csc212.List;

public class Node<T> {
    public T data;
    public Node<T> previous;
    public Node<T> next;

    public Node() {
        data = null;
        previous = null;
        next = null;
    }

    public Node(T val) {
        data = val;
        previous = null;
        next = null;
    }
}
