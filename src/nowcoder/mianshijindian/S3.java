package nowcoder.mianshijindian;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by nick on 2017/6/1.
 */
public class S3 {
    public boolean checkSam(String stringA, String stringB) {
        if (stringA == null && stringB == null) {
            return true;
        }
        if (stringA == null || stringB == null) {
            return false;
        }
        if (stringA.length() == 0) {
            if (stringB.length() == 0) {
                return true;
            } else {
                return false;
            }
        }
        Map<Character, Integer> m = new HashMap();
        char c;
        for (int i = 0; i < stringA.length(); i++) {
            c = stringA.charAt(i);
            if (m.containsKey(c)) {
                m.put(c, m.get(c) + 1);
            } else {
                m.put(c, 1);
            }
        }
        for (int i = 0; i < stringB.length(); i++) {
            c = stringB.charAt(i);
            if (m.containsKey(c)) {
                m.put(c, m.get(c) - 1);
            } else {
                return false;
            }
        }
        Set<Character> key = m.keySet();
        Iterator<Character> i = key.iterator();
        while (i.hasNext()) {
            if (m.get(i.next()) != 0) {
                return false;
            }
        }
        return true;
    }
}
