package nowcoder.jianzhioffer2;

/**
 * Created by nick on 2017/7/6.
 */
public class S14 {
    public void reOrderArray(int [] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int odd;
        int even = 0;
        while (even <= array.length - 1) {
            if (array[even] % 2 == 0) {
                break;
            }
            even++;
        }
        odd = even + 1;
        while (true) {
            while (odd <= array.length - 1) {
                if (array[odd] % 2 == 1) {
                    break;
                }
                odd++;
            }
            if (odd > array.length - 1) {
                return;
            }
            int tmp = array[odd];
            int index = odd;
            while (index >= even + 1) {
                array[index] = array[index - 1];
                index--;
            }
            array[even] = tmp;
            even++;
        }
    }

    public static void main(String[] args) {
        S14 s = new S14();
        s.reOrderArray(new int[]{1,2,3,4,5,6,7});
    }
}
