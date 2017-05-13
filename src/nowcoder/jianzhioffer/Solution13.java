package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/4/26.
 */
public class Solution13 {
    public void reOrderArray(int [] array) {
        if (array.length == 0) {
            return;
        }
        int odd = 0;
        int even = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[even] % 2 != 0) {
                even++;
            } else {
                break;
            }
        }
        while (odd < array.length && even < array.length) {
            while (odd < array.length) {
                if (array[odd] % 2 == 0) {
                    odd++;
                } else {
                    break;
                }
            }
            if (odd < array.length && even < odd) {
                int tmp = array[odd];
                int index = odd - 1;
                while (index >= even) {
                    array[index + 1] = array[index];
                    index--;
                }
                array[even] = tmp;
                even++;
            }
            odd++;
        }
    }

    public static void main(String[] args) {
        Solution13 s = new Solution13();
        s.reOrderArray(new int[]{1,2,3,4,5,6});
    }
}
