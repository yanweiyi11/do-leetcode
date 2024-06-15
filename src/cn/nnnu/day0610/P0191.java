package cn.nnnu.day0610;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yanweiyi
 */
public class P0191 {
    public static void main(String[] args) {
        System.out.println(hammingWeightV1(2147483645));
        System.out.println(hammingWeightV2(2147483645));
    }

    public static int hammingWeightV1(int n) {
        String binaryString = Integer.toBinaryString(n);
        List<String> strList = Arrays.asList(binaryString.split(""));
        List<Integer> integerList = strList.stream()
                .map(Integer::valueOf)
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
        return integerList.lastIndexOf(1) + 1;
    }

    public static int hammingWeightV2(int n) {
        return Integer.bitCount(n);
    }
}
