package nowcoder.kinds_of;

import java.util.Scanner;

/**
 * Created by nick on 2017/7/12.
 */
public class S1 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        if (p.length() == 0) {
            if (s.length() == 0) {
                return true;
            }
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] =  true;
                }
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
                //System.out.println(i + ", " + j + ": " + dp[i][j]);
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S1 s1 = new S1();
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String p = sc.nextLine();
            System.out.println(s1.isMatch(s, p));
        }
    }
}
