/**
**Given an array nums of integers, you can perform operations on the array.
**
**In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.
**
**You start with 0 points. Return the maximum number of points you can earn by applying such operations.
**/

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        if (nums.size() == 0)
            return 0;
        else if (nums.size() == 1)
            return nums.at(0);
        else
        {
            int n = nums.size();
            sort(nums.begin(), nums.end());
            int m = nums.at(n-1);
            int sumed[m+1];
            for(int i = 0; i <=m; i++)
            {
                sumed[i] = 0;
            }
            int j = nums.at(0);
            int sum = 0;
            for (int i = 0; i < n; i++)
            {
                if (nums.at(i) == j)
                {
                    sum = sum + j;
                }
                
                if (i < n-1)
                {
                    if (nums.at(i+1) != nums.at(i))
                    {
                        sumed[j] = sum;
                        sum = 0;
                        j = nums.at(i+1);
                    }
                }
                else
                {
                    sumed[j] = sum;
                }
            }
            
            int opt[m+1];
            opt[1] = sumed[1];
            if(sumed[2] > sumed[1])
                opt[2] = sumed[2];
            else
                opt[2] = sumed[1];
            for (int i = 3; i <= m; i++)
            {
                if (opt[i-1] > (opt[i-2] + sumed[i]))
                    opt[i] = opt[i-1];
                else
                    opt[i] = opt[i-2] + sumed[i];
            }
        
            return opt[m];
        }       
    }
};