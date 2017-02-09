package leetcode;

/**
 * Created by nick on 2016/12/20.
 */
/**
 * 算法的关键是找到从低位到高位第一个可以替换的数。
 * 然后再找到第二个。
 * 最终将第一个以后的数全部调转，从由大致小变成由小致大。
 */
public class Solution31 {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int first = -1;
        int second = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                first = i - 1;
                break;
            }
        }
        if (first == -1) {
            reverse(nums, 0);
            return;
        }
        if (first == nums.length - 1) {
            second = nums.length - 2;
            int tmp = nums[first];
            nums[first] = nums[second];
            nums[second] = tmp;
        }

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[first]) {
                second = i;
                break;
            }
        }

        int tmp = nums[first];
        nums[first] = nums[second];
        nums[second] = tmp;

        reverse(nums, first + 1);
    }

    public void reverse(int[] nums, int start) {
        int l = start;
        int r = nums.length - 1;
        int tmp;
        while (l < r) {
            tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }

}
