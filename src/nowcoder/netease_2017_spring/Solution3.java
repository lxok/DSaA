package nowcoder.netease_2017_spring;

import java.util.Scanner;

/**
 * Created by nick on 2017/4/6.
 */
/**
 * 在幼儿园有n个小朋友排列为一个队伍，从左到右一个挨着一个编号为(0~n-1)。
 * 其中有一些是男生，有一些是女生，男生用'B'表示，女生用'G'表示。
 * 小朋友们都很顽皮，当一个男生挨着的是女生的时候就会发生矛盾。
 * 作为幼儿园的老师，你需要让男生挨着女生或者女生挨着男生的情况最少。
 * 你只能在原队形上进行调整，每次调整只能让相邻的两个小朋友交换位置，现在需要尽快完成队伍调整,
 * 你需要计算出最少需要调整多少次可以让上述情况最少。例如：GGBBG -> GGBGB -> GGGBB
 * 这样就使之前的两处男女相邻变为一处相邻，需要调整队形2次
 */

public class Solution3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String que = s.nextLine();
        char[] c = que.toCharArray();
        int left = 0;
        int index = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'B') {
                left += i - index;
                index++;
            }
        }
        int right = 0;
        index = c.length - 1;
        for (int i = c.length - 1; i >=0; i--) {
            if (c[i] == 'B') {
                right += index - i;
                index--;
            }
        }
        int res = Math.min(left, right);
        System.out.println(res);
    }
}
