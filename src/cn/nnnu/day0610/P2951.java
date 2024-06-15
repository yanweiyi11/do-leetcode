package cn.nnnu.day0610;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanweiyi
 */
public class P2951 {
    public static void main(String[] args) {
        int[] mountain = {2,4,4};
        System.out.println(findPeaks(mountain));
    }

    public static List<Integer> findPeaks(int[] mountain) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                list.add(i);
                i++;
            }
        }
        return list;
    }
}
