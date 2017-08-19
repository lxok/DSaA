package nowcoder.kinds_of;

import java.util.Scanner;

/**
 * Created by nick on 2017/8/12.
 */
public class S6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            System.out.println(genB(a));
        }
    }

    static String genB(int[] a) {
        int len = a.length;
        if (len == 0) {
            return "";
        }
        boolean even = len % 2 == 0;
        int index = len - 1;
        StringBuffer sb = new StringBuffer();
        while (index >= 0) {
            sb.append(a[index]);
            sb.append(" ");
            index -= 2;
        }
        if (even) {
            index = 0;
        } else {
            index = 1;
        }
        while (index <= len - 1) {
            sb.append(a[index]);
            sb.append(" ");
            index += 2;
        }
        String s = sb.toString();
        return s.substring(0, s.length() - 1);
    }
}
