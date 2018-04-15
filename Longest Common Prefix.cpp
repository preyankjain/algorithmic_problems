/**
**Write a function to find the longest common prefix string amongst an array of strings.
**/

class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        int n = strs.size();
        if (n == 0)
            return "";
        if (n == 1)
            return strs.at(0);
        int ctr = 0;
        char ch;
        bool flag = true;
        while(flag == true)
        {
        for (int i = 1 ; i< n; i++)
        {
            ch = strs.at(0)[ctr];
            if(strs.at(i)[ctr] != ch)
            {
                flag = false;
                break;
            }
        }
            if (flag == true)
            ctr++;
        }
        
        if (ctr == 0)
            return "";
        //else if (ctr == n-1)
          //  ctr++;

        string ans(strs.at(0), 0, ctr); 
        
        return ans;
    }
};