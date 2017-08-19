package nowcoder.mianshijindian;

/**
 * Created by nick on 2017/6/25.
 */
public class AntiOrder {
    int[] tmp;
    int count = 0;

    public int count(int[] A, int n) {
        tmp = new int[n];
        dfs(A, 0, n -1);
        return count;
    }

    public void dfs(int[] A, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        dfs(A, left, mid);
        dfs(A, mid + 1, right);
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (A[i] <= A[j]) {
                tmp[k] = A[i];
                i++;
            } else {
                tmp[k] = A[j];
                j++;
                count += mid - i + 1;
            }
            k++;
        }
        while (i <= mid) {
            tmp[k++] = A[i++];
        }
        while (j <= right) {
            tmp[k++] = A[j++];
        }
        for (int t = left; t <= right; t++) {
            A[t] = tmp[t];
        }
    }
}
