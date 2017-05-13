package nowcoder.netease_2017_spring;

import java.util.Scanner;

/**
 * Created by nick on 2017/4/15.
 */
public class Solution9 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        char[][] c = new char[n][n];
        String str;
        for (int i = 0; i < n; i++) {
            str = s.next();
            for (int j = 0; j < n; j++) {
                c[i][j] = str.charAt(j);
            }
        }
        char cur;
        int count;
        int max = 0;
        for (int j = 0; j < n; j++) {
            cur = c[0][j];
            count = 1;
            for (int i = 1; i < n; i++) {
                if (c[i][j] == cur) {
                    count++;
                } else {
                    cur = c[i][j];
                    max = Math.max(count, max);
                    count = 1;
                }
            }
            max = Math.max(count, max);
        }
        System.out.println(max);
    }
}
