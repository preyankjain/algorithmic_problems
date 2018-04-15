/**
**Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
**
**Solve it without division and in O(n).
**
**For example, given [1,2,3,4], return [24,12,8,6].
**/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] outp = new int[n];
        outp[0] = 1;
        for (int i = 1; i < n; i++){
            outp[i] = outp[i-1]*nums[i-1];
        }
        
        int right = 1;
        for (int i = n-1; i >= 0; i--){ 
            outp[i] = outp[i]*right;
            right *= nums[i];
        }
        return outp;
    }
}