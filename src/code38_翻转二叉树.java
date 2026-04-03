public class code38_翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        TreeNode dummpy = root;
        reverse(root);
        return dummpy;
    }
    private void reverse(TreeNode root) {
        if(root == null) {
            return;
        }
        TreeNode L = root.left;
        TreeNode R = root.right;
        root.left = R;
        root.right = L;
        reverse(root.left);
        reverse(root.right);
    }
}
