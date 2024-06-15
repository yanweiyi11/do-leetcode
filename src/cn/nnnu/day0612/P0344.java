package cn.nnnu.day0612;

import java.util.Arrays;

/**
 * @author yanweiyi
 */
public class P0344 {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        P0344 p0344 = new P0344();
        p0344.reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}
