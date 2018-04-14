/**
**Given a binary tree, flatten it to a linked list in-place.
**/


/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:

    void flatten(TreeNode* root) {
        if (root != NULL)
        {
            vector<int> nums;
            int j = 0;
            vector<TreeNode*> vec;
            TreeNode* root2 = root;
            while (vec.size() != 0 || root != NULL)
            {
                nums.push_back(root->val);
                if (vec.size() == 0 && root->right == NULL && root->left == NULL)
                    break;
                if (root->left !=NULL)
                {
                    if (root->right !=NULL)
                        vec.push_back(root);
                    root = root->left;
                }
                else if(root->right !=NULL)
                {
                    root = root->right;
                }
                else
                {
                    if (vec.size() != 0)
                    {
                        root = vec.back()->right;
                        vec.pop_back();
                    }
                }
            }
            
            if (nums.size() != 0)
            root2->val = nums.at(0);
            
            for (int i = 1; i < nums.size(); i++)
            {
                TreeNode* n = new TreeNode(nums.at(i));
                root2->left = NULL;
                root2->right = n;
                root2 = root2->right;
            }
        }
        
    }
};