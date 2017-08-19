package nowcoder.mianshijindian;

/**
 * Created by nick on 2017/6/17.
 */
public class Robot {
    public int countWays(int x, int y) {
        if(x == 1 || y == 1) {
            return 1;
        }
        int[][] val = new int[x + 1][y + 1];
        for (int j = 1; j <= y; j++) {
            val[1][j] = 1;
        }
        for (int i = 2; i <= x; i++) {
            val[i][1] = 1;
        }
        for (int i = 2; i <= x; i++) {
            for (int j = 2; j <= y; j++) {
                val[i][j] = val[i - 1][j] + val[i][j - 1];
            }
        }
        return val[x][y];
    }
}
