package nowcoder.jd_2016_spring;

import java.util.Scanner;

/**
 * Created by nick on 2017/4/10.
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[][] t = new char[3][3];
        while (s.hasNext()) {
            for (int i = 0; i < 3; i++) {
                String str = s.nextLine();
                char[] stra = str.toCharArray();
                for (int j = 0; j < 3; j++) {
                    t[i][j] = stra[j];
                }
            }
            int xcount = 0;
            int ocount = 0;
            boolean complete = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (t[i][j] == 'X') {
                        xcount++;
                    } else if (t[i][j] == '0') {
                        ocount++;
                    } else {
                        complete = false;
                    }
                }
            }
            if (xcount - ocount != 1 && xcount != ocount) {
                System.out.println("x");
                continue;
            }
            int win1 = 0;
            int win2 = 0;
            for (int i = 0; i < 3; i++) {
                if (t[i][0] == 'X' && t[i][1] == 'X' && t[i][2] == 'X') {
                    win1++;
                } else if (t[i][0] == '0' && t[i][1] == '0' && t[i][2] == '0') {
                    win2++;
                }
            }
            for (int i = 0; i < 3; i++) {
                if (t[0][i] == 'X' && t[1][i] == 'X' && t[2][i] == 'X') {
                    win1++;
                } else if (t[0][i] == '0' && t[1][i] == '0' && t[2][i] == '0') {
                    win2++;
                }
            }
            if (t[0][0] == 'X' && t[1][1] == 'X' && t[2][2] == 'X') {
                win1++;
            } else if (t[0][0] == '0' && t[1][1] == '0' && t[2][2] == '0') {
                win2++;
            }
            if (t[0][2] == 'X' && t[1][1] == 'X' && t[2][0] == 'X') {
                win1++;
            } else if (t[0][2] == '0' && t[1][1] == '0' && t[2][0] == '0') {
                win2++;
            }
            if (win1 >= 2 || win2 >= 2) {
                System.out.println("x");
                continue;
            }
            if (win1 == 1 && win2 == 1) {
                System.out.println("x");
                continue;
            }
            if (win1 == 1) {
                if (xcount > ocount) {
                    System.out.println("1 won");
                } else {
                    System.out.println("x");
                }
                continue;
            }
            if (win2 == 1) {
                if (xcount == ocount) {
                    System.out.println("2 won");
                } else {
                    System.out.println("x");
                }
                continue;
            }
            if (complete) {
                System.out.println("draw");
                continue;
            }
            if (xcount <= ocount) {
                System.out.println("1");
            } else {
                System.out.println("2");
            }
        }
    }
}
