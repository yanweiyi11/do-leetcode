package cn.nnnu.day0610;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanweiyi
 */
public class P0118 {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        generate(1, numRows, res);
        return res;
    }

    public static void generate(int numberOfLayers, int numRows, List<List<Integer>> res) {
        if (numberOfLayers > numRows) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numberOfLayers; i++) {
            if (i == 0 || i == numberOfLayers - 1) {
                list.add(1);
            } else {
                List<Integer> previousLayer = res.get(numberOfLayers - 2);
                Integer left = previousLayer.get(i - 1);
                Integer right = previousLayer.get(i);
                list.add(left + right);
            }
        }
        res.add(list);
        generate(numberOfLayers + 1, numRows, res);
    }
}
