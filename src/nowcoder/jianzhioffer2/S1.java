package nowcoder.jianzhioffer2;

/**
 * Created by nick on 2017/7/4.
 */
public class S1 {
    public boolean Find(int target, int [][] array) {
        int m = array.length;
        int n = array[0].length;
        int i = m - 1;
        int j = 0;
        while (i >= 0 && j <= n - 1) {
            if (array[i][j] > target) {
                i--;
            } else if (array[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
}
