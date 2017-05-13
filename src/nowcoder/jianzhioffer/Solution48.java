package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/5/4.
 */
public class Solution48 {
    public int Add(int num1,int num2) {
        if (num2 == 0) {
            return num1;
        }
        return Add(num1 ^ num2, (num1 & num2) << 1);
    }
}
