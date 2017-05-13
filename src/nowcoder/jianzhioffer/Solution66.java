package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/5/10.
 */
public class Solution66 {
    boolean flag[][];
    int row;
    int col;
    int thres;

    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0) {
            return 0;
        }
        if (rows == 0 && cols == 0) {
            return 0;
        }
        row = rows;
        col = cols;
        thres = threshold;
        flag = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                flag[i][j] = false;
            }
        }
        return dfs(0, 0);
    }

    public int dfs(int i, int j) {
        System.out.println(i + "," + j);
        if (i < 0 || i >= row || j < 0 || j >= col || flag[i][j] || !canMove(i, j)) {
            return 0;
        }
        flag[i][j] = true;
        int count = 1 + dfs(i + 1, j) + dfs(i - 1, j) + dfs(i, j + 1) + dfs(i, j - 1);
        return count;
    }

    public boolean canMove(int i, int j) {
        int count = 0;
        while (i > 0) {
            count += i % 10;
            i /= 10;
        }
        while (j > 0) {
            count += j % 10;
            j /= 10;
        }
        return (count > thres) ? false : true;
    }
}
