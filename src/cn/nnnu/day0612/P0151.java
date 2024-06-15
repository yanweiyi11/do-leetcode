package cn.nnnu.day0612;

import java.util.StringJoiner;

/**
 * @author yanweiyi
 */
public class P0151 {
    public static void main(String[] args) {
        P0151 p0151 = new P0151();
        String s = p0151.reverseWords("the sky is blue");
        System.out.println(s);
    }

    public String reverseWords(String s) {
        // 1. 去除首尾以及中间多余空格
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        // 2. 反转整个字符串
        int left = 0;
        int right = sb.length() - 1;
        reverse(left, right, sb);
        // 3. 反转各个单词
        int fast = 1;
        int slow = 0;
        while (slow < sb.length()) {
            while (fast < sb.length() && sb.charAt(fast) != ' ') fast++;
            reverse(slow, fast - 1, sb);
            slow = fast + 1;
            fast = slow + 1;
        }
        return sb.toString();
    }

    private static void reverse(int left, int right, StringBuilder sb) {
        while (left < right) {
            char l = sb.charAt(left);
            char r = sb.charAt(right);
            sb.setCharAt(left, r);
            sb.setCharAt(right, l);
            left++;
            right--;
        }
    }

    public String reverseWords2(String s) {
        String[] chars = s.split(" ");
        StringJoiner sj = new StringJoiner(" ");
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i].isEmpty()) continue;
            sj.add(chars[i]);
        }
        return sj.toString();
    }
}
