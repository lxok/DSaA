package data_structure.sort;

/**
 * Created by nick on 2017/6/12.
 */
public class Insert {
    public void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int tmp = a[i];
            int j;
            for (j = i; j > 0; j--) {
                if (a[j - 1] > tmp) {
                    a[j] = a[j - 1];
                } else {
                    break;
                }
            }
            a[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Insert in = new Insert();
        int[] a = {1, 6, 5, 4, 3, 2};
        in.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
