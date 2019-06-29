package com.xinming;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目描述
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class Q3 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        Q3 q3 = new Q3();
//        ArrayList<Integer> integers = q3.printListFromTailToHead(node1);
        ArrayList<Integer> integers = q3.printListFromTailToHead3(node1);
        integers.forEach(System.out::println);
    }

    //递归实现
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        printListFromTailToHead2(list, listNode);
        return list;
    }

    public void printListFromTailToHead2(ArrayList<Integer> list, ListNode listNode) {
        if (listNode.next != null) {
            printListFromTailToHead2(list, listNode.next);
        }
        list.add(listNode.val);
    }

    //Stack实现
    //递归实现
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        if (listNode == null) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        return list;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}