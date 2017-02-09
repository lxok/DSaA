package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acer on 2017/1/25.
 */
/**
 * 主要是要了解格雷码的产生过程，再按照递归求解即可。
 */
public class Solution89 {
    public List<Integer> grayCode(int n) {
        if (n == 0) {
            List<Integer> res = new ArrayList<>();
            res.add(0);
            return res;
        }

        List<Integer> res = grayCode(n - 1);
        int addNumber = 1 << (n - 1);
        int size = res.size();
        for (int i = size - 1; i >= 0; i--) {
            res.add(res.get(i) + addNumber);
        }
        return res;
    }
}
