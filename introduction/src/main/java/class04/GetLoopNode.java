package class04;

import util.Node;

/**
 * @Author: imxiaolong
 * @Date: 2024/10/28 21:39
 * @Description:
 */
public class GetLoopNode {


    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        // 这里先都走各自的一步，好在后面判断相等情况
        Node fast = head.next;
        Node slow = head.next.next;

        while (fast != slow) {
            if (slow.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        // 走到这里说明相等了，将快指针调到head位置
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static Node findSameNodeWithNoLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        int n = 0;
        // 分别遍历两个链路的长度
        Node cur1 = head1;
        Node cur2 = head2;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        // 这里可以提前判断一下，如果他们末尾都不想等，直接返回null
        if (cur1 != cur2) {
            return null;
        }
        // 得到的n就是他们的差值
        cur1 = n > 0 ? head1 : head2; // 这里找到他们当中长度长的给cur1；
        cur2 = cur1 == head1 ? head2 : head1; // 将短的给cur2
        n = Math.abs(n);
        // 长的先走他们的差的步数
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        // 最后循环查看他们是否相等
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) {
            int n = 0;
            cur1 = head1;
            cur2 = head2;
            while (cur1.next != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2.next != loop2) {
                n--;
                cur2 = cur2.next;
            }
            n = Math.abs(n);
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            while (n != 0) {
                cur1 = cur1.next;
                n--;
            }
            while (cur2 != cur1) {
                cur2 = cur2.next;
                cur1 = cur1.next;
            }
            return cur1;
        } else {
            cur1 = loop1;
            while (cur1.next != loop1) {
                if (cur1.next == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
        }
        return null;
    }
}
