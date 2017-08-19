package nowcoder.jianzhioffer2;

/**
 * Created by nick on 2017/7/8.
 */
public class S21 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return dfs(sequence, 0, sequence.length - 1);
    }

    public boolean dfs(int[] seq, int l, int r) {
        if (l >= r) {
            return true;
        }
        int val = seq[r];
        int i;
        for (i = l; i < r; i++) {
            if (seq[i] >= val) {
                break;
            }
        }
        for (; i < r; i++) {
            if (seq[i] < val) {
                return false;
            }
        }
        if (!dfs(seq, l, i - 1)) {
            return false;
        }
        if (!dfs(seq, i, r - 1)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        S21 s = new S21();
        boolean res = s.VerifySquenceOfBST(new int[]{4,8,6,12,16,14,10});
        System.out.println(res);
    }
}
