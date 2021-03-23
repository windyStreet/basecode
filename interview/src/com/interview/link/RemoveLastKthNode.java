package com.interview.link;

/**
 * 分别实现两个函数，一个可以删除单链表中倒数第 K 个节点，另一个可以删除双链表中倒
 * 数第 K 个节点。
 */
public class RemoveLastKthNode {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public Node removeLastKthNode(Node head, int lastKth) {
        // lastKth < 1 ,则无法删除任何对象
        if (head == null || lastKth < 1) {
            return head;
        }
        Node cur = head;
        // 计算长度
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }
        // 如果删除节点长度刚好与删除节点的位置相同，则删除的就是顶节点
        if (lastKth == 0) {
            head = head.next;
        }
        // 如果删除节点小于0，则说明删除位置在链表中，需要找到为0的位置，同
        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(6);
        node.next.next.next.next = new Node(8);
        RemoveLastKthNode rlkn = new RemoveLastKthNode();
        Node res_node = rlkn.removeLastKthNode(node,4);
        while(res_node.next != null){
            System.out.println(res_node.value);
            res_node = res_node.next;
        }

    }
}
