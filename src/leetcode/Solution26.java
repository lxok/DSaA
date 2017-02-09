package leetcode;

/**
 * Created by nick on 2016/12/18.
 */
public class Solution26 {
    public static void main(String[] args) {
        Solution26 s = new Solution26();
        int[] arg = {1, 1, 2};
        System.out.println(s.removeDuplicates(arg));
    }

    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
}
