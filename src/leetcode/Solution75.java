package leetcode;

/**
 * Created by nick on 2017/1/9.
 */
/**
 * 桶排序，很典型!
 */
public class Solution75 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int[] record = new int[3];
        for (int i = 0; i < nums.length; i++) {
            record[nums[i]]++;
        }
        int index = 0;
        for (int i = 0; i < record.length; i++) {
            while (record[i] > 0) {
                nums[index++] = i;
                record[i]--;
            }
        }
    }
}
