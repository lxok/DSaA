package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/5/3.
 */
public class Solution40 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length == 0) {
            num1[0] = num2[0] = 0;
            return;
        }
        int index, sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum ^= array[i];
        }
        for (index = 0; index < 32; index++) {
            if ((sum & (1 << index)) != 0) {
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & (1 << index)) == 0) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }
}
