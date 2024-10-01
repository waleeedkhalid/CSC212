package me.waleeed.csc212;

import me.waleeed.csc212.List.ArrayList;
import me.waleeed.csc212.List.DoubleLinkedList;
import me.waleeed.csc212.List.LinkedList;
import me.waleeed.csc212.List.List;
import me.waleeed.csc212.PriorityQueue.LinkedPQ;
import me.waleeed.csc212.PriorityQueue.PQElement;
import me.waleeed.csc212.PriorityQueue.PriorityQueue;
import me.waleeed.csc212.Queue.ArrayQueue;
import me.waleeed.csc212.Queue.LinkedQueue;
import me.waleeed.csc212.Queue.Queue;
import me.waleeed.csc212.Stack.LinkedStack;
import me.waleeed.csc212.Stack.Stack;

public class Main {


    // List
    public static <T> void printList(List<T> l) {
        if(l.empty()) {
            System.out.println("{EMPTY LIST}");
            return;
        }
        l.findFirst();
        System.out.print("{");
        while(!l.last()) {
            System.out.print(l.retrieve());
            l.findNext();
        }
        System.out.println(l.retrieve()+"}");
    }
    public static <T> int length(List<T> list) {
        int counter = 0;

        if(list.empty()) return counter;
        list.findFirst();
        while(!list.last()) {
            list.findNext();
            counter++;
        }
        counter++;

        return counter;
    }
    public static void TestLength() {
        ArrayList<String> al = new ArrayList<>(10);
        LinkedList<String> ll = new LinkedList<>();
        String s1= "xyz", s2 = "abc";

        //ArrayList
        al.insert(s1);
        al.insert(s2);
        al.findFirst();

        System.out.println(al.retrieve());
        System.out.println(al.full());

        //LinkedList
        ll.insert(s1);
        ll.insert(s2);
        ll.findFirst();

        System.out.println(ll.full());

        System.out.println(length(ll));
        System.out.println("Hello, World");
    }
    public static <T> boolean find(List<T> list, T key) {
        if(list.empty()) return false;
        list.findFirst();
        while(!list.last()) {
            if(list.retrieve().equals(key)) return true;
            list.findNext();
        }

        return list.retrieve().equals(key);
    }
    public static void TestFind() {
        ArrayList<String> al = new ArrayList<>(10);
        LinkedList<String> ll = new LinkedList<>();
        String s1= "xyz", s2 = "abc";

        //ArrayList
        al.insert(s1);
        al.insert(s2);
        al.findFirst();

        System.out.println(find(al, "abc"));

        //LinkedList

        System.out.println(find(ll, "xyz"));
    }
    public static void TestFindMemberMethod() {
        LinkedList<String> ll = new LinkedList<>();
        String s1= "xyz", s2 = "abc";

        ll.insert("xyzz");
        ll.insert("abc");
        ll.insert("xyz");

        System.out.println(ll.find1("xyz"));
        System.out.println(ll.find2("xyz"));
        System.out.println(ll.find3("xyz"));
    }

    // Queues & Stacks
    public static <T> void printQueue(Queue<T> q) {
//        if(q.length() <= 0) {
//            System.out.println("{EMPTY QUEUE}");
//            return;
//        }

        int count = q.length();
        System.out.print("{");
        while(count > 0) {
            T e = q.serve();
            System.out.print(e);
            q.enqueue(e);
            count--;
        }
        System.out.println("}");

    }
    public static <T> void printPriorityQueue(LinkedPQ<T> pq) {
        int count = pq.length();
        System.out.print("{");
        while(count > 0) {
            PQElement<T> e = pq.serve();
            System.out.print("["+e.data+","+e.priority+"]");
            pq.enqueue(e.data,e.priority);
            count--;
        }
        System.out.println("}");
    }

    public static <T> T enquiry(Queue<T> q) {
        T data = q.serve();
        q.enqueue(data);
        for(int i = 0; i < q.length() - 1; i++) {
            q.enqueue(q.serve());
        }
        return data;
    }
    public static void print() {
        ArrayQueue<Integer> aq = new ArrayQueue<>(10);

        aq.enqueue(9);
        aq.enqueue(3);
        aq.enqueue(5);
        aq.enqueue(7);

        aq.print();
    }
    public static boolean isOrdered(Queue<Integer> q) {
        boolean flag = true;
        int e1 = q.serve();
        q.enqueue(e1);
        for(int i = 1; i < q.length(); i++) {
            int e2 = e1; // prev
            e1 = q.serve(); // next
            if(e1 < e2)
                flag = false;
            q.enqueue(e2);
        }
        return flag;
    }
    public static void TestisOrdered() {
        LinkedQueue<Integer> lq = new LinkedQueue<>();
        lq.enqueue(1);
        lq.enqueue(3);
        lq.enqueue(5);
        lq.enqueue(5);
        lq.enqueue(10);
        ArrayQueue<Integer> aq = new ArrayQueue<>(4);
        aq.enqueue(4);
        aq.enqueue(5);
        aq.enqueue(1);


        System.out.println(isOrdered(lq));
        System.out.println(isOrdered(aq));
    }
    public static int stackSum(Stack<Integer> s) {
        if(s.empty()) return 0; // base case
        int x = s.pop();
        int y = stackSum(s);
        s.push(x);
        return x + y;
    }
    public static void TeststackSum() {
        LinkedStack<Integer> ls = new LinkedStack<>();
        ls.push(10);
        ls.push(1);
        ls.push(22);

        printStack(ls);
        System.out.println(stackSum(ls));
        printStack(ls);
    }
    public static <T> void printStack(Stack<T> s) {
        LinkedStack<T> tmp = new LinkedStack<>();
        System.out.print("[");
        while(!s.empty()) {
            T x = s.pop();
            System.out.print(x);
            tmp.push(x);
        }
        System.out.println("]");

        while(!tmp.empty()) {
            s.push(tmp.pop());
        }
    }
    public static <T> void m(Stack<T> s) {
        ArrayQueue<T> q = new ArrayQueue<>(10);
        while(!s.empty())
            q.enqueue(s.pop());
        int n = q.length();
        for(int i = 0; i < n; i++) {
            T e = q.serve();
            if(i % 2 == 0)
                s.push(e);
        }
        printStack(s);
    }
    public static void Testm() {
        LinkedStack<String> s = new LinkedStack<>();
        s.push("A");
        s.push("B");
        s.push("C");
        s.push("D");
        s.push("E");
        s.push("F");

        m(s);
    }


    // Lectures
    public void Sep24Lecture() {
        // 24 Sep - Lecture
        LinkedStack<Integer> s = new LinkedStack<>();

        // Postfix Expression: Last number is the result otherwise there is a problem.
        // infix: 6*(5+((2+3)*8)+3)



        // Converting from infix to postfix
        // operand = number, operator tokens are (), *, /, + and -
        // infix: 6*(5+((2+3)*8)+3)

        LinkedStack<String> opstack = new LinkedStack<>();
        LinkedStack<String> postfix = new LinkedStack<>();
        postfix.push("6");
        opstack.push("*");
        opstack.push("(");
        postfix.push("5");
        opstack.push("+");
        opstack.push("(");
        opstack.push("(");
        postfix.push("2");
        opstack.push("+");
        postfix.push("3");
        postfix.push(opstack.pop());
        opstack.pop();
        opstack.push("*");
        postfix.push("8");
        postfix.push(opstack.pop());
        opstack.pop();
        opstack.push("+");
        postfix.push(opstack.pop());
        opstack.pop();
        postfix.push("3");
        opstack.pop();
        postfix.push(opstack.pop());


        while(!postfix.empty()) {
            System.out.println(postfix.pop());
        }

        // ParenMatch(X. n): push the (,{,[ and pop when ),},]


        // Applications of Stacks: Evaluating postfix expressions, converting infix to postfx, evaluate arithmetic expressions.
    }


    public static void main(String[] args) {
        TestreplaceEnds();
    }



//class ListsAndDLLTutorial {

    // Problem 1
    public static void TestmostFreqElement() {
        LinkedList<String> al = new LinkedList<>();
        al.insert("A");
        al.insert("A");
        al.insert("C");
        al.insert("B");
        al.insert("B");
        al.insert("C");
        al.insert("D");
        al.insert("E");
        al.insert("F");
        System.out.println(al.mostFrequentElement());
    }

    // Problem 2
    public static <T> void circularLeftShift(List<T> l, int n) {
        if(l.empty()) return;
        for (int i = 0; i < n; i++) {
            l.findFirst();
            T elem = l.retrieve();
            l.remove();
            while(!l.last())
                l.findNext();
            l.insert(elem);
        }
    }
    public static void TestcircularLeftShift() {
        LinkedList<String> ll = new LinkedList<>();
        ArrayList<String> al = new ArrayList<>(10);
        ll.insert("A");
        ll.insert("B");
        ll.insert("C");
        ll.insert("D");
        ll.insert("E");
        al.insert("A");
        al.insert("B");
        al.insert("C");
        al.insert("D");
        al.insert("E");

        circularLeftShift(ll, 1);
        circularLeftShift(al, 2);

        printList(ll);
        printList(al);

    }

    // Problem 3
    public static void TestremoveBetween() {
        DoubleLinkedList<String> al = new DoubleLinkedList<>();
        al.insert("A");
        al.insert("B");
        al.insert("C");
        al.insert("D");
        al.insert("E");
        al.insert("F");

        printList(al);

        al.removeBetween("B", "E");

        printList(al);
    }

    // Problem 4
    public static <T> void reverseCopy(DoubleLinkedList<T> l1, DoubleLinkedList<T> l2) {
        if(l1.empty()) return;
        l1.findFirst();
        while(!l1.last())
            l1.findNext();
        while(!l1.first()) {
            l2.insert(l1.retrieve());
            l1.findPrevious();
        }
        l2.insert(l1.retrieve());

    }

    public static void TestreverseCopy() {
        DoubleLinkedList<String> al = new DoubleLinkedList<>();
        al.insert("A");
        al.insert("B");
        al.insert("C");
        al.insert("D");
        al.insert("E");
        al.insert("F");
        DoubleLinkedList<String> al2 = new DoubleLinkedList<>();

        printList(al);
        printList(al2);

        reverseCopy(al, al2);

        printList(al);
        printList(al2);
    }




//class QueuesAndStacksTutorial {

    // Problem 1
    public static <T> void split(Queue<T> q, Queue<T> oq, Queue<T> eq) {
        recSplit(q, oq, eq, q.length(), 1);
    }

    private static <T> void recSplit(Queue<T> q, Queue<T> oq, Queue<T> eq, int count, int pos) {
        if(pos > count) return; // base case
        T element = q.serve();
        q.enqueue(element);
        if(pos % 2 != 0) {
            if (!oq.full())
                oq.enqueue(element);
        } else {
            if(!eq.full())
                eq.enqueue(element);
        }
        recSplit(q, oq, eq, count, pos + 1);
    }

    public static void TestSplit() {
        Queue<String> q1 = new LinkedQueue<>();
        Queue<String> oddq = new LinkedQueue<>();
        Queue<String> evenq = new LinkedQueue<>();



        q1.enqueue("A");
        q1.enqueue("B");
        q1.enqueue("C");
        q1.enqueue("D");
        q1.enqueue("E");

        printQueue(q1);

        split(q1 , oddq, evenq);

        printQueue(q1);
        printQueue(oddq);
        printQueue(evenq);

    }


    // Problem 2

    public static <T> void removePQ(LinkedPQ<T> pq, int p) {
        LinkedPQ<T> tmpPQ = new LinkedPQ<>(); // After Java 6 u don't have to include the type after equals.
        int count = pq.length();
        for(int i = 0; i < count; i++) {
            PQElement<T> pqe = pq.serve();
            if(pqe.priority >= p)
                tmpPQ.enqueue(pqe.data, pqe.priority);
        }
        count = tmpPQ.length();
        for (int i = 0; i < count; i++) {
            PQElement<T> pqe = pq.serve();
            pq.enqueue(pqe.data, pqe.priority);
        }
    }

    public static void TestremovePQ() {
        LinkedPQ<String> pq = new LinkedPQ<>();
        pq.enqueue("A", 10);
        pq.enqueue("D", 8);
        pq.enqueue("B", 5);
        pq.enqueue("E", 3);
        pq.enqueue("C", 2);

        removePQ(pq, 5);


    }

    // Problem 3

    public static <T> boolean search(Stack<T> st, T e) {
        boolean found = false;
        if (st.empty()) return found;
        T s = st.pop();
        if(s.equals(e)) return true;
        found = search(st, e);
        st.push(s);
        return found;
    }

    public static void Testsearch() {
        Stack<Integer> s = new LinkedStack<>();
        s.push(5);
        s.push(7);
        s.push(5);
        s.push(3);
        s.push(2);

        System.out.println(search(s, 3));
        System.out.println(search(s, 1));
    }

    // Quiz 2: replaceEnds(Stack<Integer> s1, Stack<Integer> s2)

    public static void replaceEnds(Stack<Integer> s1, Stack<Integer> s2) {
        Stack<Integer> tmp1 = new LinkedStack<>();  // Temporary stack for new s1
        Stack<Integer> tmp2 = new LinkedStack<>();  // Temporary stack for s2
        // getLast
        int l = s2.pop();
        s2.push(l);
        // getFirst
        while(!s2.empty())
            tmp2.push(s2.pop());
        int f = tmp2.pop();
        s2.push(f);
        // return back s2 elements.
        while(!tmp2.empty())
            s2.push(tmp2.pop());
        // push the last element in tmp1
        tmp1.push(l);
        s1.pop(); // delete last element
        // push s1 elements without the last
        while(!s1.empty())
            tmp1.push(s1.pop());
        // remove the first element in s1
        tmp1.pop();
        // add first element from s2 in s1
        tmp1.push(f);
        // reverse tmp1 in s1
        while(!tmp1.empty()) {
            s1.push(tmp1.pop());
        }
    }

    public static void TestreplaceEnds() {
        Stack<Integer> s1 = new LinkedStack<>();
        Stack<Integer> s2 = new LinkedStack<>();
        // Test 1
        s1.push(6);
        s1.push(4);
        s1.push(10);

        s2.push(6);
        s2.push(2);
        s2.push(3);
        s2.push(1);
        s2.push(5);
        s2.push(7);
        // Test 2
//        s1.push(1);
//        s1.push(2);
//        s1.push(3);
//        s1.push(9);
//        s1.push(2);
//
//        s2.push(6);
//        s2.push(2);
//        s2.push(3);
//        s2.push(0);
//        s2.push(5);
//        s2.push(7);
//        s2.push(9);

        printStack(s1);
        printStack(s2);

        replaceEnds(s1, s2);

        printStack(s1);
        printStack(s2);
    }
}