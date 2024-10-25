package me.waleeed.csc212.PriorityQueue;

import me.waleeed.csc212.Node;
import me.waleeed.csc212.Queue.Queue;

public class LinkedPQ<T> implements PriorityQueue<T> {
    private int size;
    private PQNode<T> head;

    public LinkedPQ() {
        head = null;
        size = 0;
    }

    public PQElement<T> serve() {
        if(size == 0) return null;
        PQNode<T> tmp = head;
        PQElement<T> pqe = new PQElement<>(tmp.data, tmp.priority);
        head = head.next;
        size--;
        return pqe;
    }

    public void enqueue(T e, int pty) {
        PQNode<T> tmp = new PQNode<>(e, pty);
        if( (size == 0) || (pty > head.priority) ) {
            tmp.next = head;
            head = tmp;
        } else {
            PQNode<T> p = head;
            PQNode<T> q = null;
            while( (p != null) && (pty <= p.priority) ) {
                q = p;
                p = p.next;
            }
            tmp.next = p;
            q.next = p;
        }
        size++;
    }

    public int length() {
        return size;
    }

    public boolean full() {
        return false; // LinkedQueue won't be full.
    }
}
