package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nick on 2016/12/24.
 */
public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return false;
        }
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (!set.add(board[i][j])) {
                    return false;
                }
            }
            set.clear();
        }

        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (!set.add(board[j][i])) {
                    return false;
                }
            }
            set.clear();
        }

        for(int k = 0; k < 9; k++) {
            for (int i = k/3 * 3; i < k/3 * 3 + 3; i++) {
                for (int j = k%3 * 3; j < k%3 * 3 + 3; j++) {
                    if (board[i][j] == '.') {
                        continue;
                    }
                    if (!set.add(board[i][j])) {
                        return false;
                    }
                }
            }
            set.clear();
        }
        return true;
    }
}
