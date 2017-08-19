package nowcoder.mianshijindian;

/**
 * Created by nick on 2017/6/26.
 */
public class Distance {
    public int getDistance(String[] article, int n, String x, String y) {
        int xIndex = -1, yIndex = -1;
        int dis = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (article[i].equals(x)) {
                xIndex = i;
                if (yIndex != -1) {
                    dis = Math.min(dis, Math.abs(xIndex - yIndex));
                }
            } else if (article[i].equals(y)) {
                yIndex = i;
                if (xIndex != -1) {
                    dis = Math.min(dis, Math.abs(xIndex - yIndex));
                }
            }
        }
        if (dis == Integer.MAX_VALUE) {
            return -1;
        }
        return dis;
    }
}
