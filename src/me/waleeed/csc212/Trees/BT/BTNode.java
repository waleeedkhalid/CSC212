package me.waleeed.csc212.Trees.BT;

public class BTNode <T> {
    public T data;
    public BTNode<T> left, right;

    public BTNode(T val) {
        data = val;
        left = right = null;
    }

    public BTNode(T val, BTNode<T> left, BTNode<T> right) {
        data = val;
        this.left = left;
        this.right = right;
    }
}
