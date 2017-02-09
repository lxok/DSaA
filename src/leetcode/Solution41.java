package leetcode;

/**
 * Created by nick on 2016/12/28.
 */
/**
 * 数组内部交换元素顺序来实现桶排序
 */
public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            while(nums[i] != i + 1) {
                if (nums[i] > nums.length || nums[i] < 1 || nums[nums[i] - 1] == nums[i] ) {
                    break;
                }
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                break;
            }
        }
        return i + 1;
    }
}
