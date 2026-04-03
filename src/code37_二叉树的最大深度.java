public class code37_二叉树的最大深度 {
    /**
     * 假设我们知道对于该节点的左儿子向下遍历经过最多的节点数 L （即以左儿子为根的子树的深度）
     * 和其右儿子向下遍历经过最多的节点数 R （即以右儿子为根的子树的深度），
     * 那么以该节点为起点的路径经过节点数的最大值即为 L+R+1 。
     */
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        depth(root);
        return ans;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L + R + 1);
        return Math.max(L, R) + 1;
    }
}
