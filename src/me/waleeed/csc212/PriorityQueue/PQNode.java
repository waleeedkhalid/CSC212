package me.waleeed.csc212.PriorityQueue;

public class PQNode<T> {
    public T data;
    public int priority; // it can be type of class Priority(you have to create it)
    public PQNode<T> next;

    public PQNode() {
        next = null;
    }

    public PQNode(T val, int p) {
        data = val;
        priority = p;
    }
}
