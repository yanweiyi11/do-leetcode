package cn.nnnu.day0613;

/**
 * @author yanweiyi
 */
public class P0459 {
    public static void main(String[] args) {
        P0459 p0459 = new P0459();
        boolean b = p0459.repeatedSubstringPattern("abaababaab");
        System.out.println(b);
    }

    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        char first = s.charAt(0);
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == first) {
                String match = s.substring(0, i);
                int mLength = match.length();
                int j = i;
                while (j + mLength <= s.length() && match.equals(s.substring(j, j + mLength))) {
                    j += mLength;
                }
                if (j == length) {
                    return true;
                }
            }
        }
        return false;
    }
}
