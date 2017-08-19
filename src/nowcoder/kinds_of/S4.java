package nowcoder.kinds_of;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by nick on 2017/7/12.
 */
public class S4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] sArr = s.split(",");
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < sArr.length; i++) {
                list.add(Integer.valueOf(sArr[i].trim()));
            }
            System.out.println(print(list));
        }
    }

    public static String print(LinkedList<Integer> list) {
        ArrayList<Integer> out = new ArrayList<>();
        LinkedList<Integer> pri = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            pri.add(i);
        }
        while (list.size() != 0) {
            int first = list.pollFirst();
            int priIndex = pri.pollFirst();
            int max = first;
            int index = -1;
            for (int j = 0; j < list.size(); j++) {
                int tmp = list.get(j);
                if (tmp > max) {
                    index = j;
                }
            }
            if (index != -1) {
                list.offerLast(first);
                pri.offerLast(priIndex);
            } else {
                out.add(priIndex);
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < out.size(); i++) {
            if (i == 0) {
                res.append(out.get(i));
            } else {
                res.append(", ");
                res.append(out.get(i));
            }
        }
        return res.toString();
    }
}
