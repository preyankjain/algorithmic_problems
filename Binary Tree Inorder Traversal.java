/**
** Given a binary tree, return the inorder traversal of its nodes' values.
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
    List<Integer> list = new ArrayList<Integer>();
    
    private void inorderTraversalHelper(TreeNode root){
        if(root.left != null)
            inorderTraversalHelper(root.left);
        list.add(root.val);
        if(root.right != null)
            inorderTraversalHelper(root.right);
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
            return list;
        inorderTraversalHelper(root);
        return list;
    }
}