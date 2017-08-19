package nowcoder.mianshijindian;

/**
 * Created by nick on 2017/6/15.
 */
public class S27 {
    public String printBin(double num) {
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        double rem = num;
        double flag = 0.5;
        for (int i = 0; i < 32; i++) {
            if (rem >= flag) {
                sb.append("1");
                rem -= flag;
            }  else {
                sb.append("0");
            }
            if (rem == 0) {
                break;
            }
            flag /= 2;
        }
        if (rem == 0) {
            return sb.toString();
        }
        return "Error";
    }
}
