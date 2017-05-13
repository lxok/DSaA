package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/5/10.
 */
public class Solution65 {
    int row;
    int col;
    boolean[] flag;
    char[] tar;
    char[] src;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length == 0 || str == null || str.length == 0 || str.length > matrix.length) {
            return false;
        }
        row = rows;
        col = cols;
        tar = str;
        src = matrix;
        flag = new boolean[matrix.length];
        for(int i = 0; i < flag.length; i++) {
            flag[i] = false;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == str[0]) {
                if (str.length == 1) {
                    return true;
                }
                flag[i] = true;
                boolean res = dfs(i,1);
                if (res) {
                    return true;
                }
                flag[i] = false;
            }
        }
        return false;
    }

    public boolean dfs(int loc, int index) {
        if (loc - col >= 0 && !flag[loc - col] && src[loc - col] == tar[index]) {
            if (index == tar.length - 1) {
                return true;
            }
            flag[loc - col] = true;
            boolean res = dfs(loc - col, index + 1);
            if (res) {
                return true;
            }
            flag[loc - col] = false;
        }
        if (loc + col <= src.length - 1 && !flag[loc + col] && src[loc + col] == tar[index]) {
            if (index == tar.length - 1) {
                return true;
            }
            flag[loc + col] = true;
            boolean res = dfs(loc + col, index + 1);
            if (res) {
                return true;
            }
            flag[loc + col] = false;
        }
        if (loc - 1 >= 0 && ((loc - 1) / col == loc / col)  && !flag[loc - 1] && src[loc - 1] == tar[index]) {
            if (index == tar.length - 1) {
                return true;
            }
            flag[loc - 1] = true;
            boolean res = dfs(loc - 1, index + 1);
            if (res) {
                return true;
            }
            flag[loc - 1] = false;
        }
        if (loc + 1 <= src.length - 1 && ((loc + 1) / col == loc / col)  && !flag[loc + 1] && src[loc + 1] == tar[index]) {
            if (index == tar.length - 1) {
                return true;
            }
            flag[loc + 1] = true;
            boolean res = dfs(loc + 1, index + 1);
            if (res) {
                return true;
            }
            flag[loc + 1] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution65 s = new Solution65();
        boolean res = s.hasPath("ABCESFCSADEE".toCharArray(),3,4,"ABCCED".toCharArray());
        System.out.println(res);
    }
}
