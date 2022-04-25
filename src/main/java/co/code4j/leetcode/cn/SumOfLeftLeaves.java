package co.code4j.leetcode.cn;

/**
 * 404 - SumOfLeftLeaves
 *
 * @author YuKaiFan
 * @date 2022/4/25
 */
public class SumOfLeftLeaves {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(15, null, null);
        TreeNode t2 = new TreeNode(7, null, null);
        TreeNode t3 = new TreeNode(20, t1, t2);
        TreeNode t4 = new TreeNode(9, null, null);
        // root = [3,9,20,null,null,15,7] https://assets.leetcode.com/uploads/2021/04/08/leftsum-tree.jpg
        TreeNode root = new TreeNode(3, t4, t3);

        System.out.println(new SumOfLeftLeaves().sumOfLeftLeaves(root));
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return this.sumOfLeftLeaves(root, false);
    }

    /**
     * 累加左叶子结点之和
     * <p>
     * 左叶子节点：
     * 1. 左右孩子都为空
     * 2. 是父节点的左孩子
     *
     * @param curNode 当前结点
     * @param isLeft  是否为父节点的左孩子结点
     * @return 当前结点下的所有左叶子结点之和
     */
    public int sumOfLeftLeaves(TreeNode curNode, boolean isLeft) {
        // 递归终止条件
        if (curNode == null) {
            return 0;
        }

        // 如果是父节点的左孩子，那就判断一下是否为左叶子节点
        if (isLeft && curNode.left == null && curNode.right == null) {
            return curNode.val;
        }

        // 来到这里说明，要么不是父节点的左孩子，要么不是叶子节点，那就分别求左右子树的左叶子之和
        int left = this.sumOfLeftLeaves(curNode.left, true), right = this.sumOfLeftLeaves(curNode.right, false);

        return left + right;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
