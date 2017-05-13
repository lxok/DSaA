package nowcoder.jianzhioffer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nick on 2017/4/29.
 */
public class Solution25 {
    class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode i = pHead;
        RandomListNode h = new RandomListNode(-1);
        RandomListNode j = h;
        while (i != null) {
            RandomListNode t = new RandomListNode(i.label);
            map.put(i, t);
            j.next = t;
            j = t;
            i = i.next;
        }
        i = pHead;
        j = h.next;
        while (i != null) {
            j.random = map.get(i.random);
            i = i.next;
            j = j.next;
        }
        return h.next;
    }
}
