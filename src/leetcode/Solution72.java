package leetcode;

/**
 * Created by nick on 2017/1/8.
 */
/**
 * 又是一道动态规划的典型题目，很巧妙很重要。
 * 要考虑清楚删除，插入和替换操作相对应的前量是哪个，这里就是此题的难点。
 * 删除就是md[i][j - 1]，插入是md[i - 1][j], 替换是md[i - 1][j - 1];
 * 一定要考虑清楚当前量和前量在变化后是什么关系，进而理解操作对应的前量。
 */
public class Solution72 {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }
        int m = word1.length();
        int n = word2.length();
        int[][] md = new int[m + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            md[0][i] = i;
        }
        for (int i = 0; i < m + 1; i++) {
            md[i][0] = i;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    md[i][j] = md[i - 1][j - 1];
                } else {
                    md[i][j] = minValue(md[i][j - 1] + 1, md[i - 1][j] + 1, md[i - 1][j - 1] + 1);
                }
            }
        }
        return md[m][n];
    }

    public int minValue(int a, int b, int c) {
        return Math.min(Math.min(a, b),c);
    }
}
