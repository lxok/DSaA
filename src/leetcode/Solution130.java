package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nick on 2017/3/28.
 */
/**
 * 这道题其实思路很简单
 * 但是，如果用递归，则栈溢出
 * 所以这里不用递归，所以要么用栈(dfs),要么用队列(bfs)
 * 这里用的是队列
 * 但是为了避免超时，尽量别使用方法调用。
 */
public class Solution130 {
    static class Loc {
        int i;
        int j;

        public Loc(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    char[][] board2;
    int[][] flag;
    int row;
    int column;

    public void solve(char[][] board) {
        if (board == null || board.length == 0|| board[0].length == 0) {
            return;
        }
        row = board.length;
        column = board[0].length;
        board2 = board;
        flag = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                flag[i][j] = 0;
            }
        }

        Queue<Loc> que = new LinkedList();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == 'O' && flag[i][j] == 0) {
                    if (i == 0 || i == row - 1 || j == 0 || j == column - 1) {
                        que.offer(new Loc(i, j));
                    }
                }
            }
        }

        bfs(que);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == 'O' && flag[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void bfs(Queue<Loc> que) {
        while (!que.isEmpty()) {
            Loc loc = que.poll();
            int i = loc.i;
            int j = loc.j;
            flag[i][j] = 1;
            if (i - 1 >= 0 && board2[i - 1][j] == 'O' && flag[i - 1][j] == 0) {
                que.offer(new Loc(i - 1, j));
            }
            if (i + 1 < row && board2[i + 1][j] == 'O' && flag[i + 1][j] == 0) {
                que.offer(new Loc(i + 1, j));
            }
            if (j - 1 >= 0 && board2[i][j - 1] == 'O' && flag[i][j - 1] == 0) {
                que.offer(new Loc(i, j - 1));
            }
            if (j + 1 < column && board2[i][j + 1] == 'O' && flag[i][j + 1] == 0) {
                que.offer(new Loc(i, j + 1));
            }
        }
    }
}
