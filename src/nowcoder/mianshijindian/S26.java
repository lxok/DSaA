package nowcoder.mianshijindian;

/**
 * Created by nick on 2017/6/15.
 */
public class S26 {
    public int binInsert(int n, int m, int j, int i) {
        return n + m * (int)Math.pow(2, j);
    }
}
