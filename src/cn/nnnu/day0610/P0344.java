package cn.nnnu.day0610;

import java.util.Arrays;

/**
 * @author yanweiyi
 */
public class P0344 {
    public static void main(String[] args) {
        char[] s = {'h', 'a', 'n', 'n', 'a', 'H'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public static void reverseString(char[] s) {
        int right = s.length - 1;

        for (int left = 0; left < right; left++) {
            if (s[left] == s[right]) {
                right--;
                continue;
            }
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            right--;
        }
    }
}
