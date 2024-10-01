package me.waleeed.csc212.Stack;

public class ArrayStack<T> implements Stack<T> {
    private int top;
    private int maxSize;
    private T[] nodes;

    public ArrayStack(int size) {
        top = -1;
        maxSize = size;
        nodes = (T[]) new Object[size]; // we can''t initialize a generic array so we create it with big object in java and the casting.
    }

    @Override
    public T pop() {
        return nodes[top--]; // after because decrement after remove.
    }

    @Override
    public void push(T e) {
        nodes[++top] = e; // before because add after the top
    }

    @Override
    public boolean empty() {
        return top == -1;
    }

    @Override
    public boolean full() {
        return top == maxSize - 1;
    }
}
