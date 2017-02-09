package leetcode;

/**
 * Created by nick on 2016/12/24.
 *
 * 查左右边界也用2分法即可。
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return new int[]{-1, -1};
        }
        int[] res = new int[]{-1, -1};
        int start = 0;
        int end = nums.length - 1;
        int mid;
        int index = -1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            }
            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (index == -1) {
            if (nums[end] == target) {
                index = end;
            } else if (nums[start] == target) {
                index = start;
            }else {
                return res;
            }
        }
        start = 0;
        end = index;
        while(start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        int low = index;
        if (nums[start] == target) {
            low = start;
        } else if (nums[end] == target) {
            low = end;
        }
        start = index;
        end = nums.length - 1;
        while(start + 1< end) {
            mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        int high = index;
        if (nums[end] == target) {
            high = end;
        } else if (nums[start] == target) {
            high = start;
        }
        res[0] = low;
        res[1] = high;
        return res;
    }

    public static void main(String[] args) {
        Solution34 s = new Solution34();
        int[] res = s.searchRange(new int[]{0,1,2,2,2,3,5,6,7,8,9}, 2);
        System.out.println(res[0] + " " + res[1]);
    }
}
