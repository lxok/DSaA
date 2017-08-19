package nowcoder.mianshijindian;

/**
 * Created by nick on 2017/6/25.
 */
public class findElement {
    public int[] findElement(int[][] mat, int n, int m, int x) {
        int[] res = new int[2];
        int i = n - 1;
        int j = 0;
        while (i >= 0 && j <= m - 1) {
            if (x > mat[i][j]) {
                j++;
            } else if (x < mat[i][j]) {
                i--;
            } else {
                res[0] = i;
                res[1] = j;
                return res;
            }
        }
        res[0] = -1;
        res[1] = -1;
        return res;
    }
}
