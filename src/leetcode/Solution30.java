package leetcode;

import java.util.*;

/**
 * Created by nick on 2016/12/19.
 */
public class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList<>();
        if (s.length() == 0 || words.length == 0) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> tmp = new HashMap<>();
        int wLength = words[0].length();
        int wCount = words.length;
        if (s.length() < wCount * wLength) {
            return res;
        }
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) +1);
            } else {
                map.put(words[i], 1);
            }
        }
        for (int i = 0; i <= s.length() - wLength * wCount; i++) {
            tmp.clear();
            for (int j = 0; j < wCount; j++) {
                String sub = s.substring(i + j * wLength, i + j * wLength + wLength);
                if (!map.containsKey(sub)) {
                    break;
                }
                if (tmp.containsKey(sub)) {
                    tmp.put(sub, tmp.get(sub) + 1);
                } else {
                    tmp.put(sub, 1);
                }
                if (tmp.get(sub) > map.get(sub)) {
                    break;
                }
                if (j == wCount - 1) {
                    res.add(i);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution30 s = new Solution30();
        List<Integer> l = s.findSubstring("barfoothefoobarman", new String[]{"foo","bar"});
        Iterator i = l.iterator();
        while (i.hasNext()) {
            System.out.println("i:" + i.next());
        }
    }
}
