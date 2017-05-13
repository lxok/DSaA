package nowcoder.jianzhioffer;

import java.util.*;

/**
 * Created by nick on 2017/4/30.
 */
public class Solution27 {
    ArrayList<String> res= new ArrayList<>();
    String target;

    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] ca = str.toCharArray();
        Arrays.sort(ca);
        target = String.valueOf(ca);
        boolean[] used = new boolean[str.length()];
        for (int i = 0; i < used.length; i++) {
            used[i] = false;
        }
        dfs("", used);
        return res;
    }

    public void dfs(String str, boolean[] used) {
        if (str.length() == used.length) {
            res.add(str);
            return;
        }
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                if (!map.containsKey(target.charAt(i))) {
                    map.put(target.charAt(i), i);
                }
            }
        }
        Iterator<Character> i = map.keySet().iterator();
        while (i.hasNext()) {
            char c = i.next();
            String newStr = str + c;
            used[map.get(c)] = true;
            dfs(newStr, used);
            used[map.get(c)] = false;
        }
    }
}
