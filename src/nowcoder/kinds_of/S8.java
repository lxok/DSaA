package nowcoder.kinds_of;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by nick on 2017/8/12.
 */
public class S8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] h = new int[n];
            for (int i = 0; i < n; i++) {
                h[i] = sc.nextInt();
            }
            System.out.println(crazy(h));
        }
    }

    static int crazy(int[] h) {
        int len = h.length;
        if (len == 0 || len == 1) {
            return 0;
        }
        Arrays.sort(h);
        int l = 0;
        int r = len - 1;
        int lval = h[l++];
        int rval = h[r--];
        int res = rval - lval;
        int ll, lr, lres, rl, rr, rres;
        while (l <= r) {
            //System.out.println("res:" + res + ", l:" + l + ", r:" + r);
            ll = Math.abs(h[l] - lval);
            lr = Math.abs(h[l] - rval);
            lres = Math.max(ll, lr);
            rl = Math.abs(h[r] - lval);
            rr = Math.abs(h[r] - rval);
            rres = Math.max(rl, rr);
            if (lres >= rres) {
                if (lres == ll) {
                    res += ll;
                    lval = h[l];
                } else {
                    res += lr;
                    rval = h[l];
                }
                l++;
            } else {
                if (rres == rl) {
                    res += rl;
                    lval = h[r];
                } else {
                    res += rr;
                    rval = h[r];
                }
                r--;
            }
        }
        return res;
    }
}
