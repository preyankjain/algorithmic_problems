/***
This is a C++ code for finding the Longest Palindromic Substring from a given String.
***/

// Given: A String s.
// Returns: the longest Substring Palindromic substring of s.
// Example:  longestPalindrome("iammadam") => "madam"
string longestPalindrome(string s) 
{
    int n = s.length();
    string s1 = s;
    reverse(s1.begin(), s1.end());
    int opt[n][n];
    string ans;
    int j = 0;
    
    cout << s;
    cout << s1;
    for (int i = 0;i<n;i++)
    {
        if (s[0] == s1[i])
            opt[0][i] = 1;
        else
            opt[0][i] = 0;
    }
    
    for (int i = 0;i<n;i++)
    {
        if (s1[0] == s[i])
            opt[i][0] = 1;
        else
            opt[i][0] = 0;
    }
    
    for (int i = 1 ; i<n ; i++)
    {
        for(int j = 1; j<n; j++)
        {
            if (s[i] == s1[j])
                opt[i][j] = opt[i-1][j-1] + 1;
            else
                opt[i][j] = 0;
        }
    }
    
    int max = opt[0][0];
    int ind = 0;
    for (int i = 1 ; i<n ; i++)
    {
        for(int j = 1; j<n; j++)
        {
            if (opt[i][j] > max)
            {
                if (i-opt[i][j]+1 == n - j - 1 )
                {max = opt[i][j];
                ind = i;}
            }
            
        }
    }
    
    ans.assign(s,ind-max+1,max);
    return ans;
    
    
}