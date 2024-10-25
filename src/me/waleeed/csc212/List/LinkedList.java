package me.waleeed.csc212.List;

import me.waleeed.csc212.Node;

public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> current;

    public LinkedList() {
        head = current = null;
    }

    public LinkedList(T val) {
        head = new Node<T>(val);
        current = head;
    }

    @Override
    public void findFirst() {
        current = head;
    }

    @Override
    public void findNext() {
        current = current.next;
    }

    @Override
    public T retrieve() {
        return current.data;
    }

    @Override
    public void update(T e) {
        current.data = e;
    }

    @Override
    public void insert(T e) { // insert after current
        Node<T> tmp;
        if(empty()) {
            head = current = new Node<>(e);
        } else {
            tmp = current.next; // to save the pointer.
            current.next = new Node<>(e);
            current = current.next;
            current.next = tmp;
        }
    }

    @Override
    public void remove() {
        if(current == head) {
            head = head.next;
        } else {
            Node<T> tmp = head;
            while(tmp.next != current)
                tmp = tmp.next;
            tmp.next = current.next;
        }

        if(current.next == null)
            current = head;
        else
            current = current.next;
    }

    @Override
    public boolean full() {
        return false; // LinkedList won't be full.
    }

    @Override
    public boolean empty() {
        return head == null; // if there is no head, there is no list.
    }

    @Override
    public boolean last() {
        return current.next == null; // if there is no next, then we in the last.
    }

    // Slide Exercise
    public boolean find1(T key) {
        Node<T> tmp = head;
        current = head;
        while(current != null) {
            if(current.data.equals(key)) return true;
            current = current.next;
        }

        current = tmp;
        return false;
    }

    public boolean find2(T key) {
        Node<T> tmp = head;
        while(tmp != null) {
            if(tmp.data.equals(key)) {
                current = tmp;
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    public boolean find3(T key) {
        if(!empty()) {
            findFirst();
            while(!last()) {
                if(retrieve().equals(key))
                    return true;
                findNext();
            }
            return retrieve().equals(key);
        }
        return false;
    }

    // Tutorial Q1
    public T mostFrequentElement() {
        T mfe = null;
        int max = 0;

        Node<T> p = head;
        while(p != null) {
            Node<T> q = p;
            int count = 0;
            while(q != null) {
                if(q.data.equals(p.data))
                    count++;
                q = q.next;
            }
            if(count > max) {
                max = count;
                mfe = p.data;
            }
            p = p.next;
        }

        return mfe;
    }
}
