package leetcode;

/**
 * Created by nick on 2016/11/8.
 *
 * 这个题由于题设要求不能使用额外内存，所以不能使用字符数组。
 *
 * 1. 将^符号当做幂次来用，很无奈，实际表示按位异或。
 * 2. 求长度时i可能大于最大值，需要判断。
 * 3. 负数都不是回文数。
 */
public class Solution9 {
    public static void main(String[] args) {
        Solution9 s = new Solution9();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(s.isPalindrome(1410110141));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int len = 0;
        int i = 1;
        while (x/i != 0) {
            len++;
            if (Integer.MAX_VALUE / i < 10) {
                break;
            }
            i *= 10;
        }
        int leftIndex;
        int rightIndex;
        int leftValue;
        int rightValue;
        if (len % 2 == 0) {
            leftIndex = len / 2 - 1;
            rightIndex = len / 2;
        } else {
            leftIndex = len/2;
            rightIndex = leftIndex;
        }
        while (leftIndex >= 0) {
            if (leftIndex == 0) {
                if (x / (pow(len-1)) != x % 10) {
                    return false;
                }
            } else {
                leftValue = x % pow(len - leftIndex);
                leftValue = leftValue / pow(len - leftIndex - 1);
                rightValue = x % pow(len - rightIndex);
                rightValue = rightValue / pow(len - rightIndex - 1);

                if (leftValue != rightValue) {
                    return false;
                }
            }
            leftIndex--;
            rightIndex++;
        }
        return true;
    }

    public int pow(int x) {
        if (x == 0) {
            return 1;
        }
        int res = 1;
        for (int i = 0; i < x; i++) {
            res *= 10;
        }
        return res;
    }
}
