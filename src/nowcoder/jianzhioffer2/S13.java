package nowcoder.jianzhioffer2;

/**
 * Created by nick on 2017/7/5.
 */
public class S13 {
    public double Power(double base, int exponent) {
        if (exponent < 0) {
            return 1 / dfs(base, -exponent);
        }
        return dfs(base, exponent);
    }

    public double dfs(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double tmp = dfs(base, exponent / 2);
        if (exponent % 2 == 1) {
            return tmp * tmp * base;
        } else {
            return tmp * tmp;
        }
    }
}
