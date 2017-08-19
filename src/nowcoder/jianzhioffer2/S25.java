package nowcoder.jianzhioffer2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by nick on 2017/7/9.
 */
public class S25 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] stra = str.toCharArray();
        Arrays.sort(stra);
        StringBuffer sb = new StringBuffer();
        int[] used = new int[stra.length];
        for (int i = 0; i < used.length; i++) {
            used[i] = 0;
        }
        dfs(res, sb, used, stra);
        return res;
    }

    public void dfs(ArrayList<String> res, StringBuffer sb, int[] used, char[] stra) {
        char pri = '`';
        for (int i = 0; i < used.length; i++) {
            if (used[i] == 0 && stra[i] != pri) {
                sb.append(stra[i]);
                pri = stra[i];
                used[i] = 1;
                if (sb.length() == stra.length) {
                    res.add(sb.toString());
                } else {
                    dfs(res, sb, used, stra);
                }
                used[i] = 0;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
