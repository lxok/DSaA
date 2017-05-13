package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/5/8.
 */
public class Solution54 {
    int[] arr = new int[256];
    StringBuilder sb = new StringBuilder();

    //Insert one char from stringstream
    public void Insert(char ch) {
        arr[ch]++;
        if (arr[ch] <= 1) {
            sb.append(ch);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char c = 'a';
        int i;
        for (i = 0; i < sb.length(); i++) {
            c = sb.charAt(i);
            if (arr[c] <= 1) {
                break;
            }
        }
        if (i == sb.length()) {
            return '#';
        }
        return c;
    }
}
