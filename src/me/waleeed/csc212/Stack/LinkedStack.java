package me.waleeed.csc212.Stack;

import me.waleeed.csc212.Node;

public class LinkedStack<T> implements Stack<T> {
    private Node<T> top;

    public LinkedStack() {
        top = null;
    }

    @Override
    public T pop() {
        T e = top.data;
        top = top.next;
        return e;
    }

    @Override
    public void push(T e) {
        Node<T> temp = new Node<T>(e);
        temp.next = top;
        top = temp;
    }

    @Override
    public boolean empty() {
        return top == null;
    }

    @Override
    public boolean full() {
        return false; // LinkedList
    }
}
