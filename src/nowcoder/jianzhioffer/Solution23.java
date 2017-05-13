package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/4/29.
 */
public class Solution23 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return dfs(sequence, 0, sequence.length - 1);
    }

    public boolean dfs(int[] seq, int start, int end) {
        if (start == end) {
            return true;
        }
        int val = seq[end];
        int i = end - 1;
        while (i >= start) {
            if (seq[i] < val) {
                break;
            }
            i--;
        }
        if (i < end - 1) {
            for (int k = end - 1; k >= i + 1; k--) {
                if (seq[k] < val) {
                    return false;
                }
            }
        }
        if (i >= start) {
            for (int k = i; k >= start; k--) {
                if (seq[k] > val) {
                    return false;
                }
            }
        }
        boolean left;
        boolean right;
        if (i < end - 1) {
            left = dfs(seq, i + 1, end - 1);
        } else {
            left = true;
        }

        if (!left) {
            return false;
        }
        if ( i >= start) {
            right = dfs(seq, start, i);
        } else {
            right = true;
        }
        return right;
    }
}
