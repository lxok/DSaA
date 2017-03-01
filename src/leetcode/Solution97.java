package leetcode;

/**
 * Created by nick on 2017/2/28.
 */
/**
 * 这种字符串动态规划的题还不是很熟练，一下想不到解法。
 * 其实仔细想一下，这样的题目如果能想到对s3分步骤做的话,应该是可以想到dp的。
 * 这道题有两种方法，其实思路是一致的。
 * 一是用迭代，即用树分叉的方式一步一步向后推。
 * 二是用动规，判定条件和一相同。
 * 所以以后这种字符串的题目一定要想到分步骤做！！~
 */
public class Solution97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        if (l1 + l2 != l3) {
            return false;
        }
        boolean[][] record = new boolean[l1 + 1][l2 + 1];
        record[0][0] = true;
        if (l2 >= 1) {
            for (int i = 1; i <= l2; i++) {
                record[0][i] = record[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
            }
        }
        if (l1 >= 1) {
            for (int i = 1; i <= l1; i++) {
                record[i][0] = record[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
            }
        }
        if (l1 >= 1 && l2 >= 1) {
            for (int i = 1; i <= l1; i++) {
                for (int j = 1; j <= l2; j++) {
                    char c = s3.charAt(i + j - 1);
                    record[i][j] = (record[i - 1][j] && s1.charAt(i - 1) == c) || (record[i][j - 1] && s2.charAt(j - 1) == c);
                }
            }
        }
        return record[l1][l2];
    }
}
