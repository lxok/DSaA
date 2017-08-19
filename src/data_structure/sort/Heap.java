package data_structure.sort;

/**
 * Created by nick on 2017/6/12.
 */
public class Heap {
    class Str {
        int[] arr;
        int index = 1;

        Str(int len) {
            arr = new int[len];
        }

        public void put(int num) {
            int i;
            for (i = index; i > 1; i /= 2) {
                if (arr[i / 2] > num) {
                    arr[i] = arr[i / 2];
                } else {
                    break;
                }
            }
            arr[i] = num;
            index++;
        }

        public int get() {
            if (index <= 1) {
                return 0;
            }
            int res = arr[1];
            int tmp = arr[index - 1];
            index--;
            int i = 1;
            while (i * 2 <= index - 1) {
                if (i * 2 + 1 <= index - 1) {
                    if (arr[i * 2] < arr[i * 2 + 1]) {
                        if (arr[i * 2] < tmp) {
                            arr[i] = arr[i * 2];
                            i = i * 2;
                        } else {
                            break;
                        }
                    } else {
                        if (arr[i * 2 + 1] < tmp) {
                            arr[i] = arr[i * 2 + 1];
                            i = i * 2 + 1;
                        } else {
                            break;
                        }
                    }
                } else {
                    if (arr[i * 2] < tmp) {
                        arr[i] = arr[i * 2];
                        i = i * 2;
                    } else {
                        break;
                    }
                }
            }
            arr[i] = tmp;
            return res;
        }
    }

    public void sort(int[] a) {
        Str s = new Str(a.length + 1);
        for (int i = 0; i < a.length; i++) {
            s.put(a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = s.get();
        }
    }

    public static void main(String[] args) {
        Heap in = new Heap();
        int[] a = {1, 6, 5, 4, 3, 2};
        in.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
