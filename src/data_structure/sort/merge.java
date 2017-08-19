package data_structure.sort;

/**
 * Created by nick on 2017/6/12.
 */
public class merge {
    public void sort(int[] a) {
        int[] b = new int[a.length];
        dfs(a, b, 0, a.length - 1);
    }

    public void dfs(int[] a, int[] b, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        dfs(a, b, l, mid);
        dfs(a, b, mid + 1, r);
        int i = l;
        int j = mid + 1;
        int k = l;
        while (i <= mid && j <= r) {
            if (a[i] < a[j]) {
                b[k] = a[i];
                i++;
            } else {
                b[k] = a[j];
                j++;
            }
            k++;
        }
        if (i <= mid) {
            for (; i <= mid; i++) {
                b[k] = a[i];
                k++;
            }
        } else {
            for (; j <= r; j++) {
                b[k] = a[j];
                k++;
            }
        }
        for (int p = l; p <= r; p++) {
            a[p] = b[p];
        }
    }

    public static void main(String[] args) {
        merge in = new merge();
        int[] a = {1, 6, 5, 7, 4, 3, 2};
        in.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
