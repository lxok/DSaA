package nowcoder.netease_2017_spring;

/**
 * Created by nick on 2017/4/6.
 */

import java.util.Scanner;

/**
 * 赶去公司
 终于到周末啦！小易走在市区的街道上准备找朋友聚会，突然服务器发来警报,小易需要立即回公司修复这个紧急bug。
 假设市区是一个无限大的区域，每条街道假设坐标是(X，Y)，小易当前在(0，0)街道，办公室在(gx,gy)街道上。
 小易周围有多个出租车打车点，小易赶去办公室有两种选择，一种就是走路去公司，另外一种就是走到一个出租车打车点，
 然后从打车点的位置坐出租车去公司。每次移动到相邻的街道(横向或者纵向)走路将会花费walkTime时间，打车将花费taxiTime时间。
 小易需要尽快赶到公司去，现在小易想知道他最快需要花费多少时间去公司。

 complete
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] co = new int[n][2];
        for (int i = 0; i < n; i++) {
            co[i][0] = s.nextInt();
        }
        for (int i = 0; i < n; i++) {
            co[i][1] = s.nextInt();
        }
        int h = s.nextInt();
        int v = s.nextInt();
        int wt = s.nextInt();
        int tt = s.nextInt();
        int min = (((h >= 0) ? h - 0: 0 - h )+
                ((v >= 0) ? v - 0: 0 - v)) * wt;
        for (int i = 0; i < n; i++) {
            int tmp = (((co[i][0] >= 0) ? co[i][0] - 0: 0 - co[i][0]) +
                    ((co[i][1] >= 0) ? co[i][1] - 0: 0 - co[i][1])) * wt;
            tmp += (((co[i][0] >= h) ? co[i][0] - h: h - co[i][0]) +
                    ((co[i][1] >= v) ? co[i][1] - v: v - co[i][1])) * tt;
            min = Math.min(min, tmp);
        }
        System.out.println(min);
    }
}
