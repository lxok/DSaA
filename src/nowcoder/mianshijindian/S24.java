package nowcoder.mianshijindian;

/**
 * Created by nick on 2017/6/15.
 */
public class S24 {
    public int getLCA(int a, int b) {
        int i = a;
        int j = b;
        while (i != 1 && j != 1) {
            if (i == j) {
                return i;
            } else if (i < j) {
                j /= 2;
            } else {
                i /= 2;
            }
        }
        return 1;
    }
}
