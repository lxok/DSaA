package nowcoder.jianzhioffer;

import java.util.Arrays;

/**
 * Created by nick on 2017/5/4.
 */
public class Solution45 {
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        Arrays.sort(numbers);
        int sum = 0;
        int zero = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0) {
                zero++;
            } else {
                if (numbers[i] == numbers[i + 1]) {
                    return false;
                }
                sum += numbers[i + 1] - numbers[i] - 1;
            }
        }
        if (sum == zero || sum == 0) {
            return true;
        }
        return false;
    }
}
