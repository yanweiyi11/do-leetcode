package cn.nnnu.day0610;

/**
 * @author yanweiyi
 */
public class P0203 {
    public static void main(String[] args) {
        // ListNode listNode6_1 = new ListNode(6);
        // ListNode listNode5 = new ListNode(5, listNode6_1);
        // ListNode listNode4 = new ListNode(4, listNode5);
        // ListNode listNode3 = new ListNode(3, listNode4);
        // ListNode listNode6_2 = new ListNode(6, listNode3);
        // ListNode listNode2 = new ListNode(2, listNode6_2);
        // ListNode listNode1 = new ListNode(1, listNode2);
        //
        // ListNode listNode = removeElements(listNode1, 6);
        // System.out.println(listNode);

        // ListNode listNode1 = new ListNode(1);
        // ListNode listNode = removeElements(listNode1, 2);
        // System.out.println(listNode);

        ListNode listNode7_1 = new ListNode(7);
        ListNode listNode7_2 = new ListNode(7, listNode7_1);
        ListNode listNode7_3 = new ListNode(7, listNode7_2);
        ListNode listNode7_4 = new ListNode(7, listNode7_3);
        ListNode listNode = removeElements(listNode7_4, 7);
        System.out.println(listNode);
    }

    public static class ListNode {
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

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode fakeHead = new ListNode(-1, head);
        ListNode cur = fakeHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return fakeHead.next;
    }

    public static ListNode removeElements2(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
