package com.interview.link;

/**
 * 给定一个单向链表的头节点 head，节点的值类型是整型，再给定一个整数 pivot。实现一个
 * 调整链表的函数，将链表调整为左部分都是值小于 pivot 的节点，中间部分都是值等于 pivot 的
 * 节点，右部分都是值大于 pivot 的节点。除这个要求外，对调整后的节点顺序没有更多的要求。
 * 例如：链表 9->0->4->5->1，pivot=3。
 * 调整后链表可以是 1->0->4->9->5，也可以是 0->1->9->5->4。总之，满足左部分都是小于 3
 * 程序员代码面试指南：IT 名企算法与数据结构题目最优解（第 2 版）
 * 60
 * 的节点，中间部分都是等于 3 的节点（本例中这个部分为空），右部分都是大于 3 的节点即可。
 * 对某部分内部的节点顺序不做要求。
 * 进阶：
 * 在原问题的要求之上再增加如下两个要求。  在左、中、右三个部分的内部也做顺序要求，要求每部分里的节点从左到右的顺序与
 * 原链表中节点的先后次序一致。
 * 例如：链表 9->0->4->5->1，pivot=3。调整后的链表是 0->1->9->4->5。在满足原问题要求的
 * 同时，左部分节点从左到右为 0、1。在原链表中也是先出现 0，后出现 1；中间部分在本例中
 * 为空，不再讨论；右部分节点从左到右为 9、4、5。在原链表中也是先出现 9，然后出现 4，最
 * 后出现 5。  如果链表长度为 N，时间复杂度请达到 O(N)，额外空间复杂度请达到 O(1)。
 */
public class DivideLinkByKey {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }

        public void addNode(int data) {
            Node node = this;
            while (null != node.next) {
                node = node.next;
            }
            node.next = new Node(data);
        }
    }

    public Node listPartition1(Node head, int pivot) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[i];
        cur = head;
        for (i = 0; i != nodeArr.length; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodeArr, pivot);
        for (i = 1; i != nodeArr.length; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }

    public void arrPartition(Node[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index != big) {
            if (nodeArr[index].value < pivot) {
                swap(nodeArr, ++small, index++);
            } else if (nodeArr[index].value == pivot) {
                index++;
            } else {
                swap(nodeArr, --big, index);
            }
        }
    }

    public void swap(Node[] nodeArr, int a, int b) {
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }


    public Node listPartition2(Node head, int pivot) {
        Node sH = null; // 小的头
        Node sT = null; // 小的尾
        Node eH = null; // 相等的头
        Node eT = null; // 相等的尾
        Node bH = null; // 大的头
        Node bT = null; // 大的尾
        Node next = null; // 保存下一个节点
        // 所有的节点分进三个链表中
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (sH == null) {
                    sH = head;
                } else {
                    sT.next = head;
                }
                sT = head;
            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                } else {
                    eT.next = head;
                }
                eT = head;
            } else {
                if (bH == null) {
                    bH = head;
                } else {
                    bT.next = head;
                }
                bT = head;
            }
            head = next;
        }
        // 小的和相等的重新连接
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        // 所有的重新连接
        if (eT != null) {
            eT.next = bH;
        }
        return sH != null ? sH : eH != null ? eH : bH;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.addNode(3);
        node.addNode(9);
        node.addNode(7);
        node.addNode(311);
        node.addNode(12);
        node.addNode(6);
        node.addNode(9);
        node.addNode(8);
        node.addNode(121);
        node.addNode(13);
        DivideLinkByKey dlb = new DivideLinkByKey();
        Node res = dlb.listPartition1(node, 9); //1 3 7 8 6 9 9 12 121 13 311
//        Node res = dlb.listPartition2(node, 9); //1 3 7 6 8 9 9 311 12 121 13
        while (res != null) {
            System.out.print(res.value + " ");
            res = res.next;
        }
    }
}
