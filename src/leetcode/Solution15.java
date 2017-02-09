package leetcode;

import java.util.*;

/**
 * Created by nick on 2016/11/23.
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        int l;
        int r;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            l = i + 1;
            r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    List<Integer> s = new ArrayList<>();
                    s.add(nums[i]);
                    s.add(nums[l]);
                    s.add(nums[r]);
                    res.add(s);
                    while (l < r && nums[l + 1] == nums[l]) l++;
                    while (l < r && nums[r - 1] == nums[r]) r--;
                    l++;
                    r--;
                } else if (nums[i] + nums[l] + nums[r] < 0) {
                    l++;
                }  else {
                    r--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution15 s = new Solution15();
        List<List<Integer>> l = s.threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6});
        for (int i = 0; i < l.size(); i++) {
            Iterator<Integer> q = l.get(i).iterator();
            while (q.hasNext()) {
                System.out.print(q.next() + " ");
            }
            System.out.println();
        }
    }
}
