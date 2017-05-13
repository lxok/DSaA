package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/5/8.
 */
public class Solution57 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            return dfs(pNode.right);
        }
        if (pNode.next == null) {
            return null;
        }
        TreeLinkNode father = pNode.next;
        TreeLinkNode son = pNode;
        while (father != null) {
            if (father.left == son) {
                return father;
            }
            father = father.next;
            son = son.next;
        }
        return null;
    }

    public TreeLinkNode dfs(TreeLinkNode node) {
        if (node.left == null) {
            return node;
        }
        return dfs(node.left);
    }
}
