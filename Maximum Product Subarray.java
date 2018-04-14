/**
**Find the contiguous subarray within an array (containing at least one number) which has the largest product.
**
**For example, given the array [2,3,-2,4],
**the contiguous subarray [2,3] has the largest product = 6.
**/

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        
        int[] optmax = new int[n];
        
        int[] optmin = new int[n];
        
        optmax[0] = nums[0];
        optmin[0] = nums[0];
            
        
        
        for(int i = 1; i < n; i++)
        {
            optmin[i] = Math.min(optmin[i-1]*nums[i], Math.min(nums[i], optmax[i-1]*nums[i]));
            optmax[i] = Math.max(optmax[i-1]*nums[i], Math.max(nums[i], optmin[i-1]*nums[i]));
            
        }
        
        int max = optmax[0];
        
        for (int i = 1; i < n; i++)
            max = Math.max(max,optmax[i]);
        return max;
    }
}