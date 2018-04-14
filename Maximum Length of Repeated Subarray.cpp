/**
**Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
**/


class Solution {
public:
    int findLength(vector<int>& A, vector<int>& B) {
        
        int opt[A.size()][B.size()];
        for (int i = 0; i < A.size(); i++)
        {
            if (A[i] == B[B.size() - 1])
            opt[i][B.size() - 1] = 1;
            else
            opt[i][B.size() - 1] = 0;    
        }
        
        for (int j = 0; j < B.size(); j++)
        {
            if (B[j] == A[A.size() - 1])
            opt[A.size() - 1][j] = 1;
            else
            opt[A.size() - 1][j] = 0;    
        }
        
        for (int i = A.size() - 2; i >= 0; i --)
        {
            for (int j = B.size() - 2; j >= 0; j --)
            {
                if (A[i] == B[j])
                {
                    opt[i][j] = 1 + opt[i+1][j+1];
                }
                else
                {
                    opt[i][j] = 0;
                }
            }
        }
        
        int max = opt[A.size() - 1][B.size() - 1];
        
        for (int i = A.size() - 2; i >= 0; i --)
        {
            for (int j = B.size() - 2; j >= 0; j --)
            {
                if (opt[i][j] > max)
                {
                    max = opt[i][j];
                }
            }
        }
        
        return max;
    }
};