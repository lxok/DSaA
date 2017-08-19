package nowcoder.mianshijindian;

/**
 * Created by nick on 2017/6/25.
 */
public class Exchange {
    public int[] exchangeAB(int[] AB) {
        AB[0] += AB[1];
        AB[1] = AB[0] - AB[1];
        AB[0] -= AB[1];
        return AB;
    }
}
