/**
**Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
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
    List<List<Integer>> listList = new ArrayList<List<Integer>>();
    Map<Integer,List<Integer>> map = new HashMap<>();
    
    private void order(TreeNode node, int h){
        List<Integer> l;
        if (map.containsKey(h))
            l = map.get(h);
        else
            l = new ArrayList<Integer>();
        l.add(node.val);
        map.put(h, l);
        if(node.left != null)
            order(node.left, h+1);
        if(node.right != null)
            order(node.right, h+1);
    }
    
    private void populateList(){
        for (List<Integer> l : map.values())
           listList.add(l); 
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return listList;
        order(root, 0);
        populateList();
        return listList;
    }
}