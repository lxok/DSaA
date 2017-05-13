package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/5/2.
 */
public class Solution35 {
    long count = 0;

    public int InversePairs(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] tmp = new int[array.length];
        merge(array, tmp, 0, array.length - 1);
        return (int)(count % (long)1000000007);
    }

    public void merge(int[] a, int[] tmp, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (end + start) / 2;
        merge(a, tmp, start, mid);
        merge(a, tmp, mid + 1, end);

        int i = start;
        int j = mid + 1;
        int k = start;
        while (i <= mid && j <= end) {
            if (a[i] < a[j]) {
                tmp[k] = a[i];
                i++;
            } else {
                tmp[k] = a[j];
                j++;
                count += mid - i + 1;
            }
            k++;
        }
        if (i <= mid) {
            while (i <= mid) {
                tmp[k++] = a[i++];
            }
        } else {
            while (j <= end) {
                tmp[k++] = a[j++];
            }
        }
        for (int t = start; t <= end; t++) {
            a[t] = tmp[t];
        }
    }
}
