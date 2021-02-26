package com.interview.link;

/**
 * 【题目】
 * 分别实现反转单向链表和反转双向链表的函数。
 * 【要求】
 * 如果链表长度为 N，时间复杂度要求为 O(N)，额外空间复杂度要求为 O(1)
 *
 *
 *
 * 点到第 to 个节点这一部分进行反转。
 * 例如：
 * 1->2->3->4->5->null，from=2，to=4
 * 调整结果为：1->4->3->2->5->null
 * 再如：
 * 1->2->3->null，from=1，to=3
 * 调整结果为：3->2->1->null
 * 【要求】
 * 1．如果链表长度为 N，时间复杂度要求为 O(N)，额外空间复杂度要求为 O(1)。
 * 第 2 章 链表问题
 * 49
 * 2．如果不满足 1<=from<=to<=N，则不用调整
 *
 *
 */
public class LinkReverse {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    //单向链表反转
    public Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            this.value = data;
        }
    }

    //双向链表反转
    public DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    //反转部分单向链表
    public Node reversePart(Node head, int from, int to) {
        int len = 0;
        Node node1 = head;
        Node fPre = null;
        Node tPos = null;
        while (node1 != null) {
            len++;
            fPre = len == from - 1 ? node1 : fPre;
            tPos = len == to + 1 ? node1 : tPos;
            node1 = node1.next;
        }
        if (from > to || from < 1 || to > len) {
            return head;
        }
        node1 = fPre == null ? head : fPre.next;
        Node node2 = node1.next;
        node1.next = tPos;
        Node next = null;
        while (node2 != tPos) {
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if (fPre != null) {
            fPre.next = node1;
            return head;
        }
        return node1;
    }

    public static void main(String[] args) {
        DoubleNode dnode0 = new DoubleNode(0);
        DoubleNode dnode1 = new DoubleNode(1);
        DoubleNode dnode2 = new DoubleNode(2);
        DoubleNode dnode3 = new DoubleNode(3);
        DoubleNode dnode4 = new DoubleNode(4);
        dnode0.last = null;
        dnode0.next = dnode1;

        dnode1.last = dnode0;
        dnode1.next = dnode2;

        dnode2.last = dnode1;
        dnode2.next = dnode3;

        dnode3.last = dnode2;
        dnode3.next = dnode4;

        dnode4.last = dnode3;
        dnode4.next = null;

        LinkReverse lr = new LinkReverse();
        DoubleNode res_dnode = lr.reverseDoubleList(dnode0);
        while (res_dnode != null) {
            System.out.println(res_dnode.value);
            res_dnode = res_dnode.next;
        }

        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = new Node(7);
        LinkReverse lr_node = new LinkReverse();
//        Node red_node = lr_node.reverseList(node);
        Node red_node = lr_node.reversePart(node, 1, 6);
//        Node red_node = lr_node.reversePart(node, 1, 7);
//        Node red_node = lr_node.reversePart(node, 0, 7);
//        Node red_node = lr_node.reversePart(node, 1, 8);
//        Node red_node = lr_node.reversePart(node, 3, 8);
        while (red_node != null) {
            System.out.println(red_node.value);
            red_node = red_node.next;
        }


    }
}
