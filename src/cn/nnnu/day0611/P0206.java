package cn.nnnu.day0611;

/**
 * @author yanweiyi
 */
public class P0206 {
    public static void main(String[] args) {
        // 1,2,3,4,5
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        Solution solution = new Solution();
        System.out.println(solution.reverseList(l1));
    }

    static class Solution {
        public ListNode reverseList(ListNode head) {
            return reverse(head, null);
        }

        public ListNode reverse(ListNode cur, ListNode pre) {
            if (cur == null) {
                return pre;
            }
            ListNode temp = cur.next;
            cur.next = pre;
            return reverse(temp, cur);
        }

        public ListNode reverseList3(ListNode head) {
            ListNode cur = head;
            ListNode pre = null;
            while (cur != null) {
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
            return pre;
        }

        public ListNode reverseList2(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode cur = head;
            ListNode save = new ListNode(cur.val, null);
            while (cur.next != null) {
                cur = cur.next;
                save = new ListNode(cur.val, save);
            }
            return save;
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
            return "{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}