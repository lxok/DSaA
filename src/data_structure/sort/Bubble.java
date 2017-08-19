package data_structure.sort;

/**
 * Created by nick on 2017/6/14.
 */
public class Bubble {
    public void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = a.length - 1; j >= i + 1; j--) {
                if (a[j] < a[j - 1]) {
                    int tmp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Bubble sort = new Bubble();
        int[] a = {1, 6, 5, 4, 3, 2};
        sort.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
