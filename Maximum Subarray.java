/**
**Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
**/


class Solution {
    public int maxSubArray(int[] nums) {
        int[] opt = new int[nums.length];
        opt[0] = nums[0];
        int max = opt[0];
        for(int i = 1; i < nums.length; i++){
            opt[i] = Math.max(nums[i], opt[i-1] + nums[i]);
            max = Math.max(max, opt[i]);
        }
        
        return max;
    }
}