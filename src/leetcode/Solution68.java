package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nick on 2017/1/7.
 */
public class Solution68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        if (words.length == 1 && words[0].length() == 0) {
            String tmp = "";
            for (int i = 0; i < maxWidth; i++) {
                tmp += " ";
            }
            res.add(tmp);
            return res;
        }
        int index = 1;
        int lineLength = words[0].length();
        int wordLength = words[0].length();
        int start = 0;
        int end = 0;
        while (index <= words.length - 1) {
            int tmpLength = lineLength + 1 + words[index].length();
            if (tmpLength <= maxWidth) {
                lineLength = tmpLength;
                wordLength += words[index].length();
                end = index;
            } else {
                res.add(constructLine(words, start, end, wordLength, maxWidth));
                start = index;
                end = index;
                lineLength = words[index].length();
                wordLength = lineLength;
            }
            index++;
        }
        res.add(constructLine(words, start, end, wordLength, maxWidth));
        return res;
    }

    public String constructLine(String[] words, int start, int end, int wordLength, int maxWidth) {
        if (end == words.length - 1) {
            String tmp = words[start];
            for (int i = start + 1; i <= end; i++) {
                tmp = tmp + " " + words[i];
            }
            int num = maxWidth - tmp.length();
            for(int i = 0; i < num; i++) {
                tmp += " ";
            }
            return tmp;
        }
        if (start == end) {
            int num = maxWidth - words[start].length();
            String tmp = words[start];
            for (int i = 0; i < num; i++) {
                tmp += " ";
            }
            return tmp;
        }
        int space = maxWidth - wordLength;
        int spaceNum = end - start;
        int previousSpace = space % spaceNum;
        int eachSpace = space / spaceNum;
        String res = words[start];
        int index = start + 1;
        while (index <= end) {
            if (previousSpace > 0) {
                for (int i = 0; i < eachSpace + 1; i++) {
                    res += " ";
                }
                previousSpace--;
            }  else {
                for (int i = 0; i < eachSpace; i++) {
                    res += " ";
                }
            }
            res += words[index];
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"a"};
        Solution68 s = new Solution68();
        s.fullJustify(words, 2);
    }
}
