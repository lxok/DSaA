package leetcode;

import java.util.*;

/**
 * Created by nick on 2017/3/19.
 */
/**
 * 这个题大数据测试过不了
 * 使用BFS, 并用数组过滤元素
 */
public class Solution126 {
    public static class NumId {
        int value;
        int pri;

        public NumId(int value, int pri) {
            this.value = value;
            this.pri = pri;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        int len = wordList.size();
        int endWordValue = -1;
        int beginWordValue = -1;

        for (int i = 0; i < len; i++) {
            if (wordList.get(i).equals(endWord)) {
                endWordValue = i;
            }
            if (wordList.get(i).equals(beginWord)) {
                beginWordValue = i;
            }
        }

        Queue<Integer> que = new LinkedList<>();
        boolean[] used = new boolean[len];
        for (int i = 0; i < len; i++) {
            used[i] = false;
        }
        if (beginWordValue != -1) {
            used[beginWordValue] = true;
        }
        if (endWordValue == -1) {
            return res;
        }
        List<List<NumId>> pri = new ArrayList<>();
        List<NumId> list = new ArrayList<>();
        boolean find = false;
        for (int i = 0; i < len; i++) {
            if (ifOnePath(beginWord, wordList.get(i))) {
                que.offer(i);
                list.add(new NumId(i, -1));
                used[i] = true;
                if (i == endWordValue) {
                    find = true;
                }
            }
        }
        pri.add(list);
        while (!find && !que.isEmpty()) {
            List<NumId> tmpList = new ArrayList<>();
            int queSize = que.size();
            for (int i = 0; i < queSize; i++) {
                int index = que.poll();
                for (int j = 0; j < len; j++) {
                    if (ifOnePath(wordList.get(index), wordList.get(j)) && !used[j]) {
                        que.offer(j);
                        tmpList.add(new NumId(j, i));
                        if (j == endWordValue) {
                            find = true;
                        }
                    }
                }
            }
            pri.add(tmpList);
            if (find) {
                break;
            }
            for (int i = 0; i < tmpList.size(); i++) {
                used[tmpList.get(i).value] = true;
            }
        }

        List<NumId> last = pri.get(pri.size() - 1);
        if (last == null) {
            return res;
        }
        for (int i = 0; i < last.size(); i++) {
            if (last.get(i).value == endWordValue) {
                List<Integer> l = new ArrayList<>();
                int j = pri.size() - 1;
                int p = last.get(i).pri;
                while (j >= 1) {
                    List<NumId> tmpList = pri.get(--j);
                    l.add(tmpList.get(p).value);
                    p = tmpList.get(p).pri;
                }
                List<String> resList = new ArrayList<>();
                resList.add(beginWord);
                for (int k = l.size() - 1; k >= 0; k--) {
                    resList.add(wordList.get(l.get(k)));
                }
                resList.add(endWord);
                res.add(resList);
            }
        }
        return res;
    }

    public boolean ifOnePath(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int match = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                match++;
                if (match >= 2) {
                    return false;
                }
            }
        }
        if (match == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution126 s = new Solution126();
        String beginWord = "a";
        String endWord = "c";
        List<String> wordList = new ArrayList<>();
        wordList.add("a");
        wordList.add("b");
        wordList.add("c");
        s.findLadders(beginWord, endWord, wordList);
    }
}
