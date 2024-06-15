package cn.nnnu.day0613;

import java.util.Stack;

/**
 * @author yanweiyi
 */
public class P0020 {
    public static void main(String[] args) {
        String s1 = "()";
        System.out.println(isValid(s1));
    }

    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                char value = stack.peek();
                int contrast = s.charAt(i) - value;
                if (contrast > 0 && contrast < 3) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        return stack.isEmpty();
    }
}
