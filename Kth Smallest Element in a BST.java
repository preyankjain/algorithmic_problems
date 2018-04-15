/**
**Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
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
    
    private void inorder(TreeNode root){
        if (root.left != null)
            inorder(root.left);
        list.add(root.val);
        if (root.right != null)
            inorder(root.right);
    }
    
    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return list.get(k-1);
    }
}