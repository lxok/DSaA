package nowcoder.jianzhioffer2;

/**
 * Created by nick on 2017/7/5.
 */
public class S7 {
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int l = 0;
        int r = array.length - 1;
        int mid;
        while (r - l > 1) {
            mid = (l + r) / 2;
            if (array[mid] >= array[l]) {
                if (array[mid] <= array[r]) {
                    return array[l];
                } else {
                    l = mid;
                }
            } else {
                r = mid;
            }
        }
        return Math.min(array[l], array[r]);
    }

    public static void main(String[] args) {
        S7 s = new S7();

    }
}
