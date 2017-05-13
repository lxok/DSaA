package data_structure;

/**
 * Created by nick on 2017/4/21.
 */
public class ReverseLinkedList {
    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node pri = head;
        Node index = head.next;
        head.next = null;
        Node remain;
        while (true) {
            remain = index.next;
            index.next = pri;
            pri = index;
            if (remain == null) {
                break;
            } else {
                index = remain;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        ReverseLinkedList rl = new ReverseLinkedList();
        Node n1 = rl.new Node(1);
        Node n2 = rl.new Node(2);
        Node n3 = rl.new Node(3);
        n1.next = n2;
        n2.next = n3;
        printLinkedList(n1);
        printLinkedList(rl.reverse(n1));
    }

    static void printLinkedList(Node n) {
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }
}
