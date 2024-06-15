package cn.nnnu.day0610;

import java.util.Arrays;

/**
 * @author yanweiyi
 */
public class P0059 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }

    public static int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int startX = 0, startY = 0;
        int offset = 1;
        int count = 1;
        int i;
        int j;
        for (int q = 0; q < n / 2; q++) {
            for (j = startY; j < n - offset; j++) {
                nums[startX][j] = count++;
            }
            for (i = startX; i < n - offset; i++) {
                nums[i][j] = count++;
            }
            for (; j > startY; j--) {
                nums[i][j] = count++;
            }
            for (; i > startX; i--) {
                nums[i][j] = count++;
            }
            startX++;
            startY++;
            offset++;
        }
        if (n % 2 == 1) {
            nums[startX][startY] = count;
        }
        return nums;
    }
}
