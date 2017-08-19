package nowcoder.mianshijindian;

/**
 * Created by nick on 2017/6/17.
 */
public class Robot2 {
    public int countWays(int[][] map, int x, int y) {
        if(x == 1 || y == 1) {
            return 1;
        }
        int[][] val = new int[x + 1][y + 1];
        for (int j = 1; j <= y; j++) {
            if (map[0][j - 1] == 1) {
                val[1][j] = 1;
            } else {
                for (; j <= y; j++) {
                    val[1][j] = 0;
                }
            }
        }
        for (int i = 1; i <= x; i++) {
            if (map[i - 1][0] == 1) {
                val[i][1] = 1;
            } else {
                for (; i <= x; i++) {
                    val[i][1] = 0;
                }
            }
        }
        for (int i = 2; i <= x; i++) {
            for (int j = 2; j <= y; j++) {
                if (map[i - 1][j - 1] == 1) {
                    val[i][j] = val[i - 1][j] + val[i][j - 1];
                } else {
                    val[i][j] = 0;
                }
            }
        }
        return val[x][y];
    }
}
