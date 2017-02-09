package leetcode;

/**
 * Created by nick on 2016/11/7.
 *
 * O(n)
 *
 * 1. easy表示的是算法思路为简单，但是思路easy和实现easy不同。比如这个。
 * 2. 其实还是由于对于数组操作的实现写的不溜导致的。
 * 3. 将第一行，中间行和其它行分开来写是发现一致处理边界情况较多。
 * 4. 即使分开写，分别考虑的边界情况有一样的，也有不一样的。
 * 5. 过多的变量声明和定义混淆了写法。
 *
 */
public class Solution6 {
    public String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        int groupLen = (numRows > 1) ? numRows + numRows - 2 : 1;
        int groupNum;
        if (c.length <= groupLen)  {
            groupNum = 1;
        } else if (c.length % groupLen == 0) {
            groupNum = c.length/groupLen;
        } else {
            groupNum = c.length/groupLen + 1;
        }
        int[] groupIndex = new int[groupNum];
        for (int i = 0; i < groupIndex.length; i++) {
            groupIndex[i] = i * groupLen;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < groupIndex.length; i++) {
            if (groupIndex[i] < c.length) {
                sb.append(c[groupIndex[i]]);
            }
        }
        int headIndex = 1;
        int tailIndex = groupLen - 1;
        int curRow = 2;
        for (int i = 1; i < numRows - 1; i++) {
            for (int j = 0; j < groupNum; j++) {
                int tmpHeadIndex = headIndex + j * groupLen;
                int tmpTailIndex = tailIndex + j * groupLen;
                if (tmpHeadIndex < c.length) {
                    sb.append(c[tmpHeadIndex]);
                }
                if (tmpTailIndex < c.length) {
                    sb.append(c[tmpTailIndex]);
                }
            }
            headIndex++;
            tailIndex--;
            curRow++;
        }
        if (curRow <= numRows ) {
            for (int i = 0; i < groupIndex.length; i++) {
                if ((groupIndex[i] + headIndex) < c.length) {
                    sb.append(c[groupIndex[i] + headIndex]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution6 s = new Solution6();
        String res = s.convert("ABC", 1);
        System.out.println(res);
    }
}
