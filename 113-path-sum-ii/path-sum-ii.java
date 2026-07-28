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

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        fun(root, targetSum, 0, new ArrayList<>());

        return res;
    }

    public void fun(TreeNode root, int target, int sum, List<Integer> path) {

        if (root == null) {
            return;
        }

       
        sum += root.val;
        path.add(root.val);

       
        if (root.left == null && root.right == null) {

            if (sum == target) {
                res.add(new ArrayList<>(path)); 
            }

            path.remove(path.size() - 1); 
            return;
        }

        
        fun(root.left, target, sum, path);
        fun(root.right, target, sum, path);

       
        path.remove(path.size() - 1);
    }
}