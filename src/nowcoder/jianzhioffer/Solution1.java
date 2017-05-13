package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/4/25.
 */
public class Solution1 {
    public boolean Find(int target, int [][] array) {
        int m = array.length;
        int n = array[0].length;
        int i = m - 1;
        int j = 0;
        while (i >= 0 && j <= n - 1) {
            if (target > array[i][j]) {
               j++;
            } else if (target < array[i][j]) {
                i--;
            } else {
                return true;
            }
        }
        return false;
    }
}
