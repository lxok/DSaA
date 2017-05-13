package nowcoder.netease_2017_spring;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by nick on 2017/4/15.
 */
public class Solution10 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(s.next());
        }
        int goal = 0;
        String str;
        for (int i = 0; i < m; i++) {
            str = s.next();
            if (set.contains(str)) {
                goal += str.length() * str.length();
            }
        }
        System.out.println(goal);
    }
}
