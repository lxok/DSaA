package nowcoder.netease_2017_spring;

/**
 * Created by nick on 2017/4/6.
 */

import java.util.Scanner;

/**
 *[编程题] 双核处理
 一种双核CPU的两个核能够同时的处理任务，现在有n个已知数据量的任务需要交给CPU处理，
 假设已知CPU的每个核1秒可以处理1kb，每个核同时只能处理一项任务。n个任务可以按照任意顺序放入CPU进行处理，
 现在需要设计一个方案让CPU处理完这批任务所需的时间最少，求这个最小的时间。

 多机调度问题

 双机调度问题，01背包问题
 */

public class Solution1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        int[] length = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            length[i] = s.nextInt() / 1024;
            sum += length[i];
        }
        int half = sum / 2;
        int[] dp = new int[half + 1];
        for (int i = 0; i < n; i++) {
            for (int j = half; j >= length[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - length[i]] + length[i]);
            }
        }
        System.out.println((sum - dp[half]) * 1024);
    }
}
