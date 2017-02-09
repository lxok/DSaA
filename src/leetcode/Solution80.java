package leetcode;

/**
 * Created by nick on 2017/1/10.
 */
public class Solution80 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int writeIndex = 0;
        int readIndex = 0;
        int count;
        while (readIndex < nums.length) {
            int value = nums[readIndex];
            count = 1;
            int i = readIndex;
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                count++;
                i++;
            }
            if (count >= 2) {
                nums[writeIndex++] = value;
                nums[writeIndex++] = value;
            } else {
                nums[writeIndex++] = value;
            }
            readIndex = readIndex + count;
        }
        return writeIndex;
    }
}
