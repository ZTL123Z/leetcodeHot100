import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class code40_二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        /**
         * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。
         * res 是一个二维列表，每个元素是一个列表，表示当前层的节点值。
         * queue 是一个队列，用于存储当前层的节点。
         * curSize 是当前层的节点数量。
         * curLevel 是当前层的节点值列表。
         */
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < curSize; i++) {
                TreeNode node = queue.poll();
                curLevel.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(curLevel);
        }
        return res;
    }
}
