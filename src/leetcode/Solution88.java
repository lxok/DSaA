package leetcode;

/**
 * Created by acer on 2017/1/25.
 */
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0 && n == 0) {
            return;
        }
        int[] nums11 = new int[m];
        for (int i = 0; i < m; i++) {
            nums11[i] = nums1[i];
        }
        int i = 0;
        int j = 0;
        int k = 0;
        while (i <= m - 1 && j <= n - 1) {
            if (nums11[i] <= nums2[j]) {
                nums1[k++] = nums11[i++];
            } else {
                nums1[k++] = nums2[j++];
            }
        }
        if (i > m - 1) {
            for (; k < m + n; k++) {
                nums1[k] = nums2[j++];
            }
        } else {
            for (; k < m + n; k++) {
                nums1[k] = nums11[i++];
            }
        }
    }

    public static void main(String[] args) {
        Solution88 s = new Solution88();
        s.merge(new int[]{0}, 0, new int[]{1}, 1);
    }
}
