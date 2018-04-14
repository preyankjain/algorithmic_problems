/**
**Your are given an array of positive integers nums.
**
**Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.
**/

class Solution {
public:
    int numSubarrayProductLessThanK(vector<int>& nums, int k) {
        if (k == 0)
            return 0;
        else
        {
            int prod = 1;
            int j = 0;
            int sum = 0;
            int n = nums.size();
            for (int i = 0; i < n; i++)
            {
                prod = prod * nums.at(i);
                while(prod >= k && j < n)
                {
                    prod = prod/nums.at(j);
                    j++;
                }
                if (prod<k)
                sum = sum + i - j + 1;
            }
            return sum;
        }
    }
};