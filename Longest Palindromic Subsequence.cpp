/**
**Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
**/


class Solution {
public:
    int longestPalindromeSubseq(string s) {
        int n = s.length();
        string s1 = s;
        reverse(s1.begin(), s1.end());
        //cout << s1;
        int opt[n][n];
        
        if (s[0] == s1[0])
            opt[0][0] = 1;
        else
            opt[0][0] = 0;
        
        for (int i = 1; i<n; i++)
        {
            if (s[i] == s1[0])
                opt[i][0] = 1;
            else
                opt[i][0] = opt[i-1][0];
        }
        for (int i = 1; i<n; i++)
        {
            if (s1[i] == s[0])
                opt[0][i] = 1;
            else
                opt[0][i] = opt[0][i-1];
        }
        
        for (int i = 1 ; i < n; i++)
        {
            for (int j = 1 ; j < n; j++)
            {
                if (s[i] == s1[j])
                    opt[i][j] = 1 + opt[i-1][j-1];
                else
                    opt[i][j] = max(opt[i-1][j], opt[i][j-1]);
            }
        }
        
        int max = 0;
        
        for (int i = 0 ; i < n; i++)
        {
            for (int j = 0 ; j < n; j++)
            {
                //cout<< "opt["<<i<<"]["<<j<<"]:"<<opt[i][j] <<"\n";
                if (opt[i][j] > max)
                    max = opt[i][j];
            }
        }
        return max;
        
        
    }
};