package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/4/26.
 */
public class Solution12 {

    public double Power(double base, int exponent) {
        int flag = (exponent >= 0) ? 0 : 1;
        double res = dfs(base, exponent >= 0 ? exponent : -exponent);
        if (flag == 0) {
            return res;
        }
        return 1.0 / res;
    }

    public double dfs(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double res = Power(base, exponent / 2);
        if (exponent % 2 == 0) {
            return res * res;
        } else {
            return res * res * base;
        }
    }
}
