package cn.nnnu.day0613;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author yanweiyi
 */
public class P0150 {
    public static void main(String[] args) {
        P0150 p0150 = new P0150();
        String[] s1 = {"4","13","5","/","+"};
        String[] s2 = {"2","1","+","3","*"};
        String[] s3 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int i = p0150.evalRPN(s3);
        System.out.println(i);
    }

    public int evalRPN(String[] tokens) {
        List<String> symbols = Arrays.asList("+", "-", "*", "/");
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (symbols.contains(token) && !stack.isEmpty()) {
                Integer i1 = stack.pop();
                Integer i2 = stack.pop();
                stack.add(getInteger(token, i2, i1));
            } else {
                stack.add(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private Integer getInteger(String token, Integer i1, Integer i2) {
        switch (token) {
            case "+":
                return i1 + i2;
            case "-":
                return i1 - i2;
            case "*":
                return i1 * i2;
            case "/":
                return i1 / i2;
        }
        return -1;
    }
}
