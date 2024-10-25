package me.waleeed.csc212.PriorityQueue;

public class PQElement<T> {
    public T data;
    public int priority;


    public PQElement(T e, int p) {
        data = e;
        priority = p;
    }
}
