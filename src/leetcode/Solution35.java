package leetcode;

/**
 * Created by nick on 2016/12/24.
 */
public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (target <= nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target < nums[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return start + 1;
    }
}
