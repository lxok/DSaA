package leetcode;

/**
 * Created by nick on 2016/11/4.
 *
 * 算法书上的题目在分治课后习题2.8，不同点在于该题的两个数组大小同为n。而本题两个数据大小分别为m, n。
 * 要求时间复杂度在O(log(m+n))。
 *
 * 1. 归并排序可以解决，但是不满足题目要求时间复杂度。
 * 2. http://www.cnblogs.com/yuzhangcmu/p/4138184.html
 *    用第k大的思路，每次递归在两个数组里去掉k/2个元素。
 *
 * 算法写错的原因在于忽略了k的奇偶性。(k - k/2) != k/2
 */
public class Q_4 {
    public static void main(String[] args) {
        int[] a = {2, 3, 4, 5, 6};
        int[] b = {1};
        Solution4 s = new Solution4();
        double r = s.findMedianSortedArrays(a, b);
        System.out.println(r);
    }
}

class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length  =  nums1.length + nums2.length;
        double res;
        if (length % 2 == 0) {
            res = findKth(nums1, nums2, 0, 0, length/2) + findKth(nums1, nums2, 0, 0, length/2 + 1);
            res /= 2;
        } else {
            res = findKth(nums1, nums2, 0, 0, (length + 1)/2);
        }
        return res;
    }

    public double findKth(int[] a, int[] b, int aindex, int bindex, int k) {
        if (aindex >= a.length) {
            return b[bindex + k - 1];
        }

        if (bindex >= b.length) {
            return a[aindex + k - 1];
        }

        if (k == 1) {
            return Math.min(a[aindex], b[bindex]);
        }

        int oriK = k;
        k = k/2;

        if ((a.length - aindex) < k) {
            bindex = bindex + k;
        } else if ((b.length - bindex) < k) {
            aindex = aindex + k;
        } else {
            if (a[aindex + k - 1] > b[bindex + k - 1]) {
                bindex = bindex + k;
            } else if (a[aindex + k - 1] < b[bindex + k - 1]) {
                aindex = aindex + k;
            }
            else {
                if (oriK % 2 == 0) {
                    return a[aindex + k - 1];
                } else {
                    aindex = aindex + k;
                    bindex = bindex + k;
                    k = k * 2;
                }
            }
        }
        return findKth(a, b, aindex, bindex, oriK - k); //第一次算法在这里写错了，原因是k去掉k/2后不一定还剩k/2，因为k是整形
    }
}