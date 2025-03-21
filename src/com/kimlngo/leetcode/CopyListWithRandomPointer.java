package com.kimlngo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public static void main(String[] args) {
//        Node zero = new Node(7);
//
//        Node one = new Node(13);
//        Node two = new Node(11);
//        Node three = new Node(10);
//        Node four = new Node(1);
//
//        zero.next = one;
//        one.next = two;
//        two.next = three;
//        three.next = four;
//
//        zero.random = null;
//        one.random = zero;
//        two.random = four;
//        three.random = two;
//        four.random = zero;
//
//        System.out.println(zero);
//        System.out.println(copyRandomList(zero));

//        Node zero = new Node(1);
//        Node one = new Node(2);
//
//        zero.next = one;
//
//        zero.random = one;
//        one.random = one;
//
//        System.out.println(copyRandomList(zero));

        Node zero = new Node(-1);
        zero.random = zero;

        System.out.println(copyRandomList(zero));
    }

    private static Node copyRandomList(Node head) {
        if (head == null) return null;
        else if (head.next == null) {
            Node newHead = new Node(head.val);
            if(head.random == null) newHead.random = null;
            else newHead.random = newHead;
            return newHead;
        }

        //linked list has 2 and above nodes
        Map<Node, Node> map = new HashMap<>(); //key-val pair [old, new]
        Node newHead = new Node(head.val);
        Node origCur = head;
        Node newCur = newHead;
        map.put(head, newHead);

        //create a deep-copy new linked list
        while (origCur.next != null) {
            Node oldNext = origCur.next;
            Node newNext = new Node(oldNext.val);
            newCur.next = newNext;
            map.put(oldNext, newNext);

            origCur = origCur.next;
            newCur = newCur.next;
        }

        //linking the random
        origCur = head;
        newCur = newHead;

        while(origCur != null) {
            Node oldRandom = origCur.random;
            newCur.random = oldRandom == null ? null : map.get(oldRandom);

            origCur = origCur.next;
            newCur = newCur.next;
        }

        return newHead;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}