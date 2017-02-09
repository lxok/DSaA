package leetcode;

import java.util.*;

/**
 * Created by nick on 2016/12/31.
 */
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        char[] c;
        String tmp;
        Set<String> set  = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            c = strs[i].toCharArray();
            Arrays.sort(c);
            tmp = String.valueOf(c);
            if (set.add(tmp)) {
                List<String> list = new ArrayList<>();
                res.add(list);
                list.add(tmp);
                list.add(strs[i]);
            } else {
                for (int j = 0; j < res.size(); j++) {
                    if (res.get(j).get(0).equals(tmp)) {
                        res.get(j).add(strs[i]);
                    }
                }
            }
        }
        for (int i = 0; i < res.size(); i++) {
            res.get(i).remove(0);
        }
        return res;
    }

    public static void main(String[] args) {
        Set<String> s = new HashSet<>();
        String s1 = "ate";
        String s2 = "ate";
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        s.add(String.valueOf(c1));
        s.add(String.valueOf(c2));
        System.out.println(s.size());
     }
}
