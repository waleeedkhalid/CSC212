package me.waleeed.csc212.PriorityQueue;

public interface PriorityQueue<T> {
    public PQElement<T> serve();
    public void enqueue(T e, int pty);
    public int length();
    public boolean full();
}
