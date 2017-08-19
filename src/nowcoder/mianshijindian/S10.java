package nowcoder.mianshijindian;

/**
 * Created by nick on 2017/6/11.
 */
public class S10 {
    public boolean removeNode(ListNode pNode) {
        if (pNode.next == null) {
            return false;
        }
        ListNode pri = pNode;
        ListNode index = pNode.next;
        pri.val = index.val;
        pri.next = index.next;
        return true;
    }
}
