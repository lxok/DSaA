package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nick on 2016/11/2.
 */
public class Q_3 {
    public static void main(String[] args) {
        Solution3 s = new Solution3();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
    }

}

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        char[] ca = s.toCharArray();
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < ca.length; j++) {
            if (map.containsKey(ca[j]) && i <= map.get(ca[j])) {
                i = map.get(ca[j]) + 1;
            } else {
                res = res >= (j - i + 1) ? res : (j - i + 1);
            }
            map.put(ca[j], j);
        }
        return res;
    }
}
