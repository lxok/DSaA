package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by nick on 2016/12/11.
 */
public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        int mtar;
        int left;
        int right;
        int mres;
        for (int first = 0; first <= nums.length - 4; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second <= nums.length - 3; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                mtar = target - nums[first] - nums[second];
                left = second + 1;
                right = nums.length - 1;
                while (left < right) {
                    mres = nums[left] + nums[right];
                    if (mres < mtar) {
                        left++;
                    } else if (mres > mtar) {
                        right--;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                        while (left < right && nums[left + 1] == nums[left]) {
                            left++;
                        }
                        while (left < right && nums[right - 1] == nums[right]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] i = {0, 0, 0, 0};
        int n = 0;
        Solution18 s = new Solution18();
        s.fourSum(i,n);
    }
}
