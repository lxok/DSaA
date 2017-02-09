package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nick on 2017/1/10.
 */
/**
 * dfs要不就是先分叉，再检验
 * 要不就是先检验，再分叉
 *
 *
 * 在每一个节点加下一级，然后分叉。
 *
 * dfs的题目共性思路应该是这样：
 * 1.在每一节点分析应该分下层节点是否存在，如果分到下层节点，则节点一定存在。（可选项）
 * 2.每个节点先判定自己是否存在，做每个节点当前的操作，然后决定是否分叉下一节点。（共性思路）
 * 3.针上两点，所以在判定下层节点是否存在时，可以在当前节点在递归时就检验判断，也可以在每个节点开始时
 *  自行检验时候存在。这个看情况考虑。
 */
public class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < k) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        dfs(res, list, n, k, 0, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> list, int n, int k, int index, int level) {
        if (level == k) {
            List<Integer> tmp = new ArrayList<>();
            tmp.addAll(list);
            res.add(tmp);
            return;
        }
        int size;
        for (int i = index; i < n; i++) {
            list.add(i + 1);
            size = list.size();
            dfs(res, list, n, k, i + 1, level + 1);
            list.remove(size - 1);
        }
    }

    public static void main(String[] args) {
        Solution77 s = new Solution77();
        s.combine(5, 3);
    }
}
