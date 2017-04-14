package nowcoder.netease_2017_spring;

import java.util.Scanner;

/**
 * Created by nick on 2017/4/8.
 *
 * 44
 37
 65
 68
 36
 */
public class Solution5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        for (int i = 0; i < k; i++) {
            int tmp = a[0];
            for (int j = 0; j < n; j++) {
                if (j == n - 1) {
                    a[j] += tmp;
                } else {
                    a[j] += a[j + 1];
                }
                if (a[j] >= 100) {
                    a[j] %= 100;
                }
            }
        }
        String res = "";
        for (int i = 0; i < n; i++) {
            res += a[i] + " ";
        }
        System.out.println(res.trim());
    }
}
