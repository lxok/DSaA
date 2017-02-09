package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nick on 2017/1/9.
 */
/**
 * 写的很困难，很复杂，很没有条理，硬是把不同的情况都杂糅在了一起!
 * 又想了下，可以在一次循环中写先找后项再找前项，从而确定一个最短，然后再循环下一次。
 *
 * 所以说滑动窗口的方法实际上就是动态保存Left,和right之间的状态。
 * 有两种选择：
 * 1.在每次循环中选择left递进或是right递进。
 * 2.例如本题，right前进和left前进是有确定的顺序的，可以在每次循环中完成right和left的先后前进
 *
 * 同时匹配几个值的问题要想到用字典处理。即HashMap。
 */
public class Solution76 {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] ta = t.toCharArray();
        for (int i = 0; i < ta.length; i++) {
            if (map.containsKey(ta[i])) {
                map.put(ta[i], map.get(ta[i]) + 1);
            } else {
                map.put(ta[i], 1);
            }
        }
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int minStart = 0;
        int currentStart = 0;
        int currentEnd = 0;
        int count = 0;
        char value;
        boolean has = false;
        Map<Character, Integer> tmp = new HashMap<>();
        while (left < s.length() && right < s.length()) {
            if (count < ta.length) {
                value = s.charAt(right);
                if (map.containsKey(value)) {
                    if (tmp.containsKey(value)) {
                        if (tmp.get(value) < map.get(value)) {
                            count++;
                        }
                        tmp.put(value, tmp.get(value) + 1);
                    } else {
                        tmp.put(value, 1);
                        count++;
                    }
                }
                if (count == ta.length) {
                    currentEnd = right;
                    if (currentEnd - currentStart + 1 < min) {
                        min = currentEnd - currentStart + 1;
                        minStart = currentStart;
                        has = true;
                    }
                }
                if (right == s.length() - 1 && count < ta.length) {
                    break;
                }
                if (right < s.length() - 1) {
                    right++;
                }
            }  else {
                value = s.charAt(left);
                if (map.containsKey(value)) {
                    if (tmp.get(value) <= map.get(value)) {
                        currentStart = left;
                        count--;
                        if (currentEnd - currentStart + 1 < min) {
                            min = currentEnd - currentStart + 1;
                            minStart = currentStart;
                        }
                        currentStart = left + 1;
                    }
                    tmp.put(value, tmp.get(value) - 1);
                }
                left++;
                if (currentEnd == s.length() - 1 && count < ta.length) {
                    break;
                }
            }
        }
        String res = "";
        if (has) {
            res = s.substring(minStart, minStart + min);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution76 s = new Solution76();
        s.minWindow("bdab", "ab");
    }
}
