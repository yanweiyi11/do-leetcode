package cn.nnnu.day0613;

/**
 * @author yanweiyi
 */
public class P0028 {
    public static void main(String[] args) {
        P0028 p0028 = new P0028();
        int i = p0028.strStr("aaa", "aaaa");
        System.out.println(i);
    }

    void getNext(int[] next, String str) {
        int j = 0;
        next[0] = 0;

        for (int i = 1; i < str.length(); i++) {
            while (j > 0 && str.charAt(j) != str.charAt(i)) {
                j = next[j - 1];
            }
            if (str.charAt(j) == str.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
    }

    public int strStr(String haystack, String needle) {
        int j;
        int hLength = haystack.length();
        int nLength = needle.length();
        for (int i = 0; i <= hLength - nLength; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                j = 1;
                while (j < needle.length() && i + j < hLength && haystack.charAt(i + j) == needle.charAt(j)) j++;
                if (j == needle.length()) {
                    return i;
                }
            }
        }
        return -1;
    }
}
