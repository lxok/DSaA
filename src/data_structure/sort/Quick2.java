package data_structure.sort;

/**
 * Created by nick on 2017/7/15.
 */
public class Quick2 {
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        dfs(arr, 0, arr.length - 1);
    }

    void dfs(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        if (r - l == 1) {
            if (arr[l] > arr[r]) {
                int tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
            }
            return;
        }
        getMid(arr, l, r);
        int i = l;
        int j = r - 1;
        int val = arr[j];
        while (i < j) {
            while (arr[i] < val && i <= r - 1) {
                i++;
            }
            while (arr[j] >= val && j >= 0) {
                j--;
            }
            if (i < j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        int tmp = arr[i];
        arr[i] = arr[r - 1];
        arr[r - 1] = tmp;
        dfs(arr, l, i - 1);
        dfs(arr, i + 1, r);
    }

    void getMid(int[] arr, int l, int r) {
        int mid = (l + r) / 2;
        if (arr[l] > arr[mid]) {
            int tmp = arr[l];
            arr[l] = arr[mid];
            arr[mid] = tmp;
        }
        if (arr[l] > arr[r]) {
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
        }
        if (arr[mid] > arr[r]) {
            int tmp = arr[mid];
            arr[mid] = arr[r];
            arr[r] = tmp;
        }

        int tmp = arr[r - 1];
        arr[r - 1] = arr[mid];
        arr[mid] = tmp;
    }

    public static void main(String[] args) {
        Quick2 sort = new Quick2();
        int[] a = {1, 6, 5, 4, 3, 9, 7,6, 2};
        sort.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
