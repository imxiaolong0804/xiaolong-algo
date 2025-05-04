package com.xiaolong.practice;

/**
 * @Author: imxiaolong
 * @Date: 2025/3/26 16:17
 * @Description:
 */
public class LianBiao {

    public static class Node {
        public int val;
        public Node next;

        public Node() {

        }

        public Node(int _val) {
            val = _val;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        print(head);

        // 先找到链表中点
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node halfnode = slow.next;
        halfnode = reverse(halfnode);
        slow.next = null;
        slow = head;
        while (halfnode != null) {
            Node temp = slow.next;
            slow.next = halfnode;
            Node temp2 = halfnode.next;
            halfnode.next = temp;
            slow = temp;
            halfnode = temp2;
        }
        print(head);

    }


    public static void print(Node node) {
        while (node != null) {
            if (node.next == null) {
                System.out.println(node.val);
            } else {
                System.out.print(node.val + "-");
            }
            node = node.next;
        }
    }

    public static Node reverse(Node head) {
        Node pre = null;
        Node cur = head;
        while (cur != null) {
            Node temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }



}
