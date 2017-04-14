package nowcoder.netease_2017_spring;

/**
 * Created by nick on 2017/4/6.
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 小易有一个长度为n序列，小易想移除掉里面的重复元素，但是小易想是对于每种元素保留最后出现的那个。
 * 小易遇到了困难,希望你来帮助他。
 */
public class Solution4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = s.nextInt();
        }
        Set<Integer> set = new HashSet<>();
        for (int i = n - 1; i >= 0; i--) {
            if (set.contains(seq[i])) {
                seq[i] = -1;
            } else {
                set.add(seq[i]);
            }
        }
        String res = "";
        for (int i = 0; i < n; i++) {
            if (seq[i] != -1) {
                res = res + seq[i] + " ";
            }
        }
        System.out.println(res);
    }
}
