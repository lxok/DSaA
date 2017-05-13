package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/5/7.
 *
 * 好久没有做这么麻烦的题了
 * 麻烦的点在于看不懂题意
 * 这个题感觉用dfs做最好，可遍历所有情况。
 */
public class Solution52 {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        if (str.length == 0 || pattern.length == 0) {
            if (str.length == 0 && pattern.length == 0) {
                return true;
            }
            if (str.length == 0 && pattern.length >= 2 && pattern[1] == '*') {
                return true;
            }
            return false;
        }
        return dfs(str, 0, pattern, 0);
    }

    public boolean dfs(char[] str, int i, char[] pattern, int j) {
        //System.out.println(i + " " + j);
        if (i >= str.length || j >= pattern.length) {
            if (i >= str.length && j >= pattern.length) {
                return true;
            }
            if (i >= str.length && pattern.length - j == 2 && pattern[j + 1] == '*') {
                return true;
            }
            if (i >= str.length && pattern.length - j > 2 && pattern[j + 1] == '*') {
                return dfs(str, i, pattern, j + 2);
            }
            return false;
        }
        boolean res;
        if (pattern[j] == '.' ) {
            if (j + 1 <= pattern.length - 1 && pattern[j + 1] == '*') {
                int index = i;
                char p;
                if (dfs(str, i, pattern, j + 2)) {
                    return true;
                }
                p = str[i];
                while (index < str.length) {
                    res = dfs(str, index + 1, pattern, j + 2);
                    if (res) {
                        return true;
                    }
                    index++;
                }
                return false;
            }
            return dfs(str, i + 1, pattern, j + 1);
        } else if (pattern[j] == '*') {
            return false;
        } else {
            if ( j + 1 <= pattern.length - 1 && pattern[j + 1] == '*') {
                int index = i;
                if (dfs(str, i, pattern, j + 2)) {
                    return true;
                }
                while (str[index] == pattern[j]) {
                    res = dfs(str, index + 1, pattern, j + 2);
                    if (res) {
                        return true;
                    }
                    index++;
                }
                return false;
            } else {
                if (str[i] == pattern[j]) {
                    return dfs(str, i + 1, pattern, j + 1);
                } else {
                    return false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution52 s = new Solution52();
        boolean res = s.match("ab".toCharArray(), ".*".toCharArray());
        System.out.println(res);
    }
}
