package leetcode;

import java.util.Set;

/**
 * Created by nick on 2017/1/4.
 */
public class Solution60 {
    public String getPermutation(int n, int k) {
        if (n == 0) {
            return "";
        }
        if (k <= 0) {
            return "";
        }
        int size = 1;
        for (int i = 1; i <= n; i++) {
            size *= i;
        }
        if (size < k) {
            return "";
        }
        int remain = size;
        String res = "";
        int levelSize;
        int num;
        int[] used = new int[n];
        for (int i = 0; i < n; i++) {
            used[i] = i + 1;
        }
        while (n > 0) {
            levelSize = remain / n;
            if (k % levelSize == 0) {
                num = k / levelSize;
            } else {
                num = k / levelSize + 1;
            }
            int count = 0;
            int i;
            for (i = 0; i < used.length; i++) {
                if (used[i] == -1) {
                    continue;
                }
                count++;
                if (count == num) {
                    break;
                }
            }
            res += used[i];
            used[i] = -1;
            k -= (num - 1) * levelSize;
            remain = levelSize;
            n--;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution60 s = new Solution60();
        System.out.println(s.getPermutation(3, 3));
    }
}
