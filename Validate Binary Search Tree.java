/**
**Given a binary tree, determine if it is a valid binary search tree (BST).
**
**Assume a BST is defined as follows:
**
**The left subtree of a node contains only nodes with keys less than the node's key.
**The right subtree of a node contains only nodes with keys greater than the node's key.
**Both the left and right subtrees must also be binary search trees.
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
    
    
    private void isValidBSTHelper(TreeNode root){
        if (root.left != null)
            isValidBSTHelper(root.left);
        list.add(root.val);
        if (root.right != null)
            isValidBSTHelper(root.right);
    }
    
    public boolean isValidBST(TreeNode root) {
        if (root != null)
            isValidBSTHelper(root);
        else
            return true;
        for (int i = 0; i < list.size() - 1; i++){
            if (list.get(i) >= list.get(i+1))
                return false;
        }
        
        return true;
    }
}