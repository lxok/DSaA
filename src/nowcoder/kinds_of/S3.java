package nowcoder.kinds_of;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by nick on 2017/7/12.
 */
public class S3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(match(s));
        }
    }

    public static boolean match(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char v = s.charAt(i);
            if (v == '(' || v == '[' || v == '{') {
                stack.push(v);
            } else if (v == ')' ) {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            } else if (v == ']' ) {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            }else if (v == '}' ) {
                if (stack.isEmpty() || stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
