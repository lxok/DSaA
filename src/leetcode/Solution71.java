package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by nick on 2017/1/7.
 */
/**
 * 虽然是Medium,但是这个题不好写，原因在于需要分多步骤。
 * 1.拆分路径
 * 2.用栈去除"."和".."两种符号
 * 3.取出栈中元素，反向循环构成新的path
 */
public class Solution71 {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "";
        }
        char[] arr = path.toCharArray();
        List<String> dirList = new ArrayList<>();
        int start = -1;
        int end = -1;
        boolean ifStart = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '/') {
                ifStart = true;
            } else {
                if (ifStart) {
                    if (start != -1) {
                        dirList.add(path.substring(start, end + 1));
                    }
                    start = i;
                    end = i;
                    ifStart = false;
                } else {
                    end = i;
                }
            }
        }
        if (start != -1) {
            dirList.add(path.substring(start, end + 1));
        }
        String[] dir = new String[dirList.size()];
        dirList.toArray(dir);
        String self = ".";
        String up = "..";
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < dir.length; i++) {
            if (dir[i].equals(self)) {
                continue;
            } else if (dir[i].equals(up)) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(dir[i]);
            }
        }
        String[] resArr = new String[stack.size()];
        int index = 0;
        while (!stack.empty()) {
            resArr[index++] = stack.pop();
        }
        String res = "/";
        for (int j = resArr.length - 1; j >=0; j--) {
            res = res + resArr[j] + "/";
        }
        if (res.length() == 1) {
            return res;
        }
        return res.substring(0, res.length() - 1);
    }

    public static void main(String[] args) {
        Solution71 s = new Solution71();
        System.out.println(s.simplifyPath("/.../"));
    }
}
