package me.waleeed.csc212.List;


public class DoubleLinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> current;

    public DoubleLinkedList() {
        head = current = null;
    }

    @Override
    public void findFirst() {
        current = head;
    }

    public void findPrevious() {
        current = current.previous;
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
        Node<T> tmp = new Node<>(e);
        if(empty()) {
            head = current = tmp;
        } else {
            tmp.next = current.next;
            tmp.previous = current;
            if(current.next != null) {
                current.next.previous = tmp;
            }
            current.next = tmp;
            current = tmp;
        }
    }

    @Override
    public void remove() {
        if(current == head) {
            head = head.next;
        } else {
            current.previous.next = current.next;
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
        return head == null;
    }

    public boolean first() {
        return current.previous == null;
    }

    @Override
    public boolean last() {
        return current.next == null;
    }


    // Tutorial
    public void removeBetween(T e1, T e2) {
        if(e1 == null && e2 == null) return;
        Node<T> tmp = head;
        Node<T> e1Node= null, e2Node = null;
        while(tmp != null) {
            if(tmp.data.equals(e1))
                e1Node = tmp;
            if(tmp.data.equals(e2))
                e2Node = tmp;
            tmp = tmp.next;
        }

        e1Node.next = e2Node;
        e2Node.previous = e1Node;
        current = head;
    }

}
