package nowcoder.mianshijindian;

/**
 * Created by nick on 2017/6/25.
 */
public class Max {
    public int getMax(int a, int b) {
        b = a - b;
        a -= b &(b >> 31);
        return a;
    }
}
