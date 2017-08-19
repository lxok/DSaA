package nowcoder.mianshijindian;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nick on 2017/6/21.
 */

//单源最短路径
public class Flood {
    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int floodFill(int[][] map, int n, int m) {
        if (map == null || n == 0 || n == 0) {
            return -1;
        }
        int[][] val = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                val[i][j] = -1;
            }
        }
        Queue<Point> q = new LinkedList<>();
        val[0][0] = 0;
        q.add(new Point(0, 0));
        while (!q.isEmpty()) {
            Point p = q.poll();
            int v = val[p.x][p.y];
            if (p.x - 1 >= 0) {
                if (val[p.x - 1][p.y] == -1) {
                    if (map[p.x - 1][p.y] == 1) {
                        val[p.x - 1][p.y] = 0;
                    } else {
                        val[p.x - 1][p.y] = v + 1;
                        q.add(new Point(p.x - 1, p.y));
                    }
                }
            }
            if (p.y - 1 >= 0) {
                if (val[p.x][p.y - 1] == -1) {
                    if (map[p.x][p.y - 1] == 1) {
                        val[p.x][p.y - 1] = 0;
                    } else {
                        val[p.x][p.y - 1] = v + 1;
                        q.add(new Point(p.x, p.y - 1));
                    }
                }
            }
            if (p.x + 1 <= n - 1) {
                if (val[p.x + 1][p.y] == -1) {
                    if (map[p.x + 1][p.y] == 1) {
                        val[p.x + 1][p.y] = 0;
                    } else {
                        val[p.x + 1][p.y] = v + 1;
                        if (p.x + 1 == n - 1 && p.y == m - 1) {
                            return val[p.x + 1][p.y];
                        }
                        q.add(new Point(p.x + 1, p.y));
                    }
                }
            }
            if (p.y + 1 <= m - 1) {
                if (val[p.x][p.y + 1] == -1) {
                    if (map[p.x][p.y + 1] == 1) {
                        val[p.x][p.y + 1] = 0;
                    } else {
                        val[p.x][p.y + 1] = v + 1;
                        if (p.x  == n - 1 && p.y + 1 == m - 1) {
                            return val[p.x][p.y + 1];
                        }
                        q.add(new Point(p.x, p.y + 1));
                    }
                }
            }
        }
        return -1;
    }
}
