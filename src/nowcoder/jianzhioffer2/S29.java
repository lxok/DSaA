package nowcoder.jianzhioffer2;

/**
 * Created by nick on 2017/7/9.
 */
public class S29 {
    public int GetUglyNumber_Solution(int index) {
        if (index < 1) {
            return 0;
        }
        if (index == 1) {
            return 1;
        }
        int[] res = new int[index];
        res[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        int m2, m3, m5;
        for (int i = 1; i < index; i++) {
            m2 = res[i2] * 2;
            m3 = res[i3] * 3;
            m5 = res[i5] * 5;
            res[i] = min(m2, m3, m5);
            if (m2 == res[i]) {
                i2++;
            }
            if (m3 == res[i]) {
                i3++;
            }
            if (m5 == res[i]) {
                i5++;
            }
        }
        return res[index - 1];
    }

    public int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
