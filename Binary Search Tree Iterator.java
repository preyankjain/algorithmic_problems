/**
**Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
**
**Calling next() will return the next smallest number in the BST.
**/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    
    List<Integer> list;
    Iterator<Integer> it;

    private void fillList(TreeNode root){
        if (root.left != null)
            fillList(root.left);
        list.add(root.val);
        if (root.right != null)
            fillList(root.right);
    }
    
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        if (root != null)
            fillList(root);
        it = list.iterator();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return it.hasNext();
    }

    /** @return the next smallest number */
    public int next() {
        return it.next();
    }
}