package nowcoder.mianshijindian;

/**
 * Created by nick on 2017/6/21.
 */

//最大递增子序列
public class Box {
    public int getHeight(int[] w, int[] l, int[] h, int n) {
        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 1; j--) {
                if (w[j] > w[j - 1]) {
                    swap(w, j, j - 1);
                    swap(l, j, j - 1);
                    swap(h, j, j - 1);
                } else {
                    break;
                }
            }
        }
        int val = 0;
        int[] res = new int[n];
        res[0] = h[0];
        for (int i = 1; i < n; i++) {
            int tmp = 0;
            for (int j = 0; j < i; j++) {
                if (w[j] > w[i] && l[j] > l[i]) {
                    tmp = Math.max(tmp, res[j]);
                }
            }
            res[i] = tmp + h[i];
            val = Math.max(val, res[i]);
        }
        return val;
    }

    void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        Box b = new Box();
        int res = b.getHeight(new int[]{1,1,1},new int[]{1,1,1},new int[]{1,1,1},3);

    }
}
