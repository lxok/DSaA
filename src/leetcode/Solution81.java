package leetcode;

/**
 * Created by nick on 2017/1/10.
 */
/**
 * 这道题相比于rotated array,数组中多了重复项。
 * 这样造成的问题是当nums[medium]==nums[start]时，你无法选择用哪种方式
 * 进行判断
 *
 * 这样的情况下，简单的一步做法是将start++；再进行下一次循环。
 * 这样的结果是最坏复杂度从O(logn)增加到了O(n).
 *
 */
public class Solution81 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        if (nums[start] == target) {
            return true;
        }
        if (nums[end] == target) {
            return true;
        }
        int medium;
        while (end - start > 1) {
            medium = (start + end) / 2;
            if (nums[medium] == target) {
                return true;
            }
            if (nums[medium] > nums[start]) {
                if (target > nums[start] && target < nums[medium]) {
                    end = medium;
                } else {
                    start = medium;
                }
            } else if (nums[medium] < nums[start]) {
                if (target < nums[end] && target > nums[medium]) {
                    start = medium;
                } else {
                    end = medium;
                }
            } else {
                start++;
                if (nums[start] == target) {
                    return true;
                }
            }
        }
        if (nums[start] == target) {
            return true;
        }
        if (nums[end] == target) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution81 s = new Solution81();
        boolean res = s.search(new int[]{1,3,1,1,1}, 3);
        System.out.println(res);
    }
}
