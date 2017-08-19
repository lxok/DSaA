package LintCode;

/**
 * Created by nick on 2017/8/2.
 */
public class S4 {
    public String minWindow(String source, String target) {
        // write your code
        if (source == null || source.length() == 0 || target == null || target.length() == 0) {
            return "";
        }
        int[] tar = new int[255];
        char c;
        for (int i = 0; i < target.length(); i++) {
            c = target.charAt(i);
            tar[c]++;
        }
        int count = 0;
        int l = 0;
        int r;
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        int[] src = new int[255];
        for (r = 0; r < source.length(); r++) {
            c = source.charAt(r);
            if (tar[c] == 0) {
                continue;
            }
            if (src[c] < tar[c]) {
                count++;
            }
            src[c]++;
            while (count == target.length()) {
                if (r - l + 1 < min) {
                    start = l;
                    end = r;
                    min = r - l + 1;
                }
                c = source.charAt(l);
                if (tar[c] == 0) {
                    l++;
                    continue;
                }
                src[c]--;
                if (src[c] < tar[c]) {
                    count--;
                }
                l++;
            }
        }
        if (min == Integer.MAX_VALUE) {
            return "";
        }
        return source.substring(start, end + 1);
    }

    public static void main(String[] args) {
        S4 s = new S4();
        String res = s.minWindow("abc", "a");
        System.out.println(res);
    }
}
