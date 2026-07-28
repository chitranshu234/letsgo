/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    boolean res = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {

        fun(root, 0, targetSum);

        return res;
    }

    public void fun(TreeNode root, int sum, int target) {

        if (root == null) {
            return;
        }

        sum = sum + root.val;

        // Leaf node
        if (root.left == null && root.right == null) {

            if (sum == target) {
                res = true;
            }

            return;
        }

        fun(root.left, sum, target);
        fun(root.right, sum, target);
    }
}