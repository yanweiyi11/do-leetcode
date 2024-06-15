package cn.nnnu.day0613;

import java.util.Stack;

/**
 * @author yanweiyi
 */
public class P0232 {
    public static void main(String[] args) {

    }

    class MyQueue {

        private Stack<Integer> stackIn;
        private Stack<Integer> stackOut;

        public MyQueue() {
            stackIn = new Stack<>();
            stackOut = new Stack<>();
        }

        public void push(int x) {
            stackIn.push(x);
        }

        public int pop() {
            fill();
            return stackOut.pop();
        }

        public int peek() {
            fill();
            return stackOut.peek();
        }

        public boolean empty() {
            fill();
            return stackOut.isEmpty();
        }

        private void fill() {
            if (stackOut.isEmpty()) {
                while (!stackIn.isEmpty()) {
                    stackOut.push(stackIn.pop());
                }
            }
        }
    }
}
