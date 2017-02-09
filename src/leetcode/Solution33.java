package leetcode;

/**
 * Created by nick on 2016/12/24.
 */
public class Solution33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0 ) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start)/2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[mid] > nums[start]) {
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (target == nums[start]) {
            return start;
        }
        if (target == nums[end]) {
            return end;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution33 s = new Solution33();
        int res = s.search(new int[]{5,1,3}, 5);
        System.out.println(res);
    }
}
