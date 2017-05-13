package nowcoder.netease_2017_spring;

import java.util.*;

/**
 * Created by nick on 2017/4/15.
 */
public class Solution8 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        Queue<Integer> num = new LinkedList<>();
        Queue<Character> cha = new LinkedList<>();
        cha.offer('+');
        char[] stra = str.toCharArray();
        int startIndex = 0;
        for (int i = 0; i < stra.length; i++) {
            if (stra[i] == '+' || stra[i] == '-' || stra[i] == '*') {
                num.offer(Integer.valueOf(str.substring(startIndex, i)));
                startIndex = i + 1;
                cha.offer(stra[i]);
            }
        }
        num.offer(Integer.valueOf(str.substring(startIndex, str.length())));
        int val = 0;
        while (!cha.isEmpty()) {
            char c = cha.poll();
            int ope = num.poll();
            if (c == '+') {
                val += ope;
            } else if (c == '-') {
                val -= ope;
            } else {
                val *= ope;
            }
        }
        System.out.println(val);
    }
}
