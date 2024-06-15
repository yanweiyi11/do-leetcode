package cn.nnnu.day0611;

/**
 * @author yanweiyi
 */
public class P0707_2 {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        // myLinkedList.addAtHead(1);
        // myLinkedList.addAtTail(3);
        // myLinkedList.addAtIndex(1, 2);               // 链表变为 1->2->3
        // int val1 = myLinkedList.get(1);              // 返回 2
        // myLinkedList.deleteAtIndex(1);               // 现在，链表变为 1->3
        // int val2 = myLinkedList.get(1);              // 返回 3

        // myLinkedList.addAtTail(1);
        // int val3 = myLinkedList.get(0);

        // myLinkedList.addAtIndex(1, 0);
        // int val4 = myLinkedList.get(0);

        // myLinkedList.addAtHead(3);
        // myLinkedList.addAtTail(2);
        // myLinkedList.addAtIndex(3, 5);
    }

    static class MyLinkedList {
        static class Node {
            int val;
            Node next;

            public Node(int val) {
                this.val = val;
            }
        }

        Node head;
        int size;

        public MyLinkedList() {
            head = new Node(0);
            size = 0;
        }

        int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            Node cur = head;
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
            return cur.val;
        }

        void addAtHead(int val) {
            Node node = new Node(val);
            node.next = head.next;
            head.next = node;
            size++;
        }

        void addAtTail(int val) {
            Node node = new Node(val);
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
            size++;
        }

        void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index < 0) {
                index = 0;
            }
            Node node = new Node(val);
            Node pre = head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            node.next = pre.next;
            pre.next = node;
            size++;
        }

        void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            Node pre = head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            pre.next = pre.next.next;
            size--;
        }
    }
}