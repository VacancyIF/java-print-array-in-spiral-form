package com.bytelegend;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Challenge {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        spiralOrder(
                                new int[][] {
                                    {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}
                                })));
    }

    /**
     * `spiralOrder(int[][] matrix)` print the matrix in spiral order.
     *
     * <p>For example, given the following matrix:
     *
     * <p>``` 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 ```
     *
     * <p>Return `[1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10]`.
     */
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[]{};
        }

        int[] ans = new int[matrix.length * matrix[0].length];
        int c = 0;
        int m = matrix.length, n = matrix[0].length;
        boolean[][] seen = new boolean[m][n];
        int[] dr = { 0, 1, 0, -1 };
        int[] dc = { 1, 0, -1, 0 };
        int x = 0, y = 0, di = 0;
  
        // Iterate from 0 to R * C - 1
        for (int i = 0; i < m * n; i++) {
            ans[c++] = matrix[x][y];
            seen[x][y] = true;
            int cr = x + dr[di];
            int cc = y + dc[di];
  
            if (0 <= cr && cr < m && 0 <= cc && cc < n && !seen[cr][cc]) {
                x = cr;
                y = cc;
            } else {
                di = (di + 1) % 4;
                x += dr[di];
                y += dc[di];
            }
        }
        return ans;
    }
}
