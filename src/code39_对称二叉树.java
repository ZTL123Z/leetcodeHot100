import java.util.ArrayList;
import java.util.List;

public class code39_对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        /**
         * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
         * 全部为true就是对称的，否则就是不对称的。
         */
        return check(root.left, root.right);
    }
    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
