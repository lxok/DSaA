package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/4/26.
 */
public class Solution11 {
    public int NumberOf1(int n) {
        int flag = 1;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & flag) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}
