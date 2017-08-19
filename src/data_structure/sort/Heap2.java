package data_structure.sort;

/**
 * Created by nick on 2017/7/15.
 */
public class Heap2 {
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        Arr sorter = new Arr(arr.length);
        for (int i = 0; i < arr.length; i++) {
            sorter.put(arr[i]);
        }
        System.out.println("put over");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sorter.get();
            System.out.println(i + ":" + arr[i]);
        }
    }

    class Arr {
        int[] arr;
        int index;
        Arr(int size) {
            arr = new int[size + 1];
            index = 1;
        }

        void put(int val) {
            arr[index] = val;
            int i = index;
            int tmp = arr[i];
            index++;
            while (i / 2 >= 1 && arr[i / 2] > val) {
                arr[i] = arr[i / 2];
                i /= 2;
            }
            arr[i] = tmp;
        }

        int get() {
            if (index <= 1) {
                return Integer.MIN_VALUE;
            }
            int res = arr[1];
            int val = arr[index - 1];
            index--;
            int i = 1;
            while (i * 2 <= index - 1) {
                if (i * 2 + 1 <= index - 1) {
                    if (val > arr[i * 2]) {
                        if ( val > arr[i * 2 + 1]) {
                            if (arr[i * 2] < arr[i * 2 + 1]) {
                                arr[i] = arr[i * 2];
                                i *= 2;
                            } else {
                                arr[i] = arr[i * 2 + 1];
                                i = i * 2 + 1;
                            }
                        } else {
                            arr[i] = arr[i * 2];
                            i *= 2;
                        }
                    } else if (val > arr[i * 2 + 1]) {
                        arr[i] = arr[i * 2 + 1];
                        i = i * 2 + 1;
                    } else {
                        break;
                    }
                } else {
                    if (val > arr[i * 2]) {
                        arr[i] = arr[i * 2];
                        i *= 2;
                    } else {
                        break;
                    }
                }
            }
            arr[i] = val;
            return res;
        }
    }

    public static void main(String[] args) {
        Heap2 sort = new Heap2();
        int[] a = {1, 6, 5, 4, 3, 9, 7, 6, 2};
        sort.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
