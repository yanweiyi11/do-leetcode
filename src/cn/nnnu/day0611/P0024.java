package cn.nnnu.day0611;

/**
 * @author yanweiyi
 */
public class P0024 {

    public static void main(String[] args) {
        Solution.ListNode l4 = new Solution.ListNode(4);
        Solution.ListNode l3 = new Solution.ListNode(3, l4);
        Solution.ListNode l2 = new Solution.ListNode(2, l3);
        Solution.ListNode l1 = new Solution.ListNode(1, l2);
        Solution solution = new Solution();
        System.out.println(solution.swapPairs(l1));
    }

    static class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode fakeHead = new ListNode(0, head);
            ListNode cur = fakeHead;
            while (cur.next != null && cur.next.next != null) {
                ListNode temp = cur.next;
                ListNode temp2 = cur.next.next.next;
                cur.next = cur.next.next;
                cur.next.next = temp;
                temp.next = temp2;

                cur = cur.next.next;
            }
            return fakeHead.next;
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
}