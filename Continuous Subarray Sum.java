/***
**Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray 
**of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.
***/

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        
        int sum = 0;
        
        for (int i = 0; i < n; i++){
            sum = nums[i];
            for (int j = i+1; j < n; j++){
                sum += nums[j];
                if (k == 0 && sum == 0)
                    return true;
                else if (k != 0 && sum%k == 0)
                    return true;
            }
        }
        return false;
    }
}