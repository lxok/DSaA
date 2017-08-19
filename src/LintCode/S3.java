package LintCode;

/**
 * Created by nick on 2017/7/22.
 */


public class S3 {
    public String serialize(TreeNode root) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    public void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(",#");
            return;
        }
        sb.append(",");
        sb.append(root.val);
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    String[] tmp;
    int i;

    public TreeNode deserialize(String data) {
        // write your code here
        if (data == null || data.length() == 0) {
            return null;
        }
        tmp = data.split(",");
        i = 1;
        return dfs2();
    }

    public TreeNode dfs2() {
        if (tmp[i].equals("#")) {
            i++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(tmp[i]));
        i++;
        node.left = dfs2();
        node.right = dfs2();
        return node;
    }

    public static void main(String[] args) {
        S3 s = new S3();
        String test = ",1,2,3";
        String[] arr = test.split(",");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
