/**
**Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s.
**If there isn't one, return 0 instead.
**/

class Solution {
public:
    int minSubArrayLen(int s, vector<int>& nums) {
        int n = nums.size();
        int sum = 0;
        int ans = INT_MAX;
        int j = 0;
        for (int i = 0; i < n; i++)
        {
            sum = sum + nums.at(i);
            while(sum >= s)
            {
                ans = min(ans, i - j + 1);
                sum = sum - nums.at(j);
                j++;
            }
        }
        
        if (ans == INT_MAX)
            return 0;
        else
            return ans;
    }
};