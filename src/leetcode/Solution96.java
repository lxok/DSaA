package leetcode;

/**
 * Created by nick on 2017/2/28.
 */
/**
 * 用与题95完全相同的方法（分治）完成，超时。
 * 用动规可以做，因为有重复，两种方式划分和计算的思路基本是一样的。
 *
 */
public class Solution96 {
    public int numTrees(int n) {
        if ( n < 1) {
            return 0;
        }
        int[][] record = new int[n + 1][n + 1];
        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                if (i == j) {
                    record[i][j] = 1;
                    continue;
                }
                int res = 0;
                for (int k = i; k <= j; k++) {
                    if (k == i) {
                        res += record[i + 1][j];
                    } else if (k == j) {
                        res += record[i][j - 1];
                    } else {
                        res += record[i][k - 1] * record[k + 1][j];
                    }
                }
                record[i][j] = res;
            }
        }
        return record[1][n];
    }
}
