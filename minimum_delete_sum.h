/**
This is C++ code for minimum ASCII delete sum to make two given strings equal
**/


class Solution {
public:
    
    int minimumDeleteSum(string s1, string s2) {
        
        int n = s1.size() + 1;
        int m = s2.size() + 1;
        int opt[n][m];
        
        opt[0][0] = 0;
        
        for (int i = 1; i<n; i++)
        {
            opt[i][0] = (int)s1[i-1] + opt[i-1][0];
        }
        
        for (int i = 1; i<m; i++)
        {
            opt[0][i] = (int)s2[i-1] + opt[0][i-1];
        }
        
        for (int i = 1; i<n; i++)
        {
            for (int j = 1; j<m; j++)
            {
                if (s1[i-1] == s2[j-1])
                    opt[i][j] = opt[i-1][j-1];
                else
                    opt[i][j] = min((opt[i-1][j] + (int)s1[i-1]), (opt[i][j-1] + (int)s2[j-1]));
            }
        }
        
        return opt[n-1][m-1];
    }
};