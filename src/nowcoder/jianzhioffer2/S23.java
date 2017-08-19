package nowcoder.jianzhioffer2;

/**
 * Created by nick on 2017/7/8.
 */
public class S23 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode i = pHead;
        RandomListNode n;
        while (i != null) {
            n = i.next;
            RandomListNode tmp = new RandomListNode(i.label);
            i.next = tmp;
            tmp.next = n;
            i = n;
        }
        i = pHead;
        while (i != null) {
            if (i.random != null) {
                i.next.random = i.random.next;
            }
            i = i.next.next;
        }
        i = pHead;
        RandomListNode tHead = new RandomListNode(-1);
        RandomListNode pri = tHead;
        while (i != null) {
            pri.next = i.next;
            pri = pri.next;
            i = i.next.next;
        }
        return tHead.next;
    }

    public static void main(String[] args) {
        S23 s = new S23();
        RandomListNode n1 = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        RandomListNode n3 = new RandomListNode(3);
        n1.next = n2;
        n2.next = n3;
        n1.random = n3;
        n2.random = n1;
        n3.random = n2;
        RandomListNode res = s.Clone(n1);
        while (res != null) {
            System.out.println(res.label);
            System.out.println(res.random.label);
            res = res.next;
        }
    }
}
