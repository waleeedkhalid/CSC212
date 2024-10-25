package me.waleeed.csc212.List;

public class ArrayList<T> implements List<T> {

    private int maxsize;
    private int size;
    private int current;
    private T[] nodes;

    public ArrayList(int n) {
        maxsize = n;
        size = 0; // there is no element in the list.
        current = -1; // there is no current.
        nodes = (T[]) new Object[n];
    }


    @Override
    public void findFirst() {
        current = 0;
    }

    @Override
    public void findNext() {
        current++;
    }

    @Override
    public T retrieve() {
        return nodes[current];
    }

    @Override
    public void update(T e) {
        nodes[current] = e;
    }

    @Override
    public void insert(T e) {
        for(int i = size-1; i > current; i--) {
            nodes[i+1] = nodes[i];
        }
        current++;
        nodes[current] = e;
        size++;
    }

    @Override
    public void remove() {
        for(int i = current + 1; i < size; i++) {
            nodes[i-1] = nodes[i];
        }
        size--;
        if(size == 0)
            current = -1;
        else if(current == size)
            current = 0;
    }

    @Override
    public boolean full() {
        return size == maxsize;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public boolean last() {
        return current == (size-1);
    }
}
