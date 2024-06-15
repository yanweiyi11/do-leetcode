package cn.nnnu.day0611;

/**
 * @author yanweiyi
 */
public class P0019 {

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        Solution solution = new Solution();
        ListNode listNode = solution.removeNthFromEnd(l1, 2);
        System.out.println("listNode = " + listNode);
    }

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode fakeHead = new ListNode(0, head);
            ListNode fast = fakeHead;
            ListNode slow = fakeHead;

            n++;
            while (n-- > 0 && fast != null) {
                fast = fast.next;
            }

            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }

            slow.next = slow.next.next;
            return fakeHead.next;
        }

        public ListNode removeNthFromEnd2(ListNode head, int n) {
            ListNode fakeHead = new ListNode(0, head);
            remove(fakeHead, n);
            return fakeHead.next;
        }

        int remove(ListNode node, int n) {
            if (node.next == null) {
                return 1;
            }
            int result = 1 + remove(node.next, n);
            if ((result - 1) == n) {
                node.next = node.next.next;
            }
            return result;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "{" + "val=" + val + ", next=" + next + '}';
        }
    }
}
