package LintCode;

import java.util.ArrayList;

/**
 * Created by nick on 2017/8/12.
 */
public class S5 {
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return -1;
        }
        int len = nums.size();
        int[] dpl = new int[len];
        int[] dpr = new int[len];
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < len - 1; i++) {
            sum += nums.get(i);
            max = Math.max(sum, max);
            dpl[i] = max;
            if (sum < 0) {
                sum = 0;
            }
        }
        max = Integer.MIN_VALUE;
        sum = 0;
        for (int j = len - 1; j > 0; j--) {
            sum += nums.get(j);
            max = Math.max(sum, max);
            dpr[j] = max;
            if (sum < 0) {
                sum = 0;
            }
        }
        max = Integer.MIN_VALUE;
        for (int i = 0; i < len - 1; i++) {
            max = Math.max(max, dpl[i] + dpr[i + 1]);
        }
        return max;
    }

    public static void main(String[] args) {
        S5 s = new S5();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(-1);
        list.add(2);
        list.add(-1);
        list.add(2);
        int res = s.maxTwoSubArrays(list);
        System.out.println(res);
    }
}
