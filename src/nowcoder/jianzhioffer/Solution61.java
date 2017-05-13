package nowcoder.jianzhioffer;

/**
 * Created by nick on 2017/5/9.
 */
public class Solution61 {
    StringBuilder s = new StringBuilder();

    String Serialize(TreeNode root) {
        dfs(root);
        return s.toString();
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            s.append(" #");
            return;
        }
        s.append(" ");
        s.append(node.val);
        dfs(node.left);
        dfs(node.right);
    }

    String[] target;
    int index;

    TreeNode Deserialize(String str) {
        target = str.trim().split(" ");
        index = 0;
        return dfs2();
    }

    TreeNode dfs2() {
        String c = target[index];
        System.out.println(c);
        index++;
        if (c.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(c));
        node.left = dfs2();
        node.right = dfs2();
        return node;
    }
}
