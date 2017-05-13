package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/4/29.
 */
public class Solution21 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int i = 0;
        int j = 0;
        int[] flag = new int[pushA.length];
        for (int k = 0; k < flag.length; k++) {
            flag[k] = 0;
        }
        while (j < popA.length){
            for (int k = i; k >= 0; k--) {
                if (flag[k] == 0) {
                    if (pushA[k] == popA[j]) {
                        j++;
                        flag[k] = 1;
                    } else {
                        break;
                    }
                }
            }
            if (j < popA.length) {
                while (i < pushA.length && pushA[i] != popA[j]) {
                    i++;
                }
                if (i == pushA.length) {
                    return false;
                }
            }
        }
        if (i == pushA.length - 1 && j == popA.length) {
            return true;
        }
        return false;
    }
}
