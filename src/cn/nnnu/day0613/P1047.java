package cn.nnnu.day0613;

import java.util.Stack;

/**
 * @author yanweiyi
 */
public class P1047 {
    public static void main(String[] args) {
        P1047 p1047 = new P1047();
        String s = p1047.removeDuplicates("abbaca");
        System.out.println(s);
    }

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.add(c);
            } else {
                Character peek = stack.peek();
                if (c == peek) {
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
