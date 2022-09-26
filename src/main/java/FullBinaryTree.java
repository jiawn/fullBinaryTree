import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public class FullBinaryTree {

    public static void main(String[] args) {
        TreeNode node = buildFullBinaryTree(8);
    }

    /**
     * 根据二叉树深度生成满二叉树
     *
     * @param height 二叉树的深度
     * @return
     */
    public static TreeNode buildFullBinaryTree(int height) {
        TreeNode<Integer> root = new TreeNode<>();
        root.val = 1;
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        //一层一层取生成
        for (int i = 1; i < height; i++) {
            int size = (int) Math.pow(2, i - 1);
            //根据父节点生成子节点
            for (int j = 0; j < size; j++) {
                TreeNode<Integer> parent = queue.poll();
                TreeNode<Integer> left = new TreeNode<>();
                left.val = parent.val * 2;
                left.parent = parent;
                TreeNode<Integer> right = new TreeNode<>();
                right.val = (parent.val * 2) + 1;
                right.parent = parent;
                parent.left = left;
                parent.right = right;
                queue.add(left);
                queue.add(right);
            }
        }
        queue.clear();
        return root;
    }

}
