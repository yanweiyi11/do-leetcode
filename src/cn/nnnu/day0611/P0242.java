package cn.nnnu.day0611;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yanweiyi
 */
public class P0242 {
    public static void main(String[] args) {
        P0242 p0242 = new P0242();
        boolean result = p0242.isAnagram("a", "ab");
        System.out.println(result);
    }

    public boolean isAnagram(String s, String t) {
        int[] ints = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            ints[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (ints[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        Map<String, Integer> countMap1 = new HashMap<>();
        for (String str : s.split("")) {
            countMap1.put(str, countMap1.getOrDefault(str, 0) + 1);  // getOrDefault
        }
        Map<String, Integer> countMap2 = new HashMap<>();
        for (String str : t.split("")) {
            countMap2.put(str, countMap2.getOrDefault(str, 0) + 1);
        }
        return countMap1.equals(countMap2);
    }
}
