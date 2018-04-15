/**
**Given a binary tree, determine if it is height-balanced.
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
    
    private int height(TreeNode node){
        if(node == null)
            return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int diff = Math.abs(height(root.left) - height(root.right));
        return (diff <= 1 && isBalanced(root.right) && isBalanced(root.left));
    }
}