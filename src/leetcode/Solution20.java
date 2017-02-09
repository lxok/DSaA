package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nick on 2016/12/11.
 */
public class Solution20 {
    public boolean isValid(String s) {
        MyStack stack = new MyStack();
        char[] ca = s.toCharArray();
        for (int i = 0; i < ca.length; i++) {
            switch (ca[i]) {
                case '(':
                    stack.put(ca[i]);
                    break;
                case '{':
                    stack.put(ca[i]);
                    break;
                case '[':
                    stack.put(ca[i]);
                    break;
                case ')':
                    if (stack.size() > 0) {
                        char r = stack.get();
                        if (r == '(') {
                            break;
                        } else {
                           return false;
                        }
                    } else {
                        return false;
                    }
                case '}':
                    if (stack.size() > 0) {
                        char r = stack.get();
                        if (r == '{') {
                            break;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                case ']':
                    if (stack.size() > 0) {
                        char r = stack.get();
                        if (r == '[') {
                            break;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
            }
        }
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }
}

class MyStack {
    int size;
    List l;
    int top;

    public MyStack() {
        size = 0;
        l = new ArrayList<>();
        top = -1;
    }

    public void put(char s) {
        top++;
        l.add(top, s);
        size++;
    }

    public char get() {
        char res =  (char)l.get(top);
        l.remove(top);
        size--;
        top--;
        return res;
    }

    public int size() {
        return size;
    }
}