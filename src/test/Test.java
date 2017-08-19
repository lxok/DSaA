package test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by nick on 2017/4/7.
 */
public class Test {
    public static void main(String[] args) {
        int a = 1;

    }

    static int test(int n, int[] arr) {
        Arrays.sort(arr);
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return Math.abs(arr[0] - arr[1]);
        }
        int left = arr[0];
        int right = arr[1];
        boolean dir = true;
        int res = Math.abs(right - left);
        for (int i = 2; i < arr.length; i++) {
            if (dir) {
                if (arr[i] - right >= arr[i] - left) {
                    res = Math.max(res, arr[i] - right);
                    right = arr[i];
                } else {
                    res = Math.max(res, arr[i] - left);
                    left = arr[i];
                    dir = false;
                }
            } else {
                if (arr[i] - left > arr[i] - right) {
                    res = Math.max(res, arr[i] - left);
                    left = arr[i];
                } else {
                    res = Math.max(res, arr[i] - right);
                    right = arr[i];
                    dir = true;
                }
            }
        }
        return res;
    }
}


