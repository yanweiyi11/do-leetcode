package cn.nnnu.day0611;

/**
 * @author yanweiyi
 */
public class P0142 {

    public static void main(String[] args) {
        ListNode l4 = new ListNode(-4);
        ListNode l3 = new ListNode(0, l4);
        ListNode l2 = new ListNode(2, l3);
        l4.next = l2;
        ListNode l1 = new ListNode(3, l2);

        // ListNode l1 = new ListNode(1);
        // ListNode l2 = new ListNode(2);
        // l1.next = l2;
        // l2.next = l1;

        Solution solution = new Solution();
        ListNode listNode = solution.detectCycle(l1);
        System.out.println("listNode = " + listNode);
    }

    static class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    ListNode index1 = fast;
                    ListNode index2 = head;
                    while (index1 != index2) {
                        index1 = index1.next;
                        index2 = index2.next;
                    }
                    return index1;
                }
            }
            return null;
        }

        public ListNode detectCycle2(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            int n = 0;
            while (fast != null && fast.next != null) {
                fast = fast.next;
                n++;
                for (int i = 0; i < n; i++) {
                    if (slow == fast.next) {
                        return slow;
                    }
                    slow = slow.next;
                }
                slow = head;
            }
            return null;
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
            return "{" + "val=" + val + '}';
        }
    }
}
