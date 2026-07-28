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
     int res=0;
    public int sumNumbers(TreeNode root) {
         fun(root, 0);

        return res;
        
    }
    public void fun(TreeNode root, int sum) {

        if (root == null) {
            return;
        }

        sum = sum*10 +  root.val;

        // Leaf node
        if (root.left == null && root.right == null) {

           res = res+sum;

            
        }

        fun(root.left, sum);
        fun(root.right, sum);
    }
}