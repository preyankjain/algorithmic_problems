/**
**Given an unsorted array of integers, find the length of longest increasing subsequence.
**/

class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int len = nums.size();
        int m;
        if (len > 0)
        {
            int ar[len];
            int max;
            ar[0] = 1;
            for (int i = 1; i < len; i++)
            {
                max = 1;
                ar[i] = 1;
                for (int j = i-1; j >= 0; j--)
                {
                    if (nums.at(j) < nums.at(i))
                    {
                        if (max < ar[j] + 1)
                            max = ar[j] + 1;
                    }
                }
                ar[i] = max;
            }
            m = ar[0];
            for (int i = 1; i <  len; i++)
            {
                if (ar[i] > m)
                    m = ar[i];
            }
        }
        
            else
                m = 0;
        return m;
    }
};