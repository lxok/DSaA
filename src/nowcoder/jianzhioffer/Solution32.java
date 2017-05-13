package nowcoder.jianzhioffer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by nick on 2017/5/1.
 */
public class Solution32 {
    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        Integer[] nums = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = numbers[i];
        }
        Arrays.sort(nums, new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                String s1 = a + "" + b;
                String s2 = b + "" + a;
                return s1.compareTo(s2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append((int)nums[i]);
        }
        return sb.toString();
    }
}
