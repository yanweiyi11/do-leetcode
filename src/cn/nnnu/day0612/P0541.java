package cn.nnnu.day0612;

/**
 * @author yanweiyi
 */
public class P0541 {
    public static void main(String[] args) {
        P0541 p0541 = new P0541();
        String s = p0541.reverseStr("hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl", 39);
        // String s = p0541.reverseStr("abcdefg", 2);
        System.out.println(s);
    }

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i += 2 * k) {
            if (i + k <= chars.length) {
                reverse(i, i + k - 1, chars);
                continue;
            }
            reverse(i, chars.length - 1, chars);
        }
        return new String(chars);
    }

    public String reverseStr2(String s, int k) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int odd = 1;
        int i = -1;
        while (i < length - 1) { // 减去1，因为最后一个索引是length-1
            i += k;
            if (odd % 2 == 0) {
                odd++;
                continue;
            }
            int left = Math.max(i - k + 1, 0); // 确保不会出现负数索引
            int right = Math.min(i, length - 1); // 确保不会越界
            reverse(left, right, chars);
            odd++;
        }
        return new String(chars);
    }

    private static void reverse(int left, int right, char[] chars) {
        while (left < right) {
            char t = chars[left];
            chars[left] = chars[right];
            chars[right] = t;
            left++;
            right--;
        }
    }
}
