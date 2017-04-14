package nowcoder.netease_2017_spring;

import java.util.Scanner;

/**
 * Created by nick on 2017/4/8.
 */
public class Solution6 {
    public static int res = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] work = new int[n][6];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                work[i][j] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            String str = s.next();
            char[] strArr = str.toCharArray();
            for (int j = 0; j < strArr.length; j++) {
                work[i][Character.getNumericValue(strArr[j])] = 1;
            }
        }
        int[] ass = new int[n];
        for (int i = 0; i < ass.length; i++){
            ass[i] = 0;
        }
        dfs(0, work, ass);
        System.out.println(res);
    }

    public static boolean suc(int[] ass) {
        for (int i = 0; i < ass.length; i++) {
            if (ass[i] == 0) {
                return false;
            }
        }
        return true;
    }

    public static void dfs(int workIndex, int[][] work, int[] ass) {
        System.out.println("work Index:" + workIndex);
        if (workIndex == 5) {
            for (int i = 0; i < work.length; i++) {
                if (work[i][5] == 1) {
                    boolean change = false;
                    if (ass[i] == 0) {
                        change = true;
                    }
                    ass[i] = 1;
                    if (suc(ass)) {
                        res++;
                    }
                    if (change) {
                        ass[i] = 0;
                    }
                }
            }
        } else {
            for (int i = 0; i < work.length; i++) {
                if (work[i][workIndex] == 1) {
                    boolean change = false;
                    if (ass[i] == 0) {
                        change = true;
                    }
                    ass[i] = 1;
                    dfs(workIndex + 1, work, ass);
                    if (change) {
                        ass[i] = 0;
                    }
                }
            }
        }
    }
}
