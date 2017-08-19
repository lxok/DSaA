package LintCode;

/**
 * Created by nick on 2017/7/19.
 */
public class S2 {
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        if (k <= 0 || k > nums.length) {
            return -1;
        }
        dfs(k, nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    public void dfs(int k, int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        if (r - l == 1) {
            if (nums[l] > nums[r]) {
                swap(nums, l, r);
            }
            return;
        }
        findMid(nums, l, r);
        int i = l;
        int j = r - 1;
        while (i < j) {
            int val = nums[r - 1];
            while (nums[i] < val) {
                i++;
            }
            while (nums[j] >= val && j >= 0) {
                j--;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, r - 1, i);
        int seq = r - i + 1;
        if (seq < k) {
            dfs(k - seq, nums, l, i - 1);
            return;
        } else if (seq == k) {
            return;
        } else {
            dfs(k, nums, i + 1, r);
        }
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    void findMid(int[] nums, int l, int r) {
        int mid = (l + r) / 2;
        if (nums[l] > nums[mid]) {
            swap(nums, l, mid);
        }
        if (nums[l] > nums[r]) {
            swap(nums, l, r);
        }
        if (nums[mid] > nums[r]) {
            swap(nums, mid, r);
        }
    }

}
