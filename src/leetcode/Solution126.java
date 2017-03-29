package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by nick on 2017/3/19.
 */
public class Solution126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        int len = wordList.size();
        onePath = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (ifOnePath(wordList.get(i), wordList.get(j))) {
                    onePath[i][j] = 1;
                    onePath[j][i] = 1;
                } else {
                    onePath[i][j] = 0;
                    onePath[j][i] = 0;
                }
            }
        }
        int endWordIndex = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (wordList.get(i).equals(endWord)) {
                endWordIndex = i;
            }
        }
        if (endWordIndex == Integer.MAX_VALUE) {
            return res;
        }
        List<List<Integer>> resInt = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (ifOnePath(beginWord, wordList.get(i))) {
                tmp.add(i);
                dfs(resInt, wordList, tmp, endWordIndex);
                tmp.remove(tmp.size() - 1);
            }
        }
        if (min == Integer.MAX_VALUE) {
            return res;
        }
        for (int i = 0; i < resInt.size(); i++) {
            if (resInt.get(i).size() == min) {
                List<String> listS = new ArrayList<>();
                listS.add(beginWord);
                for (int j = 0; j < min; j++) {
                    listS.add(wordList.get(resInt.get(i).get(j)));
                }
                res.add(listS);
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
            }
        }
        if (match == 1) {
            return true;
        }
        return false;
    }

    int min = Integer.MAX_VALUE;
    int[][] onePath;

    public void dfs(List<List<Integer>> res, List<String> wordList, List<Integer> list, int endWordIndex) {
        if (list.size() > min) {
            return;
        }
        if (list.get(list.size() - 1) == endWordIndex) {
            List<Integer> tmp = new ArrayList();
            tmp.addAll(list);
            res.add(tmp);
            if (list.size() < min) {
                min = list.size();
            }
            return;
        }
        if (list.size() == wordList.size()) {
            return;
        }

        int index = list.get(list.size() - 1);
        for (int i = 0; i < wordList.size(); i++) {
            int val = onePath[index][i];
            if (val == 1 && !list.contains(i)) {
                list.add(i);
                dfs(res, wordList, list, endWordIndex);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution126 s = new Solution126();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        s.findLadders(beginWord, endWord, wordList);
    }
}
