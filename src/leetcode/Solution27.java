package leetcode;

/**
 * Created by nick on 2016/12/18.
 */
public class Solution27 {
    public static void main(String[] args) {
        Solution27 s = new Solution27();
        int[] arg = {4, 5};
        System.out.println(s.removeElement(arg, 4));
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while(end > start && nums[end] == val) {
            end--;
        }
        while(start < end) {
            if (nums[start] == val) {
                nums[start] = nums[end];
                nums[end] = val;

                end--;
                while(end > start && nums[end] == val) {
                    end--;
                }
            }
            start++;
        }
        if (start == 0 && nums[0] == val) {
            return 0;
        }
        return end + 1;
    }
}
