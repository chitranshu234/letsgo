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
    int preindex=0;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i =0; i< inorder.length; i++){          
            map.put(inorder[i],i);

        }
        return construct(preorder,0,inorder.length-1);
        
    }
    public TreeNode construct(int[] preorder, int start, int end){
        if(start>end)
            return null;
        TreeNode root = new TreeNode(preorder[preindex]);
        preindex++;
        int index=map.get(root.val);
        root.left = construct(preorder, start, index-1);
        root.right = construct(preorder, index+1, end);
        return root;
    }
}