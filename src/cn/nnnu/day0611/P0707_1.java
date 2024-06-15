package cn.nnnu.day0611;

/**
 * @author yanweiyi
 */
public class P0707_1 {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
        myLinkedList.get(1);              // 返回 2
        myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
        myLinkedList.get(1);              // 返回 3
    }

    static class MyLinkedList {

        private int val;

        private MyLinkedList next;

        private int size;

        public MyLinkedList() {
            this.val = 0;
            this.next = null;
            this.size = 0;
        }

        public MyLinkedList(int val) {
            this.val = val;
        }

        public MyLinkedList(int val, MyLinkedList next) {
            this.val = val;
            this.next = next;
        }

        public int get(int index) {
            if (index >= size) {
                return -1;
            }
            return get(this, 0, index);
        }

        public int get(MyLinkedList cur, int curIndex, int index) {
            if (curIndex > index) {
                return -1;
            }
            if (curIndex == index) {
                return cur.val;
            }
            return get(cur.next, curIndex + 1, index);
        }

        public void addAtHead(int val) {
            this.next = new MyLinkedList(this.val, this.next);
            this.val = val;
            size++;
        }

        public void addAtTail(int val) {
            addAtTail(this, val);
        }

        public void addAtTail(MyLinkedList cur, int val) {
            if (cur.next == null) {
                cur.next = new MyLinkedList(val, null);
                size++;
            } else {
                addAtTail(cur.next, val);
            }
        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index == 0) {
                addAtHead(val);
                return;
            }
            if (index == size) {
                addAtTail(val);
                return;
            }
            int i = 0;
            MyLinkedList pre = this;
            for (int j = 0; j < index - 1; j++) {
                pre = pre.next;
            }
            pre.next = new MyLinkedList(val, pre.next);
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index >= size) {
                return;
            }
            MyLinkedList dummyHead = new MyLinkedList(-1, this);
            deleteAtIndex(dummyHead, dummyHead.next, 1, index);
        }

        public void deleteAtIndex(MyLinkedList pre, MyLinkedList cur, int curIndex, int index) {
            if (curIndex > index) {
                return;
            }
            if (pre == null || cur == null) {
                return;
            }
            if (curIndex == index) {
                pre.next = cur.next;
                size--;
                return;
            }
            deleteAtIndex(cur, cur.next, curIndex + 1, index);
        }
    }
}
