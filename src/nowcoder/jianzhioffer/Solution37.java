package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/5/3.
 */
public class Solution37 {
    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int min = -1;
        int max = -1;
        int start = 0;
        int end = array.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (array[mid] < k) {
                start = mid + 1;
            } else if (array[mid] > k) {
                end = mid - 1;
            } else {
                min = mid;
                end = mid - 1;
            }
        }
        start = 0;
        end = array.length - 1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (array[mid] < k) {
                start = mid + 1;
            } else if (array[mid] > k) {
                end = mid - 1;
            } else {
                max = mid;
                start = mid + 1;
            }
        }
        if (min == -1 || max == -1) {
            return 0;
        }
        return max - min + 1;
    }
}
