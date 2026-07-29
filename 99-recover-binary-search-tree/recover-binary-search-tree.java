class Solution {

    TreeNode prev = null;

    TreeNode g1First = null;
    TreeNode g1Second = null;

    TreeNode g2First = null;
    TreeNode g2Second = null;
    int galat =0;
    public void recoverTree(TreeNode root) {

        inorder(root);

        if (galat==1) {
            // Only one violation (adjacent swap)

            int temp = g1First.val;
            g1First.val = g1Second.val;
            g1Second.val = temp;

        } else {
            // Two violations (non-adjacent swap)

            int temp = g1First.val;
            g1First.val = g2Second.val;
            g2Second.val = temp;
        }
    }

    public void inorder(TreeNode root) {

        if (root == null)
            return;

        inorder(root.left);

        if (prev == null) {

            prev = root;

        } else {

            if (root.val < prev.val) {

                if (galat==0) {

                    g1First = prev;
                    g1Second = root;
                    galat++;

                } else {

                    g2First = prev;
                    g2Second = root;
                    galat++;
                }
            }

            prev = root;
        }

        inorder(root.right);
    }
}