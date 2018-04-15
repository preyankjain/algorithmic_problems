/**
**Given a binary tree, find its minimum depth.
**
**The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
**/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int right = minDepth(root.right);
        int left = minDepth(root.left);
        if (left == 0 || right == 0)
            return left + right + 1;
        else
            return Math.min(left,right) + 1;
    }
}