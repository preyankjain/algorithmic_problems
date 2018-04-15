/**
** Given a binary tree, return the preorder traversal of its nodes' values.
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
    List<Integer> list = new ArrayList<>();
    
    
    private void preorder(TreeNode root){
        list.add(root.val);
        if (root.left != null)
            preorder(root.left);
        if (root.right != null)
            preorder(root.right);
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return list;
        preorder(root);
        return list;
    }
}