package data_structure.sort;

/**
 * Created by nick on 2017/6/12.
 */
public class Shell {
    public void sort(int[] a) {
        for (int gap = a.length / 2; gap >= 1; gap /= 2) {
            for (int i = gap; i < a.length; i++) {
                int tmp = a[i];
                int j;
                for (j = i; j >= gap; j -= gap) {
                    if (a[j - gap] > tmp) {
                        a[j] = a[j - gap];
                    } else {
                        break;
                    }
                }
                a[j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Shell sorter = new Shell();
        int[] a = {1, 6, 5, 4, 3, 2};
        sorter.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
