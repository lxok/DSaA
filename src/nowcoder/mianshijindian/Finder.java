package nowcoder.mianshijindian;

/**
 * Created by nick on 2017/6/22.
 */
public class Finder {
    public int findElement(int[] A, int n, int x) {
        int left = 0;
        int right = n - 1;
        int mid;
        if (A[left] == x) {
            return left;
        }
        if (A[right] == x) {
            return right;
        }
        while (right - left + 1 >= 3) {
            mid = (left + right) / 2;
            //System.out.println("left:" + left + " right:" + right + " mid:" + mid + " val:" + A[mid]);
            if (x > A[mid]) {
                if (A[left] > A[mid] && A[right] > A[mid]) {
                    if (x > A[right]) {
                        right = mid;
                    } else {
                        left = mid;
                    }
                } else if (A[left] < A[mid] && A[right] < A[mid]) {
                    left = mid;
                } else {
                    left = mid;
                }
            } else if (x < A[mid]) {
                if (A[left] > A[mid] && A[right] > A[mid]) {
                    right = mid;
                } else if (A[left] < A[mid] && A[right] < A[mid]) {
                    if (x > A[right]) {
                        right = mid;
                    } else {
                        left = mid;
                    }
                } else {
                    right = mid;
                }
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Finder f = new Finder();
        int[] arr = new int[]{6,1,2,3,4,5};
        int res = f.findElement(arr, 6, 3);
        System.out.println(res);
    }
}
