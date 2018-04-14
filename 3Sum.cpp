/***
**Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
**Find all unique triplets in the array which gives the sum of zero.
***/

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> fin;
        int n = nums.size();
        sort(nums.begin(), nums.end());
        
        for (int a = 0; a < n; a++)
        {
            if (a > 0)
            {
                if (nums.at(a) == nums.at(a-1))
                continue;
            }
            for (int b = a + 1; b < n; b++)
            {
                if (b > a+1)
            {
                if (nums.at(b) == nums.at(b-1))
                continue;
            }
                vector<int> ans;
                int f = -(nums.at(a)+nums.at(b));
                int l = b+1;
                int r = n-1;
                int mid;
                while (l <= r)
                {
                    mid = floor((l + r)/2);
                    if (nums.at(mid) == f)
                    {
                        ans.push_back(nums.at(a));
                        ans.push_back(nums.at(b));
                        ans.push_back(nums.at(mid));
                        break;
                    }
                    else if(nums.at(mid) < f)
                    {
                        l = mid + 1;
                    }
                    else
                    {
                        r = mid - 1;
                    }
                    
                }
                if(ans.size()>0)
                fin.push_back(ans);
            }
        }
        
        return fin;
        
    }
};