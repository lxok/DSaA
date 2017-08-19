package data_structure.sort;

/**
 * Created by nick on 2017/6/14.
 */
public class Quick {
    public void sort(int[] a) {
        dfs(a, 0, a.length - 1);
    }

    public void dfs(int[] a, int left, int right) {
        if (right - left + 1 < 3) {
            insert(a, left, right);
            return;
        }
        int mid = getMid(a, left, right);
        int i = left, j = right - 1;
        while (i < j) {
            while (a[i] < mid) {
                i++;
            }
            while (a[j] >= mid) {
                j--;
            }
            if (i < j) {
                swap(a, i, j);
            }
        }
        swap(a, i, right - 1);
        dfs(a, left, i - 1);
        dfs(a, i + 1, right);
    }

    void insert(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        if (a[left] > a[right]) {
            swap(a, left, right);
        }
    }

    int getMid(int[] a, int left, int right) {
        int mid = (left + right) / 2;
        if (a[left] > a[right]) {
            swap(a, left, right);
        }
        if (a[left] > a[mid]) {
            swap(a, left, mid);
        }
        if (a[right] < a[mid]) {
            swap(a, right, mid);
        }
        swap(a, mid, right - 1);
        return a[right - 1];
    }

    void swap(int[] a, int left, int right) {
        int tmp = a[left];
        a[left] = a[right];
        a[right] = tmp;
    }


    public static void main(String[] args) {
        Quick sort = new Quick();
        int[] a = {1, 6, 5, 4, 3, 9, 7, 2};
        sort.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
