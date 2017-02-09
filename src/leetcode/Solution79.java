package leetcode;

/**
 * Created by nick on 2017/1/10.
 */
public class Solution79 {
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) {
            return false;
        }
        if (word.length() == 0) {
            return true;
        }
        if (board.length == 0) {
            return false;
        }
        int matchIndex= 0;
        boolean suc = false;
        int[][] path = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                suc = dfs(board, i , j, path, word, matchIndex);
                if (suc) {
                    return true;
                }
            }
        }
        return suc;
    }

    public boolean dfs(char[][] board, int i, int j, int[][] path, String word, int matchIndex) {
        //System.out.println("i:" + i + " j:" + j + " matchIndex:" + matchIndex);
        char value = board[i][j];
        if (value == word.charAt(matchIndex)) {
            matchIndex++;
        } else {
            return false;
        }
        if (matchIndex >= word.length()) {
            return true;
        }
        path[i][j] = -1;
        boolean suc = false;
        if (!suc && i - 1 >= 0 && path[i - 1][j] != -1) {
            suc = dfs(board, i - 1, j, path, word, matchIndex);
        }
        if (!suc && i + 1 < board.length && path[i + 1][j] != -1) {
            suc = dfs(board, i + 1, j, path, word, matchIndex);
        }
        if (!suc && j - 1 >= 0 && path[i][j - 1] != -1) {
            suc = dfs(board, i, j - 1, path, word, matchIndex);
        }
        if (!suc && j + 1 < board[0].length && path[i][j + 1] != -1) {
            suc = dfs(board, i, j + 1, path, word, matchIndex);
        }
        path[i][j] = 0;
        return suc;
    }

    public static void main(String[] args) {
        Solution79 s = new Solution79();
        char[][] board = new char[2][2];
        board[0][0] = 'a';
        board[0][1] = 'b';
        board[1][0] = 'c';
        board[1][1] = 'd';
        System.out.println(s.exist(board, "bdc"));
    }
}
