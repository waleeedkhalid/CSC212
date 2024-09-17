package me.waleeed.csc212.Week5;

// 17 Sep, 9:10 AM

// Last-in-first-out (LIFO)
// Used in Operating system

// ############################################
// ADT Stack: Specification
// Elements:

// Operations:
// - push(Type element)
// requires: Stack is not full.
// - pop(Type element)
// requires: Stack is not empty.
// - empty
// output: boolean flag.
// - full
// output: boolean flag.

// ############################################

// I[Stack] -> LinkedStack
// I[Stack] -> ArrayStack

public interface Stack<T> {
    public T pop();
    public void push(T e);
    public boolean empty();
    public boolean full();
}
