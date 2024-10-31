package me.waleeed.csc212.Trees.BT;

/*

Binary Trees


*/

public class BT<T> {
    BTNode<T> root, current;

    public BT() {
        root = current = null;
    }

    public boolean empty() {
        return root == null;
    }

    public T retrieve() {
        return current.data;
    }

    public void update(T val) {
        current.data = val;
    }

    public boolean insert(Relative rel, T val) {
        switch (rel) {
            case Root:
                if(!empty()) return false;
                current = root = new BTNode<T>(val);
                return true;
            case LeftChild:
                if(current.left != null) return false;
                current.left = new BTNode<T>(val);
                current = current.left;
                return true;
            case RightChild:
                if(current.right != null) return false;
                current.right = new BTNode<T>(val);
                current = current.right;
                return true;
            case Parent: // return false below
            default:
                return false;
        }
    }

//    public void deleteSubtree() {
//        if(current == root) {
//            current = root = null;
//        } else {
//            BTNode<T> p = current;
//            find(Relative.Parent);
//            if(current.left == p)
//                current.left = null;
//            else
//                current.right = null;
//            current = root;
//        }
//    }
//
//    public boolean find(Relative rel) {
//        switch (rel) {
//            case Root:
//                current = root;
//                return true;
//            case Parent:
//                if(current == root) return false;
//                current
//        }
//    }
}
