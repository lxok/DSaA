package leetcode;

/**
 * Created by nick on 2017/1/9.
 */
/**
 * 最简单的二分法！注意这是基本功，一定要熟练，熟练，再熟练！
 */
public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int min = matrix[0][0];
        int max = matrix[m - 1][n - 1];
        if (target < min || target > max) {
            return false;
        }
        int row = -1;
        int low = 0;
        int high = matrix.length - 1;
        int medium;
        if (matrix[high][0] == target || matrix[low][0] == target) {
            return true;
        }
        if (target > matrix[high][0]) {
            row = high;
        }
        while (row == -1 && high - low > 1) {
            if (matrix[high][0] == target || matrix[low][0] == target) {
                return true;
            }
            medium = (high + low) / 2;
            if (matrix[medium][0] == target) {
                return true;
            }
            if (matrix[medium][0] > target) {
                high = medium;
            } else {
                low = medium;
            }
        }
        if (row == -1) {
            row = low;
        }
        low = 0;
        high = n - 1;
        if (matrix[row][low] == target || matrix[row][high] == target) {
            return true;
        }
        while (high - low > 1) {
            if (matrix[row][low] == target || matrix[row][high] == target) {
                return true;
            }
            medium = (high + low) / 2;
            if (matrix[row][medium] == target) {
                return true;
            }
            if (matrix[row][medium] > target) {
                high = medium;
            } else {
                low = medium;
            }
        }
        return false;
    }
}
