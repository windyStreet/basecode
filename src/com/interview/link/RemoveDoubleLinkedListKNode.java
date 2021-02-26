package com.interview.link;


public class RemoveDoubleLinkedListKNode {
    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            this.value = data;
        }
    }

    public DoubleNode removeLastKthNode(DoubleNode head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }
        DoubleNode cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0) {
            head = head.next;
            head.last = null;
        }
        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            DoubleNode newNext = cur.next.next;
            cur.next = newNext;
            if (newNext != null) {
                newNext.last = cur;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        DoubleNode dnode0 = new DoubleNode(0);
        DoubleNode dnode1 = new DoubleNode(1);
        DoubleNode dnode2 = new DoubleNode(2);
        DoubleNode dnode3 = new DoubleNode(3);
        DoubleNode dnode4 = new DoubleNode(4);
        dnode0.last=null;
        dnode0.next = dnode1;

        dnode1.last = dnode0;
        dnode1.next = dnode2;

        dnode2.last = dnode1;
        dnode2.next = dnode3;

        dnode3.last = dnode2;
        dnode3.next = dnode4;

        dnode4.last = dnode3;
        dnode4.next = null;

//0 1 2 3 4
        RemoveDoubleLinkedListKNode rdllk = new RemoveDoubleLinkedListKNode();
        DoubleNode res_dnode = rdllk.removeLastKthNode(dnode0, 3);
        while (res_dnode != null) {
            System.out.println(res_dnode.value);
            res_dnode = res_dnode.next;
        }
    }
}
